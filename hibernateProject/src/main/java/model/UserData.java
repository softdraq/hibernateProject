package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "UserData")
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int userDataId;
    @Column(name = "username")
    protected String username;
    @Column(name = "pwd")
    protected String pwd;
    @Column(name = "email")
    protected String email;
    @Column(name = "address")
    protected String address;
    @Column(name = "phone")
    protected int phone;
    @Column(name = "userRegistrationDate")
    protected Date date;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setDate() {
        this.date = new Date();
    }

    public int getUserDataId() {
        return this.userDataId;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPwd() {
        return this.pwd;
    }

    public String getAddress() {
        return this.address;
    }

    public int getPhone() {
        return this.phone;
    }

    public Date getDate() {
        return this.date;
    }

    public String getDateToString() {
        return this.getDate().toString();
    }

}
