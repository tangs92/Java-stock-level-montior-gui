/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursework123;

import java.util.ArrayList;


public class purchaseOrderManager {

    private String purchaseOrderID;

    private String dateCreated;

    private String expectedDeliveryDate;

    private String supplier;

    private String status;

    private String completedStatus;

    private ArrayList<String> purchaseOrderList = new ArrayList<String>();

    public void addItem() {
        purchaseOrderList.add(purchaseOrderID);
        purchaseOrderList.add(dateCreated);
        purchaseOrderList.add(expectedDeliveryDate);
        purchaseOrderList.add(supplier);
        purchaseOrderList.add(status);
        purchaseOrderList.add(completedStatus);
    }

    public void setPurchaseOrderID(String purchaseOrderID) {
        this.purchaseOrderID = purchaseOrderID;
    }

    public String getPurchaseOrderID() {
        return this.purchaseOrderID;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateCreated() {
        return this.dateCreated;
    }

    public void setExpectedDeliveryDate(String expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public String getExpectedDeliveryDate() {
        return this.expectedDeliveryDate;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getSupplier() {
        return this.supplier;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public void setCompletedStatus(String completedStatus) {
        this.completedStatus = completedStatus;
    }

    public String getCompletedStatus() {
        return this.completedStatus;
    }

    public ArrayList<String> getItem() {
        ArrayList<String> output = new ArrayList<>();
        output.addAll(purchaseOrderList);
        return output;
    }
    
    public void setItem(ArrayList<String> input) {
        purchaseOrderList.clear();
        purchaseOrderList.addAll(input);
    }
    

}
