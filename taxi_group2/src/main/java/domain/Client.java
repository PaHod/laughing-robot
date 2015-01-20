package domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Oles on 17.07.2014.
 */
@Entity
@Table (name = "CLIENTS")
public class Client {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(name = "FIRST_NAME")
    private String firstName;

    @NotNull
    @Column(name = "LAST_NAME")
    private String lastName;

    @NotNull
    @Column(name = "PHONE")
    private String phone;

    @NotNull
    @Column(name = "ADDRESS")
    private String address;

    @Fetch(FetchMode.SELECT)
    @OneToMany
    (cascade = CascadeType.ALL,
    fetch = FetchType.EAGER,
    mappedBy = "CLIENT")
    private Set<Order> orders;

    @Column(name="AMOUNT")
    private Double amount;

    @Temporal(TemporalType.DATE)
    @Column(name = "LAST_DATE")
    private Date lastDate;

    public Client() {
        orders = new HashSet<>();
    }

    public Client(String firstName, String lastName, String phone, String address) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Double getAmount() {
        if (this.orders == null || this.orders.isEmpty()) return 0D;
        if (this.orders.size() == 1) {
            return orders.iterator().next().getAmount();
        }
        Double result = 0D;
        Iterator<Order> iterator = orders.iterator();
        while (iterator.hasNext()) {
            result+=iterator.next().getAmount();
        }
        return result;
    }

    private void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getLastDate() {
        if (this.orders == null || this.orders.isEmpty()) return null;
        if (this.orders.size() == 1) {
            return orders.iterator().next().getDate();
        }
        Iterator<Order> iterator = orders.iterator();
        Date date = iterator.next().getDate();
        while (iterator.hasNext()) {
            Order order = iterator.next();
            if (order.getDate().after(date)) {
                date = order.getDate();
            }
        }
        return date;
    }

    private void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", orders=" + orders +
                ", amount=" + amount +
                ", lastDate=" + lastDate +
                '}';
    }
}
