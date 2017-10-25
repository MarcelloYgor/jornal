package ejb;

import javax.ejb.Stateless;

import jornal.dao.UsuarioDAO;
import jornal.model.Usuario;

@Stateless
public class ValidaUsuario {
	
	private UsuarioDAO user = new UsuarioDAO();
	
	public String pegaUsuario(String login) {
		Usuario usuario = null;
		String senha = null;
		usuario = user.consultarUsuario(login);
		if (usuario != null) {
			senha = usuario.getPassword();
		}
		System.out.println("passou" + senha);
		return senha;
	}
	
	public void cadastraUsuario() {
		
	}
}
