package mx.com.gm.sga.cliente;

import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.servicio.PersonaServiceRemote;

public class ClientePersonaService {
    public static void main(String[] args) {
        System.out.println("Iniciando llamada al EJB desde el cliente\n");
        try {
            Context jndi = new InitialContext();
            PersonaServiceRemote personaService = (PersonaServiceRemote) jndi.lookup("java:global/sga-jee/PersonaServiceImpl!mx.com.gm.sga.servicio.PersonaServiceRemote");
            List<Persona> personas = personaService.listarPersonas();
            
            for(Persona persona: personas){
                System.out.println("persona = " + persona);
            }
            System.out.println("Fin de la llamada al EJB desde el cliente\n");
            
        } catch (NamingException ex) {
            ex.printStackTrace(System.out);
        }
    }

}
