package coursework123;

import coursework123.Purchaseorderline;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-01-27T10:48:50")
@StaticMetamodel(Purchaseorder.class)
public class Purchaseorder_ { 

    public static volatile SingularAttribute<Purchaseorder, Date> dateCreated;
    public static volatile SingularAttribute<Purchaseorder, String> purchaseOrderID;
    public static volatile SingularAttribute<Purchaseorder, Date> expectedDeliveryDate;
    public static volatile SingularAttribute<Purchaseorder, String> supplier;
    public static volatile SingularAttribute<Purchaseorder, String> completedStatus;
    public static volatile CollectionAttribute<Purchaseorder, Purchaseorderline> purchaseorderlineCollection;
    public static volatile SingularAttribute<Purchaseorder, String> status;

}