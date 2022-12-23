package mx.com.sga.cliente.ciclovidajpa;

import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.*;

public class PersistirObjetoJPA {
    static Logger log = LogManager.getRootLogger();
   
    public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();
    
    // Inicia la transaccion
    
    // Paso 1. Crea nuevo objeto
    //Objeto en estado transitivo
    Persona persona1 = new Persona("Pedro","Luna","pluna@mail.com","123456");
    
    // Paso 2. Inicia trasaccion;
    tx.begin();
    
    // Paso 3. Ejecutamos SQL
     em.persist(persona1);
     
     log.debug("Objeto persistido - aun sin commit: " + persona1);
     
     // Paso 4. commit
     tx.commit();
     
     // Objeto en estado detached
     log.debug("Objeto persistido - estado detached: " + persona1);
     
     // Cerramos el entity manager
     em.close();
     
    }
    
}
