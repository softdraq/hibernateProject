package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "Brand")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int brandId;
    @Column(name = "brandName")
    private String brandName;
    @Column(name = "brandDescription")
    private String brandDescription;
    @Column(name = "brandRegistrationDate")
    private Date date;

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setBrandDescription(String brandDescription) {
        this.brandDescription = brandDescription;
    }

    public void setBrandRegistrationDate() {
        this.date = new Date();
    }

    public Integer getBrandId() {
        return this.brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getBrandDescription() {
        return brandDescription;
    }

    public Date getBrandRegistrationDate() {
        return this.date;
    }

    public String getBrandRegistrationDateAsString() {
        return this.getBrandRegistrationDate().toString();
    }

}
