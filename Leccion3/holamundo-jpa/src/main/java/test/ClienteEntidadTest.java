/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.*;

public class ClienteEntidadTest {
    static Logger log = LogManager.getRootLogger();
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        //Inicia transaccion
        tx.begin();
        
        Persona persona1 = new Persona("Juan", "Gomez", "jgomez@mail.com", "123456");
        
        log.debug("Objeto a persistir" + persona1);
        
        //Persiste objeto
        em.persist(persona1);
        //termina transaccion
        tx.commit();
        log.debug("Objeto persistido" + persona1);
        em.close();
    }
    
}
