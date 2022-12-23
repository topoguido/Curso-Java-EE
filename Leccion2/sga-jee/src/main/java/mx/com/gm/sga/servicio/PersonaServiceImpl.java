package mx.com.gm.sga.servicio;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import mx.com.gm.sga.domain.Persona;

@Stateless
public class PersonaServiceImpl implements PersonaServiceRemote {

    @Override
    public List<Persona> listarPersonas() {
        List<Persona> personas = new ArrayList<Persona>();
        personas.add(new Persona(1, "Juan", "Perez", "jperez@mail.com","123456"));
        personas.add(new Persona(2, "Marta", "Suarez", "msuarez@mail.com","654321"));
        
        return personas;
    }

    @Override
    public Persona encontrarPersonaPorId(Persona persona) {
        return null;
    }

    @Override
    public Persona encontrarPersonaPorEmail(Persona persona) {
        return null;
    }

    @Override
    public void registrarPersona(Persona persona) {
    }

    @Override
    public void modificarPersona(Persona persona) {
    }

    @Override
    public void eliminarPersona(Persona persona) {
    }

}
