package domain;

import javax.persistence.*;

/**
 * Created by PaHod on 24.01.2015.
 */

@Entity
@Table(name = "NOTEBOOK")
@PrimaryKeyJoinColumn(name = "GOODS_ID")
public class Notebook extends Goods {

    //    @Column(name = "PROCESSOR", nullable = false)
    @ManyToOne
    private Processor processor;

    //    @Column(name = "GRAPHIC_CARD", nullable = false)
    @ManyToOne
    private GraphicCard graphicCard;

//    @Column(name = "RAM", nullable = false)
    @ManyToOne
    private RAM RAM;

    @ManyToOne
//    @Column(name = "ROM", nullable = false)
    private ROM ROM;

    @ManyToOne
    //    @Column(name = "LCD", nullable = false)
    private LCD LCD;

}
