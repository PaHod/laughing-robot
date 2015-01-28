package domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by PaHod on 24.01.2015.
 */

@Entity
@Table(name = "GOODS")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Goods {
    @Id
    @GeneratedValue
    @Column(name = "GOODS_ID")
    private Long goodsId;

    //    @Column(name = "CATEGORY")
    @ManyToOne
    private Category category;

    @Column(name = "MODEL", nullable = false)
    private String model;

    //    @Column(name = "PRODUCER", nullable = false)
    @ManyToOne
    private Producer producer;


    @Column(name = "RELEASE_DATE")
    private Date releaseDate;


}
