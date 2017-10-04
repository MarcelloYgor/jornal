package jornal.dao;

import jornal.model.Usuario;

public class Teste {
	
	public static void main(String [] args) {
		UsuarioDAO us = new UsuarioDAO();
		Usuario user = us.consultarUsuario("Marcello");
		System.out.println(user.getEmail());
	}
}