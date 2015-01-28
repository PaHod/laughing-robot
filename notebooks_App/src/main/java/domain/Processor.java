package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Created by PaHod on 24.01.2015.
 */
@Entity
@Table(name = "PROCESSOR")
@PrimaryKeyJoinColumn(name = "GOODS_ID")
public class Processor extends Goods {

    @Column(name = "NUMBER_OF_CORES", nullable = false)
    private Integer numberOfCores;

    @Column(name = "FREQUENCY", nullable = false)
    private Double frequency;

}
