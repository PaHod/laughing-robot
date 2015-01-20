package domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Oles on 17.07.2014.
 */
@Entity
@Table (name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "CLIENT")
    private Client client;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date orderDate;

    @NotNull
    @Column(name = "AMOUNT")
    private Double amount;

    @NotNull
    @Column(name = "START")
    private String startAddress;

    @Column(name = "FINISH")
    private String finishAddress;

    public Order() {}

    public Order(Client client, Date orderDate, Double amount, String startAddress, String finishAddress) {
        this.client = client;
        this.orderDate = orderDate;
        this.amount = amount;
        this.startAddress = startAddress;
        this.finishAddress = finishAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getDate() {
        return orderDate;
    }

    public void setDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getStartAddress() {
        return startAddress;
    }

    public void setStartAddress(String startAddress) {
        this.startAddress = startAddress;
    }

    public String getFinishAddress() {
        return finishAddress;
    }

    public void setFinishAddress(String finishAddress) {
        this.finishAddress = finishAddress;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", client=" + client +
                ", date=" + orderDate +
                ", amount=" + amount +
                ", startAddress='" + startAddress + '\'' +
                ", finishAddress='" + finishAddress + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (!amount.equals(order.amount)) return false;
        if (!client.equals(order.client)) return false;
        if (!orderDate.equals(order.orderDate)) return false;
        if (finishAddress != null ? !finishAddress.equals(order.finishAddress) : order.finishAddress != null)
            return false;
        if (!startAddress.equals(order.startAddress)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = client.hashCode();
        result = 31 * result + orderDate.hashCode();
        result = 31 * result + amount.hashCode();
        result = 31 * result + startAddress.hashCode();
        result = 31 * result + (finishAddress != null ? finishAddress.hashCode() : 0);
        return result;
    }
}
