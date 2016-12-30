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
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.table.DefaultTableModel;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.text.JTextComponent;
import net.proteanit.sql.DbUtils;


public class myJFrame extends javax.swing.JFrame {

    private final managerTable mt = new managerTable();
    private final Purchaseorder purchaseorder = new Purchaseorder();
    private final Storeroom storeroom = new Storeroom();
    private final Purchaseorderline purchaseorderline = new Purchaseorderline();

    /**
     * **********************************************************************
     */
    /**
     * Creates new form myJFrame
     */
    private void initTable() {
        DefaultTableModel purchaseModel = (DefaultTableModel) jtPurchase.getModel();
        DefaultTableModel purchaselineModel = (DefaultTableModel) jtPurchaseline.getModel();
        DefaultTableModel storeroomModel = (DefaultTableModel) jtStoreroom.getModel();

        purchaseorderline.getItemToComboBox(jcbPurchaseOrder, "purchaseorder", "PurchaseOrderID");
        purchaseorderline.getItemToComboBox(jcbPartID, "storeroom", "PartID");

        purchaseorder.refresh(purchaseModel, jtPurchase);
        purchaseorderline.refresh(jtPurchaseline, purchaselineModel);
        storeroom.refresh(jtStoreroom, storeroomModel);

    }

    public myJFrame() {

        initComponents();
        initTable();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jpPurchase = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtPurchase = new javax.swing.JTable();
        jlPurchaseorderid = new javax.swing.JLabel();
        jlDatecreated = new javax.swing.JLabel();
        jlExpecteddeliverydate = new javax.swing.JLabel();
        jlSupplier = new javax.swing.JLabel();
        jlStatus = new javax.swing.JLabel();
        jtfPurchaseOrderID = new javax.swing.JTextField();
        jtfDateCreated = new javax.swing.JTextField();
        jtfExpectedDeliveryDate = new javax.swing.JTextField();
        jtfSupplier = new javax.swing.JTextField();
        jcbStatus = new javax.swing.JComboBox();
        jcbCompletedStatus = new javax.swing.JComboBox();
        jbNewPO = new javax.swing.JButton();
        jbDeletePO = new javax.swing.JButton();
        jbUpdatePO = new javax.swing.JButton();
        jbRefreshPO = new javax.swing.JButton();
        jbInsertPO = new javax.swing.JButton();
        jlCompletedstatus = new javax.swing.JLabel();
        jbPrint = new javax.swing.JButton();
        jpPurchaseline = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtPurchaseline = new javax.swing.JTable();
        jlQuantity = new javax.swing.JLabel();
        jtfQuantity = new javax.swing.JTextField();
        jlPricePerUnit = new javax.swing.JLabel();
        jtfPricePerUnit = new javax.swing.JTextField();
        jlPurchaseOrderID = new javax.swing.JLabel();
        jcbPurchaseOrder = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jcbPartID = new javax.swing.JComboBox();
        jbNewPOL = new javax.swing.JButton();
        jbDeletePOL = new javax.swing.JButton();
        jbUpdatePOL = new javax.swing.JButton();
        jbRefreshPOL = new javax.swing.JButton();
        jbInsertPOL = new javax.swing.JButton();
        jlLineID = new javax.swing.JLabel();
        jtfLineID = new javax.swing.JTextField();
        jpStoreroom = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtStoreroom = new javax.swing.JTable();
        jlPartID = new javax.swing.JLabel();
        jlMD = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jlCD = new javax.swing.JLabel();
        jlCSL = new javax.swing.JLabel();
        jlLSL = new javax.swing.JLabel();
        jlSL = new javax.swing.JLabel();
        jtfPartID = new javax.swing.JTextField();
        jtfManufacturer = new javax.swing.JTextField();
        jtfManufacturerDesc = new javax.swing.JTextField();
        jtfComponentDesc = new javax.swing.JTextField();
        jtfCurrentStock = new javax.swing.JTextField();
        jtfLowStock = new javax.swing.JTextField();
        jtfShelfLoc = new javax.swing.JTextField();
        jbNewST = new javax.swing.JButton();
        jbDelST = new javax.swing.JButton();
        jbUpdateST = new javax.swing.JButton();
        jbRefreshST = new javax.swing.JButton();
        jbInsertST = new javax.swing.JButton();
        jbViewLowLevel = new javax.swing.JButton();

        jMenuItem1.setText("Delete");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setText("Update");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Purchasing Manager Tool");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jtPurchase.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PurchaseOrderID", "DateCreated", "ExpectedDeliveryDate", "Supplier", "Status", "CompletedStatus"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtPurchase.getTableHeader().setReorderingAllowed(false);
        jtPurchase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtPurchaseMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jtPurchaseMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jtPurchase);

        jlPurchaseorderid.setText("Purchase Order ID:");

        jlDatecreated.setText("Date Created:");

        jlExpecteddeliverydate.setText("Expected Delivery Date:");

        jlSupplier.setText("Supplier:");

        jlStatus.setText("Status:");

