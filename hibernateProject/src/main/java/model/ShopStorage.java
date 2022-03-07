package model;

import javax.persistence.*;

@Entity
@Table(name = "shopStorage")
public class ShopStorage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int shopStorageId;

    @Column(name = "shopStorageName")
    private String shopStorageName;

    @Column(name = "shopStorageCount")
    private int shopStorageCount;

    @Column(name = "shopStoragePrice")
    private double shopStoragePrice;

    //Setters and getters
    public void setShopStorageName(String shopStorageName) {
        this.shopStorageName = shopStorageName;
    }

    public void setStorageCount(int shopStorageCount) {
        this.shopStorageCount = shopStorageCount;
    }

    public void setShopStoragePrice(double shopStoragePrice) {
        this.shopStoragePrice = shopStoragePrice;
    }

    public int getShopStorageId() {
        return this.shopStorageId;
    }

    public String getShopStorageName() {
        return this.shopStorageName;
    }

    public int getShopStorageCount() {
        return this.shopStorageCount;
    }

    public double getShopStoragePrice() {
        return this.shopStoragePrice;
    }

}
