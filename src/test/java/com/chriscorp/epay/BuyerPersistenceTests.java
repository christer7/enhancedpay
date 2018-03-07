package com.chriscorp.epay;

import static org.junit.Assert.assertEquals;

import com.chriscorp.epay.model.Buyer;
import com.chriscorp.epay.repository.BuyerJpaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ContextConfiguration(locations = {"classpath:com/chriscorp/epay/applicationTests-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class BuyerPersistenceTests {

    @Autowired
    private BuyerJpaRepository buyerJpaRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    @Transactional
    public void testSaveAndGetAndDelete() throws Exception {
        Buyer b1 = new Buyer();
        b1.setName("Johan Svensson");
        b1.setEmail("johan@svensson.se");
        b1.setCpf(12345678);
        b1 = buyerJpaRepository.saveAndFlush(b1);

        Buyer b2 = new Buyer();
        b2.setName("Sven Johansson");
        b2.setEmail("sven@johansson.se");
        b2.setCpf(87654321);
        b2 = buyerJpaRepository.saveAndFlush(b2);
        entityManager.clear();

        Buyer otherBuyer = buyerJpaRepository.findOne(b1.getId());
        assertEquals("Johan Svensson", otherBuyer.getName());

        //buyerJpaRepository.delete(otherBuyer);

    }

    @Test
    public void testGetAllBuyerNames() throws Exception {
        List<Buyer> buyerList = buyerJpaRepository.findAll();
        for (Buyer b : buyerList) {
            System.out.println(b.getName());
        }
    }


}

