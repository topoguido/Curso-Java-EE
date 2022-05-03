package mx.com.gm.sga.datos;

import java.util.List;
import javax.ejb.Local;
import mx.com.gm.sga.domain.Persona;

@Local
public interface PersonaDao {
    public List<Persona> findAllPersonas();
    public Persona findPersonaById(Persona persona);
    public Persona findPersonaByEmail(Persona persona);
    public void insertarPersona(Persona persona);
    public void updatePersona(Persona persona);
    public void deletePersona(Persona persona);
}
