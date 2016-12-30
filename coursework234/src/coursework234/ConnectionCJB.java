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


public class ConnectionCJB implements Runnable, Serializable {

    private Socket s;
    private Connection connect;
    private ServerSocket ss;
    private ObjectInputStream objIS;
    private ObjectOutputStream objOS;

    ConnectionCJB(Socket s, Connection connect, ServerSocket ss) {
        this.s = s;
        this.connect = connect;
        this.ss = ss;
    }

    public void writeIn(Object obj) throws IOException {
        this.objOS.writeObject(obj);
        this.objOS.flush();

    }

    public void run() {
        purchaseOrder purchaseOrder = new purchaseOrder();
        try {

            int connectionCount = 0;
            String keyRead = "";
//            this.ss = new ServerSocket(2000);

            //     this.s = ss.accept();
            connectionCount++;
            System.out.printf("Connection " + connectionCount + " made ");
            objIS = new ObjectInputStream(this.s.getInputStream());
            objOS = new ObjectOutputStream(this.s.getOutputStream());
            System.out.printf("System set up\n");
            while (true) {
                try {
                    purchaseOrder = (purchaseOrder) this.objIS.readObject();//读客户端送来的对象
                    keyRead = purchaseOrder.getKey();//读按下的键值
                    System.out.printf("User press " + keyRead + " button\n");
                } catch (ClassNotFoundException ex) {

                    System.out.printf("\nCan not get client's data Obj", ex);
                    Logger.getLogger(ConnectionCJB.class.getName()).log(Level.SEVERE, null, ex);
                    System.exit(0);
                } catch (IOException ex) {
                    System.out.println("Client has closed");
                }

                if (keyRead.equals("jbInsertPO")) {
                    //插入函数
                }

                if (keyRead.equals("jbDeletePO")) {
                    //删除函数
                }

                if (keyRead.equals("jbUpdatePO")) {
                    //修改函数
                }

                if (keyRead.equals("jbPrint")) {
                    //打印函数
                }

                if (keyRead.equals("jbRefreshPO")) {
                    //刷新函数
                    purchaseOrder.refresh(connect);
                    writeIn(purchaseOrder);
                    System.out.println("Refresh finish");
                    break;

                }

            }
            objIS.close();
            objOS.close();
            System.out.println("Client has closed");

        } catch (IOException ex) {

            System.out.println("Client has closed");
            //Logger.getLogger(ConnectionCJB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
