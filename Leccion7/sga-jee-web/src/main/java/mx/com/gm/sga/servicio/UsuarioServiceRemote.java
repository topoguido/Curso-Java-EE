package mx.com.gm.sga.servicio;

import java.util.List;
import javax.ejb.Remote;
import mx.com.gm.sga.domain.Usuario;

@Remote
public interface UsuarioServiceRemote {
    public List<Usuario> listarUsuarios();
    public Usuario buscarPorId(Usuario usuario);
    public Usuario buscarPorIdPersona(Usuario usuario);
    public Usuario buscarPorUsuario(Usuario usuario);
    public void guardarUsuario(Usuario usuario);
    public void editarUsuario(Usuario usuario);
    public void eliminarUsuario(Usuario usuario);
}