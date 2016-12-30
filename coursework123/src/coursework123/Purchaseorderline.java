/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursework123;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.annotation.XmlRootElement;
import net.proteanit.sql.DbUtils;


@Entity
@Table(name = "purchaseorderline")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Purchaseorderline.findAll", query = "SELECT p FROM Purchaseorderline p"),
    @NamedQuery(name = "Purchaseorderline.findByLineID", query = "SELECT p FROM Purchaseorderline p WHERE p.lineID = :lineID"),
    @NamedQuery(name = "Purchaseorderline.findByQuantity", query = "SELECT p FROM Purchaseorderline p WHERE p.quantity = :quantity"),
    @NamedQuery(name = "Purchaseorderline.findByPricePerUnit", query = "SELECT p FROM Purchaseorderline p WHERE p.pricePerUnit = :pricePerUnit")})
public class Purchaseorderline implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "LineID")
    private Integer lineID;
    @Basic(optional = false)
    @Column(name = "Quantity")
    private int quantity;
    @Basic(optional = false)
    @Column(name = "Price Per Unit")
    private double pricePerUnit;
    @JoinColumn(name = "PurchaseOrderNum", referencedColumnName = "PurchaseOrderID")
    @ManyToOne(optional = false)
    private Purchaseorder purchaseOrderNum;
    @JoinColumn(name = "PartID", referencedColumnName = "PartID")
    @ManyToOne(optional = false)
    private Storeroom partID;

    public Purchaseorderline() {
    }

    public Purchaseorderline(Integer lineID) {
        this.lineID = lineID;
    }

    public Purchaseorderline(Integer lineID, int quantity, double pricePerUnit) {
        this.lineID = lineID;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }

    public Integer getLineID() {
        return lineID;
    }

    public void setLineID(Integer lineID) {
        this.lineID = lineID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public Purchaseorder getPurchaseOrderNum() {
        return purchaseOrderNum;
    }

    public void setPurchaseOrderNum(Purchaseorder purchaseOrderNum) {
        this.purchaseOrderNum = purchaseOrderNum;
    }

    public Storeroom getPartID() {
        return partID;
    }

    public void setPartID(Storeroom partID) {
        this.partID = partID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lineID != null ? lineID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Purchaseorderline)) {
            return false;
        }
        Purchaseorderline other = (Purchaseorderline) object;
        if ((this.lineID == null && other.lineID != null) || (this.lineID != null && !this.lineID.equals(other.lineID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "coursework123.Purchaseorderline[ lineID=" + lineID + " ]";
    }

    public void refresh(JTable table, DefaultTableModel model) {

        managerTable mt = new managerTable();
        Connection connect = mt.connect();

        try {//查看表

            Statement statement = connect.createStatement();
            ResultSet result = statement.executeQuery("SELECT * from Purchaseorderline");
            table.setModel(DbUtils.resultSetToTableModel(result));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Refresh Fail! Try the connection between client and database!");

        }

    }

    public void delRecord(String ID) {

        try {//删除

            // TODO add your handling code here:
            //Connection connect = connect();
            managerTable mt = new managerTable();
            Connection connect = mt.connect();
            Statement statement = connect.createStatement();
            String sql = "DELETE FROM Purchaseorderline where LineID=" + "'" + ID + "'" + ";";
            statement.executeUpdate(sql);

            JOptionPane.showMessageDialog(null, "Delete Finish!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Delete Error, this record has relationship with other table.Please delete related record in other tables first!");
            //Logger.getLogger(myJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void insertRecord(JTable table, Purchaseorderline purchaseorderline, ArrayList<JTextField> JTextField, ArrayList<JComboBox> JComboBox, DefaultTableModel purchaselineModel) {
        managerTable mt = new managerTable();
        Connection connect = mt.connect();
        try {
            PreparedStatement ps = (PreparedStatement) connect.prepareStatement("insert into purchaseorderline values(?,?,?,?,?)");
            ps.setString(1, JTextField.get(0).getText());

            ps.setInt(2, convertStringToInt(JTextField.get(1).getText()));
            ps.setDouble(3, convertStringToDouble(JTextField.get(2).getText()));

            for (int i = 1; i <= 2; i++) {
                ps.setString(i + 3, JComboBox.get(i - 1).getSelectedItem().toString());
            }
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Add a new record successfull!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Add a new record fail! Please check your input again!");
            Logger.getLogger(myJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(null, "Input must be number and number should greater than 0!");
        }
        purchaseorderline.refresh(table, purchaselineModel);
        JTextField.clear();
        JComboBox.clear();
    }

    public void updateRecord(Purchaseorderline purchaseorderline, ArrayList<JTextField> JTextField, ArrayList<JComboBox> JComboBox, DefaultTableModel purchaselineModel, JTable jtPurchaseline) {

        try {
            managerTable mt = new managerTable();
            Connection connect = mt.connect();

            PreparedStatement ps = (PreparedStatement) connect.prepareStatement("UPDATE  purchaseorderline  SET  LineID =? , Quantity =?, PricePerUnit = ?, PurchaseOrderNum =? , PartID =? where  LineID =?");

            ps.setString(1, JTextField.get(0).getText());
            ps.setInt(2, convertStringToInt(JTextField.get(1).getText()));
            ps.setDouble(3, convertStringToDouble(JTextField.get(2).getText()));
            ps.setString(4, JComboBox.get(0).getSelectedItem().toString());

            ps.setString(5, JComboBox.get(1).getSelectedItem().toString());

            ps.setString(6, purchaselineModel.getValueAt(jtPurchaseline.getSelectedRow(), 0).toString());

            ps.executeUpdate();

            ps.close();
            JOptionPane.showMessageDialog(null, "Update a new record successfull!");

        } catch (SQLException ex) {
            Logger.getLogger(myJFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Update Fail! Please check input information again!");
        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(null, "Input must be number and number should greater than 0!");
        }

        purchaseorderline.refresh(jtPurchaseline, purchaselineModel);
        JTextField.clear();
        JComboBox.clear();
    }

    public void getItemToComboBox(JComboBox a, String tableName, String columnName) {
        a.removeAllItems();
        try {
            managerTable mt = new managerTable();
            String sql = "Select * from " + tableName + ";";
            Connection connect = mt.connect();
            Statement statement = connect.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                String item = rs.getString(columnName);
                a.addItem(item);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }
    /*
     public void getItemToComboBox2(JComboBox a, String tableName, String columnName){
        
     try {
     managerTable mt = new managerTable();
     Connection connect = mt.connect();
     PreparedStatement ps = (PreparedStatement) connect.prepareStatement("Select ? from ?");
     ps.setString(1, columnName);
     ps.setString(2, tableName);
     ResultSet executeQuery = ps.executeQuery();
     while (executeQuery.next()) {
     String item = executeQuery.toString();
     a.addItem(item);
     }
     } catch (SQLException ex) {
     Logger.getLogger(Purchaseorderline.class.getName()).log(Level.SEVERE, null, ex);
     }
         
     }
     */

    public int convertStringToInt(String a) throws ArithmeticException {
        int i = 0;

        try {
            i = Integer.parseInt(a);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Input must be numeric vaule, your input will be 0 at this time!");

        }

        return i;
    }

    public double convertStringToDouble(String a) throws ArithmeticException {
        double d = 0;
        try {
            d = Double.parseDouble(a);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Input must be numeric vaule,your input will be 0 at this time!");

        }
        return d;
    }

}
