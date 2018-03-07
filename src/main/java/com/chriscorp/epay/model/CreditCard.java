package com.chriscorp.epay.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50)
    private String creditCardHolderName;

    private long creditCardNumber;

    @Temporal(TemporalType.DATE)
    private Date experiationDate;

    private int ccv;

    public Long getId() {
        return id;
    }

    public String getCreditCardHolderName() {
        return creditCardHolderName;
    }

    public void setCreditCardHolderName(String creditCardHolderName) {
        this.creditCardHolderName = creditCardHolderName;
    }

    public long getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(long creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public Date getExperiationDate() {
        return experiationDate;
    }

    public void setExperiationDate(Date experiationDate) {
        this.experiationDate = experiationDate;
    }

    public int getCcv() {
        return ccv;
    }

    public void setCcv(int ccv) {
        this.ccv = ccv;
    }


}
