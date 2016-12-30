/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursework123;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class managerTable {

    public Connection connect() {//连接数据库

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(myJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        String url = "jdbc:mysql://localhost:3306/coursework";
        String username = "root";
        String password = "";
        Connection conn = null;

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
///*
//    public void delRecord(String ID) {
//
//        try {//删除
//
//            // TODO add your handling code here:
//            //Connection connect = connect();
//            managerTable mt = new managerTable();
//            Connection connect = mt.connect();
//            Statement statement = connect.createStatement();
//            String sql = "DELETE FROM purchaseorder where PurchaseOrderID=" + "'" + ID + "'" + ";";
//            statement.executeUpdate(sql);
//
//            JOptionPane.showMessageDialog(null, "Delete Finish!");
//
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, " Delete Error, this record has relationship with other table.Please delete related record in other tables first!");
//            //Logger.getLogger(myJFrame.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
//*/
//    public void refresh(DefaultTableModel model) {
//
//        Connection connect = connect();
//
//        try {//查看表
//
//            Statement statement = connect.createStatement();
//            ResultSet result = statement.executeQuery("SELECT * from purchaseorder");
//            ResultSetMetaData rsmd = result.getMetaData();
//            //DefaultTableModel model = (DefaultTableModel) jtPurchase.getModel();
//
//            while (model.getRowCount() > 0) {
//                model.removeRow(model.getRowCount() - 1);
//            }
//            while (result.next()) {
//
//                //  columnHeads.add(rsmd.getColumnName(i));
//                model.addRow(new Object[]{
//                    result.getObject(1),
//                    result.getObject(2),//Display Data into Jtable
//                    result.getObject(3),
//                    result.getObject(4),
//                    result.getObject(5),
//                    result.getObject(6),}
//                );
//
//            }
//
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Refresh Fail! Try the connection between client and database!");
//            //  Logger.getLogger(myJFrame.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }

    public java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

    public java.util.Date concevtStringToDate(String dateInString) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        Date date = null;
        try {

            date = formatter.parse(dateInString);

        } catch (ParseException e) {
        }
        return date;
    }

    public int checkDate(String dateCreated, String dateDelivery) {
        int checkDate = 1;
        try {
            Date date1 = concevtStringToDate(dateCreated);
            Date date2 = concevtStringToDate(dateDelivery);//date1<date2-----  -1 
            checkDate = date1.compareTo(date2);

            if (checkDate <= 0) {

            } else {
                JOptionPane.showMessageDialog(null, "Date Created should be lower than Expected Delivery Date");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Date input error, please try again!");
        }
//date1 = date2 -------  0 
        //date1>date2 -------1

        return checkDate;
    }

}
