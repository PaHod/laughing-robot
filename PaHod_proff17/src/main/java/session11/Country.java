package session11;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by PaHod on 09.06.2014.
 *  * создать отображение для таблици coutries
 */
@Entity
@Table(name = "COUNTRIES")
public class Country {
    @Id
    @Column(name=  "COUNTRY_ID", length = 2, columnDefinition = "char")
    private String id;

    @Column(name = "COUNTRY_NAME")
    private String name;
    @Column(name = "REGION_ID")
    private Long regId;

    public Country() {
    }

    public Country(String id, String name, Long regId) {
        this.id = id;
        this.name = name;
        this.regId = regId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRegId() {
        return regId;
    }

    public void setRegId(Long regId) {
        this.regId = regId;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", regId=" + regId +
                '}';
    }
}
