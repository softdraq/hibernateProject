package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ShopOrder")
public class ShopOrder implements Serializable {

    @Column(name = "productsId")
    private int productsId;

    @Column(name = "idUser")
    private int idUser;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    @Column(name = "date")
    private Date date;

    @Column(name = "orderAmount")
    private int orderAmount;

    // Setters and getters
    public void setProductsId(int productsId) {
        this.productsId = productsId;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setDate() {
        this.date = new Date();
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }

    public int getProductId() {
        return this.productsId;
    }

    public int getIdUser() {
        return this.idUser;
    }

    public int getOrderId() {
        return this.orderId;
    }

    public Date getDate() {
        return this.date;
    }

    public int getOrderAmount() {
        return this.orderAmount;
    }

}
