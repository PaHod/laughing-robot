package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Created by PaHod on 24.01.2015.
 */

@Entity
@Table(name = "GRAPHIC_CARD")
@PrimaryKeyJoinColumn(name = "GOODS_ID")
public class GraphicCard extends Goods {

    @Column(name = "MEMORY_SIZE", nullable = false)
    private Integer memorySize;

//    private Enum<String> typeOfGraphics; // integrate, discrete

}
