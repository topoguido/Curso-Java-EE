
package mx.com.gm.sga.cliente.cascade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.domain.Usuario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PersistenciaCascadaJPA {
    
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        // Paso 1. Creo nuevo objeto
        // Objeto en estado transitico
        Persona persona1 = new Persona("Hugo", "Hernandez", "hhernandez@mail.com","123456");
        
        // Crear objeto usuario (tiene dependencia con el objeto persona)
        Usuario usuario1 = new Usuario("hhernandez","123", persona1);
        
        // Paso 3. Persistimos el objeto usuario
        em.persist(usuario1);
        
        // Paso 4. commit Transaction
        tx.commit();
        
        // Objetos en estado detached
        log.debug("objeto persona: " + persona1);
        log.debug("objeto usuario: " + usuario1);
        
        em.close();
    }

}
