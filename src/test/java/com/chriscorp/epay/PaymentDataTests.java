package com.chriscorp.epay;

import static org.junit.Assert.assertEquals;

import com.chriscorp.epay.model.*;
import com.chriscorp.epay.repository.PaymentDataJpaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;

@ContextConfiguration(locations = {"classpath:com/chriscorp/epay/applicationTests-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class PaymentDataTests {

    @Autowired
    private PaymentDataJpaRepository paymentDataJpaRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    @Transactional
    public void testSaveAndGetCreditCard() throws Exception {
        Client c = new Client();
        c.setClientId("WallyMart");

        Buyer b1 = new Buyer();
        b1.setName("Gunnar");
        b1.setEmail("gunnar@hotmale.com");
        b1.setCpf(12341234);

        CreditCard c1 = new CreditCard();
        c1.setCreditCardHolderName("Allan Svensson");
        c1.setCreditCardNumber(1234_1234_1234_1234L);
        c1.setExperiationDate(new Date(2020,1,1));
        c1.setCcv(123);

        PaymentData p1 = new PaymentData();
        p1.setClient(c);
        p1.setBuyer(b1);
        p1.setCreditCard(c1);

        p1.setPaymentType(PaymentType.CREDIT_CARD);

        p1 = paymentDataJpaRepository.saveAndFlush(p1);

        entityManager.clear();

        PaymentData otherPayment = paymentDataJpaRepository.findOne(p1.getId());

        assertEquals("Gunnar", otherPayment.getBuyer().getName());
        assertEquals("WallyMart", otherPayment.getClient().getClientId());
        assertEquals(PaymentType.CREDIT_CARD, otherPayment.getPaymentType());
        assertEquals("Allan Svensson", otherPayment.getCreditCard().getCreditCardHolderName());

        paymentDataJpaRepository.delete(p1);
    }

    @Test
    @Transactional
    public void testSaveAndGetBoleto() throws Exception {
        Client c = new Client();
        c.setClientId("WallyMart");

        Buyer b1 = new Buyer();
        b1.setName("Gunnar");
        b1.setEmail("gunnar@hotmale.com");
        b1.setCpf(12341234);

        Boleto bNr1 = new Boleto();
        bNr1.setBoletoNumber("987654321");


        PaymentData p1 = new PaymentData();
        p1.setClient(c);
        p1.setBuyer(b1);
        p1.setBoleto(bNr1);

        p1.setPaymentType(PaymentType.BOLETO);

        p1 = paymentDataJpaRepository.saveAndFlush(p1);

        entityManager.clear();

        PaymentData otherPayment = paymentDataJpaRepository.findOne(p1.getId());

        assertEquals("Gunnar", otherPayment.getBuyer().getName());
        assertEquals("WallyMart", otherPayment.getClient().getClientId());
        assertEquals(PaymentType.BOLETO, otherPayment.getPaymentType());
        assertEquals("987654321", otherPayment.getBoleto().getBoletoNumber());

        paymentDataJpaRepository.delete(p1);
    }

}
