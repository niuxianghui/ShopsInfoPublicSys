package com.zzu.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by niuxianghui on 17/3/21.
 */
@Entity
public class Good implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "good_id")
    private Long id;

    @Column(name = "good_introduction")
    private String introduction;

    @Column(name = "merchant_id", nullable = false)
    private Long merchantId;

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

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }
}
