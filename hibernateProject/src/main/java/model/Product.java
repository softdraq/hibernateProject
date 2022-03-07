package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    @Column(name = "brandId")
    private int brandId;
    @Column(name = "shopStorageId")
    private int shopStorageId;

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public void setShopStorageId(int shopStorageId) {
        this.shopStorageId = shopStorageId;
    }

    public int getProductId() {
        return this.productId;
    }

    public int getBrandId() {
        return this.brandId;
    }

    public int getShopStorageId() {
        return this.shopStorageId;
    }

}
