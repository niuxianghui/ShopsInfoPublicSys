package com.zzu.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by niuxianghui on 17/3/21.
 */

@Entity
public class Merchant implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "merchant_id")
    private Long id;

    @Column(name = "merchant_introduction")
    private String introduction;

    @Column(name = "merchant_address")
    private String address;

    @Column(name = "merchant_user_name", nullable = false)
    private String userName;

    @Column(name = "merchant_passwd", nullable = false)
    private String passWd;

    private String category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWd() {
        return passWd;
    }

    public void setPassWd(String passWd) {
        this.passWd = passWd;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
