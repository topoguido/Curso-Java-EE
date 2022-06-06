
package mx.com.sga.cliente.ciclovidajpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class EliminarObjetoJPA {
    
    private static final Logger log = LogManager.getLogger(EliminarObjetoJPA.class);
    
    public static void main(String[] args) {
       
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        // Inicia la transaccion
        // Paso 1. Obtener transaccion
        tx.begin();

        // Paso 2. Ejecuta SQL de tipo select
        Persona persona1 = em.find(Persona.class, 4);
        
        log.debug("Objeto encontrado: " + persona1);
        
        // Paso 3. Termina la transaccion 1
        tx.commit();
        
        // Objeto en estado detached
        log.debug("Objeto modificado: " + persona1);
        
        // Paso 4. Incia segunda transaccion
        EntityTransaction tx2 = em.getTransaction();
        tx2.begin();
        
        // Paso 5. Ejecuta SQL que es un delete
        em.remove(em.merge(persona1));

        // Paso 6. Termina la transaccion 2
        tx2.commit();
        
        // Objeto en estado detached
        log.debug("Objeto modificado: " + persona1);
        
        // Cerramos el entity manager
        em.close();
    }

}
