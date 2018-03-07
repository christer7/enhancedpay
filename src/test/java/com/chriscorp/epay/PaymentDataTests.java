package com.chriscorp.epay;

import static org.junit.Assert.assertEquals;

import com.chriscorp.epay.model.Buyer;
import com.chriscorp.epay.model.Client;
import com.chriscorp.epay.model.PaymentData;
import com.chriscorp.epay.repository.PaymentDataJpaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ContextConfiguration(locations = {"classpath:com/chriscorp/epay/applicationTests-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class PaymentDataTests {

    @Autowired
    private PaymentDataJpaRepository paymentDataJpaRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    @Transactional
    public void testSaveAndGet() throws Exception {
        Client c = new Client();
        c.setClientId("WallyMart");

        Buyer b1 = new Buyer();
        b1.setName("Gunnar");
        b1.setEmail("gunnar@hotmale.com");
        b1.setCpf(12341234);

        PaymentData p1 = new PaymentData();
        p1.setClient(c);
        p1.setBuyer(b1);
        p1 = paymentDataJpaRepository.saveAndFlush(p1);

        entityManager.clear();

        PaymentData otherPayment = paymentDataJpaRepository.findOne(p1.getId());

        assertEquals("Gunnar", otherPayment.getBuyer().getName());
        assertEquals("WallyMart", otherPayment.getClient().getClientId());

        System.out.println(otherPayment.toString());




    }

}
