package br.edu.ifsul.junit;

import br.edu.ifsul.modelo.Carro;
import br.edu.ifsul.modelo.Corretor;
import br.edu.ifsul.modelo.Seguro;
import br.edu.ifsul.modelo.Sinistro;
import java.util.Calendar;
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
public class TestePersistirSinistro {
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirSinistro() {
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
            Seguro seg = em.find(Seguro.class, 2);
            Sinistro s = new Sinistro();
            s.setCidade("Pouso Alegre");
            s.setEstado("RS");
            s.setData(Calendar.getInstance());
            s.setDescricao("sinistro em um dia de sol...blá blá blá");
            s.setSeguro(seg);
            em.getTransaction().begin();
            em.persist(s);
            em.getTransaction().commit();
        }catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        //vou verificar se o resultado é o esperado
        Assert.assertEquals(false, exception);
    }
    
}
