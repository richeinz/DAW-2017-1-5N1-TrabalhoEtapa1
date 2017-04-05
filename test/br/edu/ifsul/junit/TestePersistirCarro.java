/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.junit;

import br.edu.ifsul.modelo.Carro;
import br.edu.ifsul.modelo.Pessoa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Ricardo
 */
public class TestePersistirCarro {
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirCarro() {
    }
    
    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("DAW-TRABALHO1");
        em = emf.createEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    
    @Test
    public void testar(){
        boolean exception = false;
        try {
            Carro c = new Carro();
            c.setPalca("BGF 1234");
            c.setRenavam("97845123");
            c.setModelo("Jeta");
            c.setFabricante("VW");
            c.setAnoFabricacao(2017);
            c.setAnoModelo(2017);
            c.setPessoa(em.find(Pessoa.class, 4));
                    
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        }catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        //vou verificar se o resultado é o esperado
        Assert.assertEquals(false, exception);
    }
    
}
