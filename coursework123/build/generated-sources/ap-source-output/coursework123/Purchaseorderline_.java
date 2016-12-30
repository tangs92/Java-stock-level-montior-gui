package coursework123;

import coursework123.Purchaseorder;
import coursework123.Storeroom;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-01-27T10:48:50")
@StaticMetamodel(Purchaseorderline.class)
public class Purchaseorderline_ { 

    public static volatile SingularAttribute<Purchaseorderline, Integer> quantity;
    public static volatile SingularAttribute<Purchaseorderline, Storeroom> partID;
    public static volatile SingularAttribute<Purchaseorderline, Integer> lineID;
    public static volatile SingularAttribute<Purchaseorderline, Purchaseorder> purchaseOrderNum;
    public static volatile SingularAttribute<Purchaseorderline, Double> pricePerUnit;

}