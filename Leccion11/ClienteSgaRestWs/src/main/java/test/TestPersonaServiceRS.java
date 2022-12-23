package test;

import domain.Persona;
import java.util.List;
import javax.ws.rs.client.*;
import javax.ws.rs.core.*;

public class TestPersonaServiceRS {
    // Variables a utilizar
    private static final String url_base = "http://localhost:8080/sga-jee-web/webservice";
    private static Client cliente;
    private static WebTarget webTarget;
    private static Persona persona;
    private static List<Persona> personas;
    private static Invocation.Builder invocationBuilder;
    private static Response response;
    
    public static void main(String[] args) {
        
        cliente  = ClientBuilder.newClient();
        
        //Leer una persona (metodo get)
        webTarget = cliente.target(url_base).path("/personas");
        //Proporcionamos un id persona valido
        persona = webTarget.path("/1").request(MediaType.APPLICATION_XML).get(Persona.class);
        System.out.println("Persona recuperada: " + persona );
        
        //Leer todas las personas (metodo get con readEntity de tipo List<>)
        personas = webTarget.request(MediaType.APPLICATION_XML).get(Response.class).readEntity(new GenericType<List<Persona>>(){});
        System.out.println("\nPersonas recuperadas:");
        imiprimirPersonas(personas);
        
        //Agregar una persona
        Persona nuevaPersona = new Persona();
        nuevaPersona.setNombre("Juan Carlos");
        nuevaPersona.setApellido("Guido");
        nuevaPersona.setEmail("jcss@mail.com");
        nuevaPersona.setTelefono("123789");
        
        invocationBuilder = webTarget.request(MediaType.APPLICATION_XML);
        response = invocationBuilder.post(Entity.entity(nuevaPersona, MediaType.APPLICATION_XML));
        System.out.println("");
        System.out.println(response.getStatus());
        //Recuperamos la persona recien agregada para despues modificarla y luego eliminarla
        Persona personaRecuperada = response.readEntity(Persona.class);
        System.out.println("Persona agregada: " + personaRecuperada );
        
        //Modificar la persona agregada (metodo put)
        //Persona recueperada anteriormente
        Persona personaModificar = personaRecuperada;
        personaModificar.setApellido("Serrano");
        String pathId = "/" + personaModificar.getIdPersona();
        invocationBuilder = webTarget.path(pathId).request(MediaType.APPLICATION_XML);
        response = invocationBuilder.put(Entity.entity(personaModificar, MediaType.APPLICATION_XML));
        System.out.println("");
        System.out.println("response: " + response.getStatus() );
        System.out.println("Persona modificada: " + response.readEntity(Persona.class));
        
        //eliminar una persona
        Persona personaEliminar = personaRecuperada;
        String pathEliminarId = "/" + personaEliminar.getIdPersona();
        invocationBuilder = webTarget.path(pathEliminarId).request(MediaType.APPLICATION_XML);
        response = invocationBuilder.delete();
        System.out.println("");
        System.out.println("response: " + response.getStatus());
        System.out.println("Persona eliminada = " + personaEliminar);
    }

    private static void imiprimirPersonas(List<Persona> personas) {
        
        for(Persona p: personas){
            System.out.println("Persona: " + p);
        }
    }
}
