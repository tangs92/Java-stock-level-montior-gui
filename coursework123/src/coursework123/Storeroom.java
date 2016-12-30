/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursework123;

import java.awt.Color;
import java.awt.Component;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import net.proteanit.sql.DbUtils;

@Entity
@Table(name = "storeroom")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Storeroom.findAll", query = "SELECT s FROM Storeroom s"),
    @NamedQuery(name = "Storeroom.findByPartID", query = "SELECT s FROM Storeroom s WHERE s.partID = :partID"),
    @NamedQuery(name = "Storeroom.findByManufacturer", query = "SELECT s FROM Storeroom s WHERE s.manufacturer = :manufacturer"),
    @NamedQuery(name = "Storeroom.findByManufacturerDescription", query = "SELECT s FROM Storeroom s WHERE s.manufacturerDescription = :manufacturerDescription"),
    @NamedQuery(name = "Storeroom.findByComponentDescription", query = "SELECT s FROM Storeroom s WHERE s.componentDescription = :componentDescription"),
    @NamedQuery(name = "Storeroom.findByCurrentStockLevel", query = "SELECT s FROM Storeroom s WHERE s.currentStockLevel = :currentStockLevel"),
    @NamedQuery(name = "Storeroom.findByLowstockLevel", query = "SELECT s FROM Storeroom s WHERE s.lowstockLevel = :lowstockLevel"),
    @NamedQuery(name = "Storeroom.findByShelfLocation", query = "SELECT s FROM Storeroom s WHERE s.shelfLocation = :shelfLocation")})
