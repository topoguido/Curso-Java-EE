
package mx.com.sga.cliente.ciclovidajpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ActualizarObjetoSesionLarga {
    private static final Logger log = LogManager.getLogger(ActualizarObjetoSesionLarga.class);

    public static void main(String[] args) {
       
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        // Inicia la transaccion
        // Paso 1. Obtener transaccion
        tx.begin();

        // Paso 2. Ejecuta SQL de tipo select
        Persona persona1 = em.find(Persona.class, 1);
        
        log.debug("Objeto encontrado: " + persona1);
        
        // Paso 3. setValue(nuevoValor)
        persona1.setEmail("jjuarez@mail.com");
        
        // Paso 4. Termina la transaccion
        tx.commit();
        
        // Objeto en estado detached
        log.debug("Objeto modificado: " + persona1);
        
        // Cerramos el entity manager
        em.close();
    }
}
