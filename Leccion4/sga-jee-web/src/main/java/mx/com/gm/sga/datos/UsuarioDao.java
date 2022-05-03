package mx.com.gm.sga.datos;

import java.util.List;
import javax.ejb.Local;
import mx.com.gm.sga.domain.Usuario;

@Local
public interface UsuarioDao {
    public List<Usuario> findAllUsuarios();
    public Usuario findUsuarioById(Usuario usuario);
    public Usuario findUsuarioByIdPersona(Usuario usuario);
    public Usuario findUsuarioByUsuario(Usuario usuario);
    public void guardarUsuario(Usuario usuario);
    public void updateUsuario(Usuario usuario);
    public void deleteUsuario(Usuario usuario);

}
