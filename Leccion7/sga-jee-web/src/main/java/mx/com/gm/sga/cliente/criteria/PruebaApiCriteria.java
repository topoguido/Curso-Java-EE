package mx.com.gm.sga.cliente.criteria;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class PruebaApiCriteria {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Persona> criteriaQuery = null;
        Root<Persona> fromPersona = null;
        TypedQuery<Persona> query = null;
        Persona persona = null;
        List<Persona> personas = null;
        
        // Query utilizando el API de Criteria
        // 1. Consulta de todas las personas
        
        // Paso 1. El objeto EnttityManager crea instancia CriteriaBuilder
        cb = em.getCriteriaBuilder();
        
        // Paso 2. Se crea un objeto de CriteriaQuery
        criteriaQuery = cb.createQuery(Persona.class);
        
        // Paso 3. Creamos el objeto raiz de query
        fromPersona = criteriaQuery.from(Persona.class);
        
        // Paso 4. Seleccionamos lo necesario del from
        criteriaQuery.select(fromPersona);
        
        // Paso 5. Creamos el tipo de query typeSafe
        query = em.createQuery(criteriaQuery);
        
        // Paso 6. Ejecutamos la consulta
        personas = query.getResultList();
        //mostrarPersonas(personas);
        
        // 2-a. Consulta de la Persona con id = 1
        //jpql = "select p from Persona p where p.idPersona = 1";
        log.debug("\n 2-a. Consulta de la persona con id = 1");
        cb = em.getCriteriaBuilder();
        criteriaQuery = cb.createQuery(Persona.class);
        fromPersona = criteriaQuery.from(Persona.class);
        criteriaQuery.select(fromPersona).where(cb.equal(fromPersona.get("idPersona"), 1));
        persona = em.createQuery(criteriaQuery).getSingleResult();
        log.debug(persona);
        
        // 2-b. Consulta de la persona con id = 1
        log.debug("\n 2-b. Consulta de la persona con id = 1");
        cb = em.getCriteriaBuilder();
        criteriaQuery = cb.createQuery(Persona.class);
        fromPersona = criteriaQuery.from(Persona.class);
        criteriaQuery.select(fromPersona);
        
        // La clase Predicate permite agregar varios cruiterios dinamicamente
        List<Predicate> criterios = new ArrayList<Predicate>();
        
        // verificamos si tenemos criterios que agregar
        Integer idPersonaParam = 1;
        ParameterExpression<Integer> parameter = cb.parameter(Integer.class, "idPersona");
        criterios.add(cb.equal(fromPersona.get("idPersona"), parameter));
        
        // Se agregan los criterios
        if(criterios.isEmpty()){
            throw new RuntimeException("Sin criterios");
        } else if(criterios.size() == 1){
            criteriaQuery.where(criterios.get(0));
        } else {
            criteriaQuery.where(cb.and(criterios.toArray(new Predicate[0])));
        }
        
        query  = em.createQuery(criteriaQuery);
        query.setParameter("idPersona", idPersonaParam);
        
        // Se ejecuta el query
        persona = query.getSingleResult();
        log.debug(persona);
    }
    
    public static void mostrarPersonas(List<Persona> personas){
        for(Persona p: personas){
            log.debug(p);
        }
    }

}