public class Storeroom implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PartID")
    private String partID;
    @Basic(optional = false)
    @Column(name = "Manufacturer")
    private String manufacturer;
    @Basic(optional = false)
    @Column(name = "Manufacturer_Description")
    private String manufacturerDescription;
    @Basic(optional = false)
    @Column(name = "Component_Description")
    private String componentDescription;
    @Basic(optional = false)
    @Column(name = "Current_Stock_Level")
    private int currentStockLevel;
    @Basic(optional = false)
    @Column(name = "Low_stock_Level")
    private int lowstockLevel;
    @Basic(optional = false)
    @Column(name = "Shelf_Location")
    private String shelfLocation;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "partID")
    private Collection<Purchaseorderline> purchaseorderlineCollection;

    public Storeroom() {
    }

    public Storeroom(String partID) {
        this.partID = partID;
    }

    public Storeroom(String partID, String manufacturer, String manufacturerDescription, String componentDescription, int currentStockLevel, int lowstockLevel, String shelfLocation) {
        this.partID = partID;
        this.manufacturer = manufacturer;
        this.manufacturerDescription = manufacturerDescription;
        this.componentDescription = componentDescription;
        this.currentStockLevel = currentStockLevel;
        this.lowstockLevel = lowstockLevel;
        this.shelfLocation = shelfLocation;
    }

    public String getPartID() {
        return partID;
    }

    public void setPartID(String partID) {
        this.partID = partID;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getManufacturerDescription() {
        return manufacturerDescription;
    }

    public void setManufacturerDescription(String manufacturerDescription) {
        this.manufacturerDescription = manufacturerDescription;
    }

    public String getComponentDescription() {
        return componentDescription;
    }

    public void setComponentDescription(String componentDescription) {
        this.componentDescription = componentDescription;
    }

    public int getCurrentStockLevel() {
        return currentStockLevel;
    }

    public void setCurrentStockLevel(int currentStockLevel) {
        this.currentStockLevel = currentStockLevel;
    }

    public int getLowstockLevel() {
        return lowstockLevel;
    }

    public void setLowstockLevel(int lowstockLevel) {
        this.lowstockLevel = lowstockLevel;
    }

    public String getShelfLocation() {
        return shelfLocation;
    }

    public void setShelfLocation(String shelfLocation) {
        this.shelfLocation = shelfLocation;
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
        hash += (partID != null ? partID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Storeroom)) {
            return false;
        }
        Storeroom other = (Storeroom) object;
        if ((this.partID == null && other.partID != null) || (this.partID != null && !this.partID.equals(other.partID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "coursework123.Storeroom[ partID=" + partID + " ]";
    }

    public void refresh(JTable table,DefaultTableModel model) {

        managerTable mt = new managerTable();
        Connection connect = mt.connect();

        try {//查看表

            Statement statement = connect.createStatement();
            ResultSet result = statement.executeQuery("SELECT * from Storeroom");
            table.setModel(DbUtils.resultSetToTableModel(result));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Refresh Fail! Try the connection between client and database!");
            //  Logger.getLogger(myJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void updateRecord(Storeroom storeroom, ArrayList<JTextField> JTextField, DefaultTableModel storeroomModel, JTable jtStoreroom) {

        try {
            managerTable mt = new managerTable();
            Connection connect = mt.connect();
            PreparedStatement ps = (PreparedStatement) connect.prepareStatement("UPDATE  storeroom   SET  PartID =? , Manufacturer =?, Manufacturer_Description = ?, Component_Description =? ,Current_Stock_Level =?, Low_stock_Level =? ,Shelf_Location=? where  PartID = ?");
            ps.setString(1, JTextField.get(0).getText());
            ps.setString(2, JTextField.get(1).getText());
            ps.setString(3, JTextField.get(2).getText());
            ps.setString(4, JTextField.get(3).getText());
            ps.setInt(5, convertStringToInt(JTextField.get(4).getText()));
            ps.setInt(6, convertStringToInt(JTextField.get(5).getText()));
            ps.setString(7, JTextField.get(6).getText());
            ps.setString(8, storeroomModel.getValueAt(jtStoreroom.getSelectedRow(), 0).toString());

            ps.executeUpdate();

            ps.close();
            JOptionPane.showMessageDialog(null, "Update a new record successfull!");

        } catch (SQLException ex) {
            Logger.getLogger(myJFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Update Fail! Please check input information again!");
        }catch(ArithmeticException ex){
             JOptionPane.showMessageDialog(null, "Input must be number and number should greater than 0!");
        }
        storeroom.refresh(jtStoreroom,storeroomModel);
        JTextField.clear();

    }

    public void insertRecord(JTable table,Storeroom storeroom, ArrayList<JTextField> JTextField, DefaultTableModel storeroomModel) {
        managerTable mt = new managerTable();
        Connection connect = mt.connect();
        try {
            PreparedStatement ps = (PreparedStatement) connect.prepareStatement("insert into storeroom  values(?,?,?,?,?,?,?)");
            ps.setString(1, JTextField.get(0).getText());
            ps.setString(2, JTextField.get(1).getText());
            ps.setString(3, JTextField.get(2).getText());
            ps.setString(4, JTextField.get(3).getText());
            ps.setInt(5, convertStringToInt(JTextField.get(4).getText()));
            ps.setInt(6, convertStringToInt(JTextField.get(5).getText()));
            ps.setString(7, JTextField.get(6).getText());

            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Add a new record successfull!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Add a new record fail! Please check your input again!");
            Logger.getLogger(myJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }catch(ArithmeticException ex){
             JOptionPane.showMessageDialog(null, "Input must be number and number should greater than 0!");
        }
        storeroom.refresh(table,storeroomModel);
        JTextField.clear();

    }

    public void delRecord(String ID) {

        try {//删除

            // TODO add your handling code here:
            //Connection connect = connect();
            managerTable mt = new managerTable();
            Connection connect = mt.connect();
            Statement statement = connect.createStatement();
            String sql = "DELETE FROM Storeroom where PartID=" + "'" + ID + "'" + ";";
            statement.executeUpdate(sql);

            JOptionPane.showMessageDialog(null, "Delete Finish!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Delete Error, this record has relationship with other table.Please delete related record in other tables first!");
        
        }

    }

    public int convertStringToInt(String a) throws ArithmeticException {
        int i = 0;
        i = Integer.parseInt(a);
        if (i < 0) {
            throw new ArithmeticException();
        }
        return i;
    }

    public void viewLowStockLevel(DefaultTableModel model) {
        try {
            managerTable mt = new managerTable();
            Connection connect = mt.connect();
            PreparedStatement ps = (PreparedStatement) connect.prepareStatement("select * from storeroom where Current_Stock_Level < Low_stock_Level ");
            ResultSet result = ps.executeQuery();

            while (model.getRowCount() > 0) {
                model.removeRow(model.getRowCount() - 1);
            }

            while (result.next()) {
                model.addRow(new Object[]{
                    result.getObject(1),
                    result.getObject(2),//Display Data into Jtable
                    result.getObject(3),
                    result.getObject(4),
                    result.getObject(5),
                    result.getObject(6),
                    result.getObject(7),}
                );

            }

        } catch (SQLException ex) {
            Logger.getLogger(Storeroom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
