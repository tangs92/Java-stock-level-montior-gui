package coursework123;

import coursework123.Purchaseorderline;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-01-27T10:48:50")
@StaticMetamodel(Storeroom.class)
public class Storeroom_ { 

    public static volatile SingularAttribute<Storeroom, String> shelfLocation;
    public static volatile SingularAttribute<Storeroom, String> partID;
    public static volatile SingularAttribute<Storeroom, String> componentDescription;
    public static volatile SingularAttribute<Storeroom, Integer> currentStockLevel;
    public static volatile CollectionAttribute<Storeroom, Purchaseorderline> purchaseorderlineCollection;
    public static volatile SingularAttribute<Storeroom, String> manufacturerDescription;
    public static volatile SingularAttribute<Storeroom, String> manufacturer;
    public static volatile SingularAttribute<Storeroom, Integer> lowstockLevel;

}