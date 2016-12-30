/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursework234;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;


public class purchaseOrder implements Serializable {

    private String key = "";
    private ArrayList<String> PurchaseOrderInput = new ArrayList<>();
    private ArrayList<String> refreshResult = new ArrayList<>();

    public ArrayList<String> getRefreshResult() {
        return this.refreshResult;
    }

    public void cleanRefreshResult() {
        this.refreshResult.clear();
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }

    public void setPurchaseOrderInput(JTextField jtfPurchaseOrderID, JTextField jtfDateCreated, JTextField jtfExpectedDeliveryDate, JTextField jtfSupplier, JComboBox jcbStatus, JComboBox jcbCompletedStatus) {

        this.PurchaseOrderInput.add(0, jtfPurchaseOrderID.getText());
        String DateCreated = jtfDateCreated.getText();
        String ExpectedDeliveryDate = jtfExpectedDeliveryDate.getText();
        int checkDate = checkDate(DateCreated, ExpectedDeliveryDate);

        if (checkDate <= 0) {//校验成功,添加数据
            this.PurchaseOrderInput.add(1, DateCreated);
            this.PurchaseOrderInput.add(2, ExpectedDeliveryDate);
        } else {//校验不成功,添加默认数据
            this.PurchaseOrderInput.add(1, "2015-01-01");
            this.PurchaseOrderInput.add(2, "2015-01-02");
        }
        this.PurchaseOrderInput.add(3, jtfSupplier.getText());
        this.PurchaseOrderInput.add(4, jcbStatus.getSelectedItem().toString());
        this.PurchaseOrderInput.add(5, jcbCompletedStatus.getSelectedItem().toString());
    }

    public ArrayList<String> getPurchaseOrderInput() {
        return this.PurchaseOrderInput;
    }

    public void clearItem() {
        this.PurchaseOrderInput.clear();
    }

    /**
     * ***********************数据校验*****************************************
     */
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

    public void refresh(Connection connect) {
        ResultSet result;
        try {
            PreparedStatement ps = (PreparedStatement) connect.prepareStatement("SELECT * from purchaseorder");
            result = ps.executeQuery();
            while (result.next()) {

                refreshResult.add(result.getString(1));
                refreshResult.add(result.getString(2));
                refreshResult.add(result.getString(3));
                refreshResult.add(result.getString(4));
                refreshResult.add(result.getString(5));
                refreshResult.add(result.getString(6));
            }
            
//            Iterator it1 = refreshResult.iterator();
//            int i = 1;
//            while (it1.hasNext()) {
//
//                System.out.println(i + ": " + it1.next() + "\n");
//                i++;
//            }
        } catch (SQLException ex) {
            Logger.getLogger(purchaseOrder.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * ***********************数据校验*****************************************
     */
    /**
     * ********刷新*******************
     */
//    
//    public void refresh(DefaultTableModel model,JTable table) {
//       managerTable mt = new managerTable();
//        Connection connect = mt.connect();
//
//        try {//查看表
//
//            Statement statement = connect.createStatement();
//            ResultSet result = statement.executeQuery("SELECT * from purchaseorder");
//            
//            table.setModel(DbUtils.resultSetToTableModel(result));
//            
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Refresh Fail! Try the connection between client and database!");
//            
//        }
//
//    }
//    
}
