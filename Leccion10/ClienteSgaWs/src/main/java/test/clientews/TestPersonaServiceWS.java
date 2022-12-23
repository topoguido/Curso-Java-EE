
package test.clientews;

import clientews.servicio.Persona;
import clientews.servicio.PersonaServiceImplService;
import clientews.servicio.PersonaServiceWS;
import java.util.List;


public class TestPersonaServiceWS {
    public static void main(String[] args) {
        PersonaServiceWS personaService = new PersonaServiceImplService().getPersonaServiceImplPort();
        System.out.println("Ejecutando servicio listar personas ws");
        List<Persona> personas = personaService.listarPersonas();
        for(Persona persona: personas){
            System.out.println("persona idPersona = " + persona.getIdPersona() + ", nombre: " + persona.getNombre() + 
                    ", apellido: " + persona.getApellido() + ", email: " + persona.getEmail());
        }
        
        System.out.println("Fin de servicio listar personas ws");
        
    }

}
