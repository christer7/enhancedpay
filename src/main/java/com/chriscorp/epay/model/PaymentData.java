package com.chriscorp.epay.model;

import javax.persistence.*;

@Entity
public class PaymentData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn
    private Client client;

    @OneToOne
    @JoinColumn
    private Buyer buyer;

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "PaymentData{" +
                "id=" + id +
                ", client=" + client +
                ", buyer=" + buyer +
                '}';
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

}
