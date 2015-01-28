package domain;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by PaHod on 24.01.2015.
 */
@Entity
@Table(name = "STORE_HOUSE")
public class StoreHouse {
    private Long id;
    private Notebook notebook;
    private Double price;
    private Vendor vendor;
    private Date dateOfPurchase;
    private Integer numberOfNotebooks;


}
