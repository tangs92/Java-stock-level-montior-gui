/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursework234;

import java.io.Serializable;
import java.util.*;
import java.io.*;
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ThreadedServer implements Serializable {

    public static Connection connect() {//连接数据库
        String url = "jdbc:mysql://localhost:3306/coursework";
        String username = "tpoem";
        String password = "tpoem";
        Connection conn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(myJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(myJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (conn != null) {

            // System.out.println("\n Connect to Datebase Successful!");
        } else {
            JOptionPane.showMessageDialog(null, "Fail to connect database!");
            //System.out.println("\n Fail to connect database!");
        }

        return conn;
    }

    public static void main(String[] args) {
        try {
            int connectionCount = 0;
            Thread connThread = null;
            Connection connect = null;
            System.out.println("Server starting");
            
            ServerSocket ss = new ServerSocket(2000);
            while (true) {
                try {
                    Socket s = ss.accept();
                    connectionCount++;
                    System.out.println("Connection " + connectionCount + " made");
                    connect = connect();
                    connThread = new Thread(new ConnectionCJB(s,connect,ss));
                    connThread.start();
                } catch (IOException ex) {
                    Logger.getLogger(ThreadedServer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ThreadedServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
