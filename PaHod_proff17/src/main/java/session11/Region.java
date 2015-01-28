package session11;

import javax.persistence.*;

/**
 * Created by PaHod on 09.06.2014.т
 *
 * создать котенен антарктида потом изменить имя на введеное с клавы
 * получить объект из базы и вывести на экран
 */

@Entity
@Table(name= "REGIONS")
public class Region {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_REGIONS_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "REGION_ID")
    private Long id;

    @Column(name = "REGION_NAME")
    private String name;

    public Region() {
    }

    public Region(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}




