package session14.dentist.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by PaHod on 17.06.2014.
 */
@Entity
@Table(name = "DOCTOR")
public class Doctor {
    @Id
    @GeneratedValue
    @Column(name = "DOCTOR_ID")
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "doctor",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private Set<Client> clients = new HashSet<>();

    public Doctor() {
    }

    public Doctor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

public void addClient(Client client){
   this.clients.add(client);
    client.setDoctor(this);
}
    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + name + '\'' +
                ", clents=" + clients +
                '}';
    }
}