        jtfPurchaseOrderID.setToolTipText("Make sure Purchase Order ID should be unique!");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jtPurchase, org.jdesktop.beansbinding.ELProperty.create("${(selectedElement!= null)}"), jtfPurchaseOrderID, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jtfDateCreated.setToolTipText("HHHH-MM-DD");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jtPurchase, org.jdesktop.beansbinding.ELProperty.create("${(selectedElement!= null)}"), jtfDateCreated, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jtfExpectedDeliveryDate.setToolTipText("HHHH-MM-DD");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jtPurchase, org.jdesktop.beansbinding.ELProperty.create("${(selectedElement!= null)}"), jtfExpectedDeliveryDate, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jtPurchase, org.jdesktop.beansbinding.ELProperty.create("${(selectedElement!= null)}"), jtfSupplier, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jcbStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Completed", "Dispatched", "Cancelled", "On_Hold", "Order" }));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jtPurchase, org.jdesktop.beansbinding.ELProperty.create("${(selectedElement!= null)}"), jcbStatus, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jcbCompletedStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No", "Yes" }));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jtPurchase, org.jdesktop.beansbinding.ELProperty.create("${(selectedElement!= null)}"), jcbCompletedStatus, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jbNewPO.setText("New");
        jbNewPO.setToolTipText("Click New, then click the blank row in the table,start a record!");
        jbNewPO.setName("jbNewPO"); // NOI18N
        jbNewPO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNew_PO_ActionPerformed(evt);
            }
        });

        jbDeletePO.setText("Delete");
        jbDeletePO.setName("jbDeletePO"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jtPurchase, org.jdesktop.beansbinding.ELProperty.create("${(selectedElement!= null)}"), jbDeletePO, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jbDeletePO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDelete_PO_ActionPerformed(evt);
            }
        });

        jbUpdatePO.setText("Update");
        jbUpdatePO.setName("jbUpdatePO"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jtPurchase, org.jdesktop.beansbinding.ELProperty.create("${(selectedElement!= null)}"), jbUpdatePO, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jbUpdatePO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbUpdate_PO_ActionPerformed(evt);
            }
        });

        jbRefreshPO.setText("Refresh");
        jbRefreshPO.setName("jbRefreshPO"); // NOI18N
        jbRefreshPO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRefresh_PO_ActionPerformed(evt);
            }
        });

        jbInsertPO.setText("Insert");
        jbInsertPO.setName("jbInsertPO"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jtPurchase, org.jdesktop.beansbinding.ELProperty.create("${(selectedElement!= null)}"), jbInsertPO, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jbInsertPO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInsert_PO_ActionPerformed(evt);
            }
        });

        jlCompletedstatus.setText("Completed Status:");

        jbPrint.setText("Print");
        jbPrint.setName("jbPrint"); // NOI18N
        jbPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPrint_PO_ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpPurchaseLayout = new javax.swing.GroupLayout(jpPurchase);
        jpPurchase.setLayout(jpPurchaseLayout);
        jpPurchaseLayout.setHorizontalGroup(
            jpPurchaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPurchaseLayout.createSequentialGroup()
                .addComponent(jbNewPO, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbDeletePO, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbUpdatePO, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbRefreshPO, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbInsertPO, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jpPurchaseLayout.createSequentialGroup()
                .addGroup(jpPurchaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlPurchaseorderid)
                    .addComponent(jlDatecreated)
                    .addComponent(jlExpecteddeliverydate)
                    .addComponent(jlSupplier)
                    .addComponent(jlStatus)
                    .addComponent(jlCompletedstatus))
                .addGap(32, 32, 32)
                .addGroup(jpPurchaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPurchaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jcbStatus, javax.swing.GroupLayout.Alignment.LEADING, 0, 273, Short.MAX_VALUE)
                        .addComponent(jtfSupplier, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jtfExpectedDeliveryDate, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jtfDateCreated, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jtfPurchaseOrderID, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jcbCompletedStatus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(256, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jpPurchaseLayout.setVerticalGroup(
            jpPurchaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPurchaseLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPurchaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlPurchaseorderid)
                    .addComponent(jtfPurchaseOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPurchaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlDatecreated)
                    .addComponent(jtfDateCreated, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jpPurchaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlExpecteddeliverydate)
                    .addComponent(jtfExpectedDeliveryDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPurchaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlSupplier)
                    .addComponent(jtfSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPurchaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlStatus)
                    .addComponent(jcbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPurchaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlCompletedstatus)
                    .addComponent(jcbCompletedStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(jpPurchaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbNewPO)
                    .addComponent(jbDeletePO)
                    .addComponent(jbUpdatePO)
                    .addComponent(jbRefreshPO)
                    .addComponent(jbInsertPO)
                    .addComponent(jbPrint))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Purchase Order", jpPurchase);

        jtPurchaseline.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Line ID", "Quantity", "Price Per Unit", "PurchaseOrderNum", "PartID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtPurchaseline.getTableHeader().setReorderingAllowed(false);
        jtPurchaseline.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtPurchaselineMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtPurchaseline);

        jlQuantity.setText("Quantity:");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jtPurchaseline, org.jdesktop.beansbinding.ELProperty.create("${(selectedElement!= null)}"), jtfQuantity, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jlPricePerUnit.setText("Price per unit:");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jtPurchaseline, org.jdesktop.beansbinding.ELProperty.create("${(selectedElement!= null)}"), jtfPricePerUnit, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jlPurchaseOrderID.setText("Purchase Order ID:");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jtPurchaseline, org.jdesktop.beansbinding.ELProperty.create("${(selectedElement!= null)}"), jcbPurchaseOrder, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jcbPurchaseOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbPurchaseOrderActionPerformed(evt);
            }
        });

        jLabel2.setText("Part ID:");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jtPurchaseline, org.jdesktop.beansbinding.ELProperty.create("${(selectedElement!= null)}"), jcbPartID, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jcbPartID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbPartIDActionPerformed(evt);
            }
        });

        jbNewPOL.setText("New");
        jbNewPOL.setName("jbNewPOL"); // NOI18N
        jbNewPOL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNew_POLine_ActionPerformed(evt);
            }
        });

        jbDeletePOL.setText("Delete");
        jbDeletePOL.setName("jbDeletePOL"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jtPurchaseline, org.jdesktop.beansbinding.ELProperty.create("${(selectedElement!= null)}"), jbDeletePOL, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jbDeletePOL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDelete_POLine_ActionPerformed(evt);
            }
        });

        jbUpdatePOL.setText("Update");
        jbUpdatePOL.setName("jbUpdatePOL"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jtPurchaseline, org.jdesktop.beansbinding.ELProperty.create("${(selectedElement!= null)}"), jbUpdatePOL, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jbUpdatePOL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbUpdate_POLine_ActionPerformed(evt);
            }
        });

        jbRefreshPOL.setText("Refresh");
        jbRefreshPOL.setName("jbRefreshPOL"); // NOI18N
        jbRefreshPOL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRefresh_POLine_ActionPerformed(evt);
            }
        });

        jbInsertPOL.setText("Insert");
        jbInsertPOL.setName("jbInsertPOL"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jtPurchaseline, org.jdesktop.beansbinding.ELProperty.create("${(selectedElement!= null)}"), jbInsertPOL, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jbInsertPOL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInsert_POLine_ActionPerformed(evt);
            }
        });

        jlLineID.setText("Line ID: ");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jtPurchaseline, org.jdesktop.beansbinding.ELProperty.create("${(selectedElement!= null)}"), jtfLineID, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout jpPurchaselineLayout = new javax.swing.GroupLayout(jpPurchaseline);
        jpPurchaseline.setLayout(jpPurchaselineLayout);
        jpPurchaselineLayout.setHorizontalGroup(
            jpPurchaselineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPurchaselineLayout.createSequentialGroup()
                .addGroup(jpPurchaselineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPurchaselineLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpPurchaselineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpPurchaselineLayout.createSequentialGroup()
                                .addGroup(jpPurchaselineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpPurchaselineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jlQuantity)
                                        .addComponent(jlLineID))
                                    .addComponent(jLabel2)
                                    .addComponent(jlPricePerUnit))
                                .addGap(40, 40, 40))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPurchaselineLayout.createSequentialGroup()
                                .addComponent(jlPurchaseOrderID)
                                .addGap(18, 18, 18)))
                        .addGroup(jpPurchaselineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jcbPurchaseOrder, 0, 298, Short.MAX_VALUE)
                            .addComponent(jcbPartID, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtfLineID)
                            .addComponent(jtfPricePerUnit)
                            .addComponent(jtfQuantity)))
                    .addGroup(jpPurchaselineLayout.createSequentialGroup()
                        .addComponent(jbNewPOL, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbDeletePOL, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbUpdatePOL, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbRefreshPOL, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbInsertPOL, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 214, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
        );
        jpPurchaselineLayout.setVerticalGroup(
            jpPurchaselineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPurchaselineLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPurchaselineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlLineID)
                    .addComponent(jtfLineID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPurchaselineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlQuantity)
                    .addComponent(jtfQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPurchaselineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlPricePerUnit)
                    .addComponent(jtfPricePerUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPurchaselineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlPurchaseOrderID)
                    .addComponent(jcbPurchaseOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPurchaselineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbPartID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(86, 86, 86)
                .addGroup(jpPurchaselineLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbNewPOL)
                    .addComponent(jbDeletePOL)
                    .addComponent(jbUpdatePOL)
                    .addComponent(jbRefreshPOL)
                    .addComponent(jbInsertPOL))
                .addGap(0, 17, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Purchase Order Line", jpPurchaseline);

        jtStoreroom.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PartID", "Manufacturer", "Manufacturer Description", "Component Description", "Current Stock_Level", "Low Stock Level", "Shelf Location"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtStoreroom.getTableHeader().setReorderingAllowed(false);
        jtStoreroom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtStoreroomMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jtStoreroom);

        jlPartID.setText("Part ID:");

        jlMD.setText("Manufacturer:");

        jLabel5.setText("Manufacturer Description:");

        jlCD.setText("Component Description:");

        jlCSL.setText("Current Stock Level:");

        jlLSL.setText("Low Stock Level:");

        jlSL.setText("Shelf Location:");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jtStoreroom, org.jdesktop.beansbinding.ELProperty.create("${(selectedElement!= null)}"), jtfPartID, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jtStoreroom, org.jdesktop.beansbinding.ELProperty.create("${(selectedElement!= null)}"), jtfManufacturer, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jtStoreroom, org.jdesktop.beansbinding.ELProperty.create("${(selectedElement!= null)}"), jtfManufacturerDesc, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jtStoreroom, org.jdesktop.beansbinding.ELProperty.create("${(selectedElement!= null)}"), jtfComponentDesc, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jtStoreroom, org.jdesktop.beansbinding.ELProperty.create("${(selectedElement!= null)}"), jtfCurrentStock, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jtStoreroom, org.jdesktop.beansbinding.ELProperty.create("${(selectedElement!= null)}"), jtfLowStock, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jtStoreroom, org.jdesktop.beansbinding.ELProperty.create("${(selectedElement!= null)}"), jtfShelfLoc, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jbNewST.setText("New");
        jbNewST.setName("jbNewST"); // NOI18N
        jbNewST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNew_ST_ActionPerformed(evt);
            }
        });

        jbDelST.setText("Delete");
        jbDelST.setName("jbDelST"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jtStoreroom, org.jdesktop.beansbinding.ELProperty.create("${(selectedElement!= null)}"), jbDelST, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jbDelST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDel_ST_ActionPerformed(evt);
            }
        });

        jbUpdateST.setText("Update");
        jbUpdateST.setName("jbUpdateST"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jtStoreroom, org.jdesktop.beansbinding.ELProperty.create("${(selectedElement!= null)}"), jbUpdateST, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jbUpdateST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbUpdate_ST_ActionPerformed(evt);
            }
        });

        jbRefreshST.setText("Refresh");
        jbRefreshST.setName("jbRefreshST"); // NOI18N
        jbRefreshST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRefresh_ST_ActionPerformed(evt);
            }
        });

        jbInsertST.setText("Insert");
        jbInsertST.setName("jbInsertST"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jtStoreroom, org.jdesktop.beansbinding.ELProperty.create("${(selectedElement!= null)}"), jbInsertST, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jbInsertST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInsert_ST_ActionPerformed(evt);
            }
        });

        jbViewLowLevel.setText("View Low Level Stock");
        jbViewLowLevel.setName("jbViewLowLevel"); // NOI18N
        jbViewLowLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbViewLowLevelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpStoreroomLayout = new javax.swing.GroupLayout(jpStoreroom);
        jpStoreroom.setLayout(jpStoreroomLayout);
        jpStoreroomLayout.setHorizontalGroup(
            jpStoreroomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpStoreroomLayout.createSequentialGroup()
                .addGroup(jpStoreroomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpStoreroomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpStoreroomLayout.createSequentialGroup()
                            .addGroup(jpStoreroomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jlSL)
                                .addComponent(jlLSL)
                                .addComponent(jlCSL)
                                .addComponent(jlCD))
                            .addGroup(jpStoreroomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jpStoreroomLayout.createSequentialGroup()
                                    .addGap(22, 22, 22)
                                    .addGroup(jpStoreroomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jtfShelfLoc, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                                        .addComponent(jtfLowStock)
                                        .addComponent(jtfCurrentStock)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpStoreroomLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jpStoreroomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jtfComponentDesc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                                        .addComponent(jtfManufacturerDesc, javax.swing.GroupLayout.Alignment.TRAILING)))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpStoreroomLayout.createSequentialGroup()
                            .addGroup(jpStoreroomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jlMD)
                                .addComponent(jlPartID))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jpStoreroomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jtfManufacturer, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                                .addComponent(jtfPartID))))
                    .addGroup(jpStoreroomLayout.createSequentialGroup()
                        .addComponent(jbNewST, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbDelST, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbUpdateST, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbRefreshST, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbInsertST, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbViewLowLevel))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 741, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpStoreroomLayout.setVerticalGroup(
            jpStoreroomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpStoreroomLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpStoreroomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlPartID)
                    .addComponent(jtfPartID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpStoreroomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlMD)
                    .addComponent(jtfManufacturer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpStoreroomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtfManufacturerDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpStoreroomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlCD)
                    .addComponent(jtfComponentDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpStoreroomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlCSL)
                    .addComponent(jtfCurrentStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpStoreroomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlLSL)
                    .addComponent(jtfLowStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpStoreroomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlSL)
                    .addComponent(jtfShelfLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(jpStoreroomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbNewST)
                    .addComponent(jbDelST)
                    .addComponent(jbUpdateST)
                    .addComponent(jbRefreshST)
                    .addComponent(jbInsertST)
                    .addComponent(jbViewLowLevel))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Store Room", jpStoreroom);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        setSize(new java.awt.Dimension(828, 698));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbRefresh_PO_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRefresh_PO_ActionPerformed
        jbUpdatePO.setVisible(true);
        DefaultTableModel purchaseModel = (DefaultTableModel) jtPurchase.getModel();
        purchaseorder.refresh(purchaseModel, jtPurchase);


    }//GEN-LAST:event_jbRefresh_PO_ActionPerformed

    private void jtPurchaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtPurchaseMouseClicked
        // TODO add your handling code here:
        
        DefaultTableModel purchaseModel = (DefaultTableModel) jtPurchase.getModel();
        jtfPurchaseOrderID.setText(purchaseModel.getValueAt(jtPurchase.getSelectedRow(), 0).toString());
        jtfDateCreated.setText(purchaseModel.getValueAt(jtPurchase.getSelectedRow(), 1).toString());
        jtfExpectedDeliveryDate.setText(purchaseModel.getValueAt(jtPurchase.getSelectedRow(), 2).toString());
        jtfSupplier.setText(purchaseModel.getValueAt(jtPurchase.getSelectedRow(), 3).toString());
        jcbStatus.setSelectedItem(purchaseModel.getValueAt(jtPurchase.getSelectedRow(), 4).toString());
        jcbCompletedStatus.setSelectedItem(purchaseModel.getValueAt(jtPurchase.getSelectedRow(), 5).toString());
    }//GEN-LAST:event_jtPurchaseMouseClicked

    private void jbNew_PO_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNew_PO_ActionPerformed
        // TODO add your handling code here:

        jbUpdatePO.setVisible(false);
        DefaultTableModel purchaseModel = (DefaultTableModel) jtPurchase.getModel();
        cleanField();

        purchaseModel.addRow(new Object[]{
            jtfPurchaseOrderID.getText(),
            jtfDateCreated.getText(),
            jtfExpectedDeliveryDate.getText(),
            jtfSupplier.getText(),
            jcbStatus.getSelectedItem(),
            jcbCompletedStatus.getSelectedItem()
        });

    }//GEN-LAST:event_jbNew_PO_ActionPerformed

    private void jbInsert_PO_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInsert_PO_ActionPerformed
        DefaultTableModel purchaseModel = (DefaultTableModel) jtPurchase.getModel();
        ArrayList<JTextField> purchaseOrderJTextField = getPurchaseOrderJTextField();
        ArrayList<JComboBox> purchaseOrderJComboBox = getPurchaseOrderJComboBox();
        purchaseorder.insertRecord(jtPurchase, purchaseorder, purchaseOrderJTextField, purchaseOrderJComboBox, purchaseModel);
        purchaseorder.refresh(purchaseModel, jtPurchase);
        cleanField();
        jbUpdatePO.setVisible(true);
    }//GEN-LAST:event_jbInsert_PO_ActionPerformed

    private void jbDelete_PO_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDelete_PO_ActionPerformed

        DefaultTableModel purchaseModel = (DefaultTableModel) jtPurchase.getModel();
        purchaseorder.delRecord(jtfPurchaseOrderID.getText());
        cleanField();
        purchaseorder.refresh(purchaseModel, jtPurchase);
        jbUpdatePO.setVisible(true);
    }//GEN-LAST:event_jbDelete_PO_ActionPerformed

    private void jbUpdate_PO_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbUpdate_PO_ActionPerformed

        DefaultTableModel purchaseModel = (DefaultTableModel) jtPurchase.getModel();
        ArrayList<JTextField> purchaseOrderJTextField = getPurchaseOrderJTextField();
        ArrayList<JComboBox> purchaseOrderJComboBox = getPurchaseOrderJComboBox();
        purchaseorder.updateRecord(purchaseorder, purchaseOrderJTextField, purchaseOrderJComboBox, purchaseModel, jtPurchase);

        cleanField();
        jbUpdatePO.setVisible(true);
    }//GEN-LAST:event_jbUpdate_PO_ActionPerformed

    private void jtPurchaselineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtPurchaselineMouseClicked
        // TODO add your handling code here:
        DefaultTableModel purchaselineModel = (DefaultTableModel) jtPurchaseline.getModel();
        jtfLineID.setText(purchaselineModel.getValueAt(jtPurchaseline.getSelectedRow(), 0).toString());
        jtfQuantity.setText(purchaselineModel.getValueAt(jtPurchaseline.getSelectedRow(), 1).toString());
        jtfPricePerUnit.setText(purchaselineModel.getValueAt(jtPurchaseline.getSelectedRow(), 2).toString());
        jcbPurchaseOrder.setSelectedItem(purchaselineModel.getValueAt(jtPurchaseline.getSelectedRow(), 3).toString());
        jcbPartID.setSelectedItem(purchaselineModel.getValueAt(jtPurchaseline.getSelectedRow(), 4).toString());
    }//GEN-LAST:event_jtPurchaselineMouseClicked

    private void jbNew_POLine_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNew_POLine_ActionPerformed
        // TODO add your handling code here:
        jbUpdatePOL.setVisible(false);
        DefaultTableModel purchaselineModel = (DefaultTableModel) jtPurchaseline.getModel();
        cleanField();

        purchaselineModel.addRow(new Object[]{
            jtfLineID.getText(),
            jtfQuantity.getText(),
            jtfPricePerUnit.getText(),
            jcbPurchaseOrder.getSelectedItem().toString(),
            jcbPartID.getSelectedItem().toString()
        });
    }//GEN-LAST:event_jbNew_POLine_ActionPerformed

    private void jbRefresh_POLine_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRefresh_POLine_ActionPerformed
        // TODO add your handling code here:

        DefaultTableModel purchaselineModel = (DefaultTableModel) jtPurchaseline.getModel();
        purchaseorderline.refresh(jtPurchaseline, purchaselineModel);
        cleanField();
        jbUpdatePOL.setVisible(true);
    }//GEN-LAST:event_jbRefresh_POLine_ActionPerformed

    private void jbInsert_POLine_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInsert_POLine_ActionPerformed
        jbUpdatePOL.setVisible(true);
        DefaultTableModel purchaselineModel = (DefaultTableModel) jtPurchaseline.getModel();
        ArrayList<JTextField> purchaseOrderLINEJTextField = getPurchaseOrderLineJTextField();
        ArrayList<JComboBox> purchaseOrderLINEJComboBox = getPurchaseOrderLineJComboBox();
        purchaseorderline.insertRecord(jtPurchaseline, purchaseorderline, purchaseOrderLINEJTextField, purchaseOrderLINEJComboBox, purchaselineModel);

        cleanField();
        jbUpdatePOL.setVisible(true);

    }//GEN-LAST:event_jbInsert_POLine_ActionPerformed

    private void jbDelete_POLine_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDelete_POLine_ActionPerformed

        DefaultTableModel purchaselineModel = (DefaultTableModel) jtPurchaseline.getModel();
        purchaseorderline.delRecord(jtfLineID.getText());
        cleanField();
        purchaseorderline.refresh(jtPurchaseline, purchaselineModel);
        jbUpdatePOL.setVisible(true);
    }//GEN-LAST:event_jbDelete_POLine_ActionPerformed

    private void jbUpdate_POLine_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbUpdate_POLine_ActionPerformed
        DefaultTableModel purchaselineModel = (DefaultTableModel) jtPurchaseline.getModel();
        ArrayList<JTextField> purchaseOrderLineJTextField = getPurchaseOrderLineJTextField();
        ArrayList<JComboBox> purchaseOrderLineJJComboBox = getPurchaseOrderLineJComboBox();
        purchaseorderline.updateRecord(purchaseorderline, purchaseOrderLineJTextField, purchaseOrderLineJJComboBox, purchaselineModel, jtPurchaseline);
        cleanField();
    }//GEN-LAST:event_jbUpdate_POLine_ActionPerformed

    private void jbDel_ST_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDel_ST_ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel storeroomModel = (DefaultTableModel) jtStoreroom.getModel();
        storeroom.delRecord(jtfPartID.getText());
        cleanField();
        storeroom.refresh(jtStoreroom, storeroomModel);
        jbUpdateST.setVisible(true);
    }//GEN-LAST:event_jbDel_ST_ActionPerformed

    private void jbNew_ST_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNew_ST_ActionPerformed
        // TODO add your handling code here:
        jbUpdateST.setVisible(false);
        jbViewLowLevel.setVisible(false);

        DefaultTableModel storeroomModel = (DefaultTableModel) jtStoreroom.getModel();
        cleanField();
        storeroomModel.addRow(new Object[]{
            jtfPartID.getText(),
            jtfManufacturer.getText(),
            jtfManufacturerDesc.getText(),
            jtfComponentDesc.getText(),
            jtfCurrentStock.getText(),
            jtfLowStock.getText(),
            jtfShelfLoc.getText()
        });
    }//GEN-LAST:event_jbNew_ST_ActionPerformed

    private void jbUpdate_ST_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbUpdate_ST_ActionPerformed
        DefaultTableModel storeroomModel = (DefaultTableModel) jtStoreroom.getModel();
        ArrayList<JTextField> storeRoomJTextField = getStoreRoomJTextField();
        storeroom.updateRecord(storeroom, storeRoomJTextField, storeroomModel, jtStoreroom);

        cleanField();
        jbUpdateST.setVisible(true);
        jbViewLowLevel.setVisible(true);
    }//GEN-LAST:event_jbUpdate_ST_ActionPerformed

    private void jbRefresh_ST_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRefresh_ST_ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel storeroomModel = (DefaultTableModel) jtStoreroom.getModel();
        storeroom.refresh(jtStoreroom, storeroomModel);
        cleanField();
        jbUpdateST.setVisible(true);
        jbViewLowLevel.setVisible(true);
    }//GEN-LAST:event_jbRefresh_ST_ActionPerformed

    private void jbInsert_ST_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInsert_ST_ActionPerformed
        DefaultTableModel storeroomModel = (DefaultTableModel) jtStoreroom.getModel();
        ArrayList<JTextField> StoreRoomJTextField = getStoreRoomJTextField();
        storeroom.insertRecord(jtStoreroom, storeroom, StoreRoomJTextField, storeroomModel);
        storeroom.refresh(jtStoreroom, storeroomModel);
        cleanField();
        jbUpdateST.setVisible(true);
        jbViewLowLevel.setVisible(true);
    }//GEN-LAST:event_jbInsert_ST_ActionPerformed

    private void jtStoreroomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtStoreroomMouseClicked
        // TODO add your handling code here:
        DefaultTableModel storeroomModel = (DefaultTableModel) jtStoreroom.getModel();
        jtfPartID.setText(storeroomModel.getValueAt(jtStoreroom.getSelectedRow(), 0).toString());
        jtfManufacturer.setText(storeroomModel.getValueAt(jtStoreroom.getSelectedRow(), 1).toString());
        jtfManufacturerDesc.setText(storeroomModel.getValueAt(jtStoreroom.getSelectedRow(), 2).toString());
        jtfComponentDesc.setText(storeroomModel.getValueAt(jtStoreroom.getSelectedRow(), 3).toString());
        jtfCurrentStock.setText(storeroomModel.getValueAt(jtStoreroom.getSelectedRow(), 4).toString());
        jtfLowStock.setText(storeroomModel.getValueAt(jtStoreroom.getSelectedRow(), 5).toString());
        jtfShelfLoc.setText(storeroomModel.getValueAt(jtStoreroom.getSelectedRow(), 6).toString());

    }//GEN-LAST:event_jtStoreroomMouseClicked

    private void jbViewLowLevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbViewLowLevelActionPerformed
        DefaultTableModel storeroomModel = (DefaultTableModel) jtStoreroom.getModel();
        storeroom.viewLowStockLevel(storeroomModel);
        
    }//GEN-LAST:event_jbViewLowLevelActionPerformed

    private void jbPrint_PO_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPrint_PO_ActionPerformed
        String title[] = {"Purchase Order ID:", "Date Created:   ", "Expected Delivery Date:", "Supplier:       ", "Status:         ", "Completed Status:"};
        PrintWriter out = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        try {
            out = new PrintWriter(new File("Result.txt")
                    .getAbsoluteFile());
            try {//查看表
                managerTable mt = new managerTable();
                Statement statement = mt.connect().createStatement();
                ResultSet result = statement.executeQuery("SELECT * from purchaseorder");
                out.print("---------------------Purchase Order Table Output---------------------" + "\r\n\n");
                while (result.next()) {
                    for (int i = 1; i <= 6; i++) {
                        out.print(title[i - 1] + "\t");
                        out.print(result.getObject(i).toString() + "\r\n");
                        if (i == 6) {
                            out.print("---------------------------------------------------------------------" + "\r\n");
                        }
                    }

                }
                JOptionPane.showMessageDialog(null, "Print to Result.txt in work folder!");
                out.print("------------------OutPut Finish at " + dateFormat.format(new Date()) + " --------------" + "\r\n\n");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Print to Result.txt in work folder Fail!");
                Logger.getLogger(myJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Print to Result.txt in work folder Fail!");
            Logger.getLogger(myJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }


    }//GEN-LAST:event_jbPrint_PO_ActionPerformed

    private void jcbPurchaseOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbPurchaseOrderActionPerformed


    }//GEN-LAST:event_jcbPurchaseOrderActionPerformed

    private void jcbPartIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbPartIDActionPerformed

    }//GEN-LAST:event_jcbPartIDActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        DefaultTableModel purchaseModel = (DefaultTableModel) jtPurchase.getModel();
        purchaseorder.delRecord(jtfPurchaseOrderID.getText());
        cleanField();
        purchaseorder.refresh(purchaseModel, jtPurchase);
        jbUpdatePO.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jtPurchaseMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtPurchaseMouseReleased
        if(evt.isPopupTrigger())
        {
        jPopupMenu1.show(this,evt.getX(),evt.getY());      
        }
    }//GEN-LAST:event_jtPurchaseMouseReleased

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        DefaultTableModel purchaseModel = (DefaultTableModel) jtPurchase.getModel();
        ArrayList<JTextField> purchaseOrderJTextField = getPurchaseOrderJTextField();
        ArrayList<JComboBox> purchaseOrderJComboBox = getPurchaseOrderJComboBox();
        purchaseorder.updateRecord(purchaseorder, purchaseOrderJTextField, purchaseOrderJComboBox, purchaseModel, jtPurchase);

        cleanField();
        jbUpdatePO.setVisible(true);
        
        
        
        
        
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(myJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(myJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(myJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(myJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new myJFrame().setVisible(true);
            }
        });
    }
    /**/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbDelST;
    private javax.swing.JButton jbDeletePO;
    private javax.swing.JButton jbDeletePOL;
    private javax.swing.JButton jbInsertPO;
    private javax.swing.JButton jbInsertPOL;
    private javax.swing.JButton jbInsertST;
    private javax.swing.JButton jbNewPO;
    private javax.swing.JButton jbNewPOL;
    private javax.swing.JButton jbNewST;
    private javax.swing.JButton jbPrint;
    private javax.swing.JButton jbRefreshPO;
    private javax.swing.JButton jbRefreshPOL;
    private javax.swing.JButton jbRefreshST;
    private javax.swing.JButton jbUpdatePO;
    private javax.swing.JButton jbUpdatePOL;
    private javax.swing.JButton jbUpdateST;
    private javax.swing.JButton jbViewLowLevel;
    private javax.swing.JComboBox jcbCompletedStatus;
    private javax.swing.JComboBox jcbPartID;
    private javax.swing.JComboBox jcbPurchaseOrder;
    private javax.swing.JComboBox jcbStatus;
    private javax.swing.JLabel jlCD;
    private javax.swing.JLabel jlCSL;
    private javax.swing.JLabel jlCompletedstatus;
    private javax.swing.JLabel jlDatecreated;
    private javax.swing.JLabel jlExpecteddeliverydate;
    private javax.swing.JLabel jlLSL;
    private javax.swing.JLabel jlLineID;
    private javax.swing.JLabel jlMD;
    private javax.swing.JLabel jlPartID;
    private javax.swing.JLabel jlPricePerUnit;
    private javax.swing.JLabel jlPurchaseOrderID;
    private javax.swing.JLabel jlPurchaseorderid;
    private javax.swing.JLabel jlQuantity;
    private javax.swing.JLabel jlSL;
    private javax.swing.JLabel jlStatus;
    private javax.swing.JLabel jlSupplier;
    private javax.swing.JPanel jpPurchase;
    private javax.swing.JPanel jpPurchaseline;
    private javax.swing.JPanel jpStoreroom;
    private javax.swing.JTable jtPurchase;
    private javax.swing.JTable jtPurchaseline;
    private javax.swing.JTable jtStoreroom;
    private javax.swing.JTextField jtfComponentDesc;
    private javax.swing.JTextField jtfCurrentStock;
    private javax.swing.JTextField jtfDateCreated;
    private javax.swing.JTextField jtfExpectedDeliveryDate;
    private javax.swing.JTextField jtfLineID;
    private javax.swing.JTextField jtfLowStock;
    private javax.swing.JTextField jtfManufacturer;
    private javax.swing.JTextField jtfManufacturerDesc;
    private javax.swing.JTextField jtfPartID;
    private javax.swing.JTextField jtfPricePerUnit;
    private javax.swing.JTextField jtfPurchaseOrderID;
    private javax.swing.JTextField jtfQuantity;
    private javax.swing.JTextField jtfShelfLoc;
    private javax.swing.JTextField jtfSupplier;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
   /**
     * **********************************************************************
     */

    private void cleanField() {
        String name = jbNewPO.getName();
        System.out.println(name);
        
        jtfPurchaseOrderID.setText("");
        jtfDateCreated.setText("");
        jtfExpectedDeliveryDate.setText("");
        jtfSupplier.setText("");
        jcbStatus.setSelectedItem("");
        jcbCompletedStatus.setSelectedItem("");

        jtfPricePerUnit.setText("0");
        jtfQuantity.setText("0");
        jtfLineID.setText("");
        jcbPurchaseOrder.setSelectedItem("");
        jcbPartID.setSelectedItem("");

        jtfPartID.setText("");
        jtfManufacturer.setText("");
        jtfManufacturerDesc.setText("");
        jtfComponentDesc.setText("");
        jtfCurrentStock.setText("");
        jtfLowStock.setText("");
        jtfShelfLoc.setText("");

        purchaseorderline.getItemToComboBox(jcbPurchaseOrder, "purchaseorder", "PurchaseOrderID");
        purchaseorderline.getItemToComboBox(jcbPartID, "storeroom", "PartID");
    }

    /**
     * **********************************************************************
     */
    private ArrayList<JTextField> getPurchaseOrderJTextField() {
        ArrayList<JTextField> JTextFieldPurchaseOrder = new ArrayList<JTextField>();
        JTextFieldPurchaseOrder.add(0, jtfPurchaseOrderID);
        JTextFieldPurchaseOrder.add(1, jtfDateCreated);
        JTextFieldPurchaseOrder.add(2, jtfExpectedDeliveryDate);
        JTextFieldPurchaseOrder.add(3, jtfSupplier);

        return JTextFieldPurchaseOrder;

    }

    private ArrayList<JComboBox> getPurchaseOrderJComboBox() {
        ArrayList<JComboBox> JComboBoxPurchaseOrder = new ArrayList<JComboBox>();
        JComboBoxPurchaseOrder.add(0, jcbStatus);
        JComboBoxPurchaseOrder.add(1, jcbCompletedStatus);
        return JComboBoxPurchaseOrder;
    }
    /* ***********************************************************************/

    private ArrayList<JTextField> getPurchaseOrderLineJTextField() {
        ArrayList<JTextField> JTextField = new ArrayList<JTextField>();
        JTextField.add(0, jtfLineID);
        JTextField.add(1, jtfQuantity);
        JTextField.add(2, jtfPricePerUnit);

        return JTextField;

    }

    private ArrayList<JComboBox> getPurchaseOrderLineJComboBox() {

        ArrayList<JComboBox> JComboBox = new ArrayList<JComboBox>();
        JComboBox.add(0, jcbPurchaseOrder);
        JComboBox.add(1, jcbPartID);
        return JComboBox;
    }

    /**
     * **********************************************************************
     */
    private ArrayList<JTextField> getStoreRoomJTextField() {
        ArrayList<JTextField> JTextField = new ArrayList<JTextField>();
        JTextField.add(0, jtfPartID);
        JTextField.add(1, jtfManufacturer);
        JTextField.add(2, jtfManufacturerDesc);
        JTextField.add(3, jtfComponentDesc);
        JTextField.add(4, jtfCurrentStock);
        JTextField.add(5, jtfLowStock);
        JTextField.add(6, jtfShelfLoc);

        return JTextField;

    }

}
