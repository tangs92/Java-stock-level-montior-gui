/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursework123;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;


@Entity
@Table(name = "purchaseorder")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Purchaseorder.findAll", query = "SELECT p FROM Purchaseorder p"),
    @NamedQuery(name = "Purchaseorder.findByPurchaseOrderID", query = "SELECT p FROM Purchaseorder p WHERE p.purchaseOrderID = :purchaseOrderID"),
    @NamedQuery(name = "Purchaseorder.findByDateCreated", query = "SELECT p FROM Purchaseorder p WHERE p.dateCreated = :dateCreated"),
    @NamedQuery(name = "Purchaseorder.findByExpectedDeliveryDate", query = "SELECT p FROM Purchaseorder p WHERE p.expectedDeliveryDate = :expectedDeliveryDate"),
    @NamedQuery(name = "Purchaseorder.findBySupplier", query = "SELECT p FROM Purchaseorder p WHERE p.supplier = :supplier"),
    @NamedQuery(name = "Purchaseorder.findByStatus", query = "SELECT p FROM Purchaseorder p WHERE p.status = :status"),
    @NamedQuery(name = "Purchaseorder.findByCompletedStatus", query = "SELECT p FROM Purchaseorder p WHERE p.completedStatus = :completedStatus")})
public class Purchaseorder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PurchaseOrderID")
    private String purchaseOrderID;
    @Basic(optional = false)
    @Column(name = "DateCreated")
    @Temporal(TemporalType.DATE)
    private Date dateCreated;
    @Basic(optional = false)
    @Column(name = "ExpectedDeliveryDate")
    @Temporal(TemporalType.DATE)
    private Date expectedDeliveryDate;
    @Basic(optional = false)
    @Column(name = "Supplier")
    private String supplier;
    @Basic(optional = false)
    @Column(name = "Status")
    private String status;
    @Basic(optional = false)
    @Column(name = "CompletedStatus")
    private String completedStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purchaseOrderNum")
    private Collection<Purchaseorderline> purchaseorderlineCollection;

    public Purchaseorder() {
    }

    public Purchaseorder(String purchaseOrderID) {
        this.purchaseOrderID = purchaseOrderID;
    }

    public Purchaseorder(String purchaseOrderID, Date dateCreated, Date expectedDeliveryDate, String supplier, String status, String completedStatus) {
        this.purchaseOrderID = purchaseOrderID;
        this.dateCreated = dateCreated;
        this.expectedDeliveryDate = expectedDeliveryDate;
        this.supplier = supplier;
        this.status = status;
        this.completedStatus = completedStatus;
    }

    public String getPurchaseOrderID() {
        return purchaseOrderID;
    }

    public void setPurchaseOrderID(String purchaseOrderID) {
        this.purchaseOrderID = purchaseOrderID;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCompletedStatus() {
        return completedStatus;
    }

    public void setCompletedStatus(String completedStatus) {
        this.completedStatus = completedStatus;
    }

    @XmlTransient
    public Collection<Purchaseorderline> getPurchaseorderlineCollection() {
        return purchaseorderlineCollection;
    }

    public void setPurchaseorderlineCollection(Collection<Purchaseorderline> purchaseorderlineCollection) {
        this.purchaseorderlineCollection = purchaseorderlineCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (purchaseOrderID != null ? purchaseOrderID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Purchaseorder)) {
            return false;
        }
        Purchaseorder other = (Purchaseorder) object;
        if ((this.purchaseOrderID == null && other.purchaseOrderID != null) || (this.purchaseOrderID != null && !this.purchaseOrderID.equals(other.purchaseOrderID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "coursework123.Purchaseorder[ purchaseOrderID=" + purchaseOrderID + " ]";
    }

    public void refresh(DefaultTableModel model, JTable table) {

        managerTable mt = new managerTable();
        Connection connect = mt.connect();

        try {//查看表

            Statement statement = connect.createStatement();
            ResultSet result = statement.executeQuery("SELECT * from purchaseorder");
            
            table.setModel(DbUtils.resultSetToTableModel(result));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Refresh Fail! Try the connection between client and database!");
            
        }

    }

    public void delRecord(String ID) {

        try {//删除
            managerTable mt = new managerTable();
            Connection connect = mt.connect();
            Statement statement = connect.createStatement();
            String sql = "DELETE FROM purchaseorder where PurchaseOrderID=" + "'" + ID + "'" + ";";
            statement.executeUpdate(sql);

            JOptionPane.showMessageDialog(null, "Delete Finish!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Delete Error, this record has relationship with other table.Please delete related record in other tables first!");
            
        }

    }

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

    public void insertRecord(JTable table, Purchaseorder purchaseorder, ArrayList<JTextField> JTextField, ArrayList<JComboBox> JComboBox, DefaultTableModel purchaseModel) {
        managerTable mt = new managerTable();
        Connection connect = mt.connect();
        try {

            PreparedStatement ps = (PreparedStatement) connect.prepareStatement("insert into purchaseorder values(?,?,?,?,?,?)");
            for (int i = 1; i <= 4; i++) {
                ps.setString(i, JTextField.get(i - 1).getText());
            }
            for (int i = 1; i <= 2; i++) {
                ps.setString(i + 4, JComboBox.get(i - 1).getSelectedItem().toString());
            }

            int checkDate = mt.checkDate(JTextField.get(1).getText(), JTextField.get(2).getText());
            if (checkDate <= 0) {
                ps.executeUpdate();

                ps.close();

                JOptionPane.showMessageDialog(null, "Add a new record successfull!");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Add a new record fail! Please check your input again!");
            Logger.getLogger(myJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        purchaseorder.refresh(purchaseModel, table);
        JTextField.clear();
        JComboBox.clear();

    }
    
    public void a (){
        
    }

    public void updateRecord(Purchaseorder purchaseorder, ArrayList<JTextField> JTextField, ArrayList<JComboBox> JComboBox, DefaultTableModel purchaseModel, JTable jtPurchase) {

        try {
            managerTable mt = new managerTable();
            Connection connect = mt.connect();

            PreparedStatement ps = (PreparedStatement) connect.prepareStatement("UPDATE  purchaseorder  SET  PurchaseOrderID =? , DateCreated =?, ExpectedDeliveryDate = ?, Supplier =? ,Status =?, CompletedStatus =? where  PurchaseOrderID =?");

            ps.setString(1, JTextField.get(0).getText());
            ps.setString(2, JTextField.get(1).getText());
            ps.setString(3, JTextField.get(2).getText());
            ps.setString(4, JTextField.get(3).getText());
            ps.setString(5, JComboBox.get(0).getSelectedItem().toString());
            ps.setString(6, JComboBox.get(1).getSelectedItem().toString());
            ps.setString(7, purchaseModel.getValueAt(jtPurchase.getSelectedRow(), 0).toString());

            int checkDate = purchaseorder.checkDate(JTextField.get(1).getText(), JTextField.get(2).getText());

            if (checkDate <= 0) {
                ps.executeUpdate();

                ps.close();
                JOptionPane.showMessageDialog(null, "Update a new record successfull!");

            }

        } catch (SQLException ex) {
            //  Logger.getLogger(myJFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Update Fail! Please check input information again!");
        }
        purchaseorder.refresh(purchaseModel, jtPurchase);
        JTextField.clear();
        JComboBox.clear();
    }
    
   

}
    
  




