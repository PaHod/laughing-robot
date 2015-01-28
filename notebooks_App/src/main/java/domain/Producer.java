package domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by PaHod on 24.01.2015.
 */

@Entity
@Table(name = "PRODUCER")
public class Producer {
    @Id
    @GeneratedValue
    @Column(name = "PRODUCER_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "WEB_SITE")
    private String wedSite;
    @Column(name = "GOODS")
    @OneToMany(mappedBy = "producer", fetch = FetchType.LAZY)
    private Set<Goods> goods = new HashSet<>();

    public Producer() {
    }

    public Producer(String name, String address, String wedSite) {
        this.name = name;
        this.address = address;
        this.wedSite = wedSite;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWedSite() {
        return wedSite;
    }

    public void setWedSite(String wedSite) {
        this.wedSite = wedSite;
    }

    public Set<Goods> getGoods() {
        return goods;
    }

    public void setGoods(Set<Goods> goods) {
        this.goods = goods;
    }

    @Override
    public String toString() {
        return "Producer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", wedSite='" + wedSite + '\'' +
                '}';
    }
}
