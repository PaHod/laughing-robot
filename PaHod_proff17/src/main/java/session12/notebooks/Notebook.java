package session12.notebooks;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by PaHod on 10.06.2014.
 * создать сущьность ноутбук с полями айди, серийный нормер, производитель, модель, дата выпуска, цена
 */
@Entity
@Table(name = "NOTEBOOKS")
public class Notebook {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_NOTEBOOKS_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="sequence")
    @Column(name = "NOTEBOOK_ID")
    private Long id;

    @Column(name = "NOTEBOOK_SERIAL")
    private String serial;
    @Column(name = "")
    private String producer;

    private String model;

    private Date produceDate;




}
