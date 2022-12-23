package mx.com.gm.sga.servicio;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import mx.com.gm.sga.datos.UsuarioDao;
import mx.com.gm.sga.domain.Usuario;

@Stateless
public class UsuarioServiceImpl implements UsuarioService {

    @Inject
    UsuarioDao usuarioDao;
    
    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioDao.findAllUsuarios();
    }

    @Override
    public Usuario buscarPorId(Usuario usuario) {
        return usuarioDao.findUsuarioById(usuario);
    }

    @Override
    public Usuario buscarPorIdPersona(Usuario usuario) {
        return usuarioDao.findUsuarioByIdPersona(usuario);
    }

    @Override
    public Usuario buscarPorUsuario(Usuario usuario) {
        return usuarioDao.findUsuarioByUsuario(usuario);
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
        usuarioDao.guardarUsuario(usuario);
    }

    @Override
    public void editarUsuario(Usuario usuario) {
        usuarioDao.updateUsuario(usuario);
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
        usuarioDao.deleteUsuario(usuario);
    }

 }
