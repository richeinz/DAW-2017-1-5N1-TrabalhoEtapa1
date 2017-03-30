package br.edu.ifsul.junit;

import br.edu.ifsul.modelo.Carro;
import br.edu.ifsul.modelo.Corretor;
import br.edu.ifsul.modelo.Seguro;
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
public class TestePersistirSeguro {
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirSeguro() {
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
            Seguro s = new Seguro();
            s.setCarro(em.find(Carro.class, 4));
            s.setCorretor(em.find(Corretor.class, 5));
            s.setData(Calendar.getInstance());
            s.setInicioVigencia(Calendar.getInstance());
            s.setFimVigencia(Calendar.getInstance());
            s.setValorTotal(1200.22);
            s.setValorFipe(45000.00);
                    
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
