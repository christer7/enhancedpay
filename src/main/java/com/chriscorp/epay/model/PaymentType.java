package com.chriscorp.epay.model;

import javax.persistence.Entity;

@Entity
public enum PaymentType {
    CREDIT_CARD,
    BOLETO
}
