package com.chriscorp.epay.model;

import javax.persistence.*;
import javax.persistence.CascadeType;

@Entity
public class PaymentData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn
    private Client client;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn
    private Buyer buyer;

    private PaymentType paymentType;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn
    private CreditCard creditCard;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn
    private Boleto boleto;

    public Long getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public Boleto getBoleto() {
        return boleto;
    }

    public void setBoleto(Boleto boleto) {
        this.boleto = boleto;
    }
}
