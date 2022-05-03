package mx.com.gm.sga.servicio;

import java.util.List;
import javax.ejb.Local;
import mx.com.gm.sga.domain.Usuario;

@Local
public interface UsuarioService {
    
    public List<Usuario> listarUsuarios();
    public Usuario buscarPorId(Usuario usuario);
    public Usuario buscarPorIdPersona(Usuario usuario);
    public Usuario buscarPorUsuario(Usuario usuario);
    public void guardarUsuario(Usuario usuario);
    public void editarUsuario(Usuario usuario);
    public void eliminarUsuario(Usuario usuario);

}
