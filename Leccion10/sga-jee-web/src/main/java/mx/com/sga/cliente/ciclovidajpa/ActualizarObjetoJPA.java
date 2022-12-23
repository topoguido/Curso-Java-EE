package mx.com.sga.cliente.ciclovidajpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ActualizarObjetoJPA {

    private static final Logger log = LogManager.getLogger(ActualizarObjetoJPA.class);

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        // Inicia la transaccion
        // Paso 1. Obtener transaccion
        tx.begin();

        // Paso 2. Ejecuta SQL de tipo select
        // El id debe de existir en la base de datos
        Persona persona1 = em.find(Persona.class, 1);
        
        //Paso 3. Termina la transaccion 1
        tx.commit();
        
        //Objeto en estado de detached
        log.debug("Objeto recuperado: " + persona1);
        
        //Paso 4. setValue (nuevoValor)
        persona1.setApellido("Juarez");
        
        //Paso 5. Inicia transaccion 2
        EntityTransaction tx2 = em.getTransaction();
        tx2.begin();
        
        //Paso 6. Modificamos el objeto
        em.merge(persona1);
        
        //paso 7. Termina transaccion
        tx2.commit();
        
        //Objeto en estado detached ya modificado
        log.debug("Objeto recuperado: " + persona1);

        // Cerramos el entity manager
        em.close();

    }
}
