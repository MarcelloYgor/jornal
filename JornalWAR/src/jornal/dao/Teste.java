package jornal.dao;

import javax.swing.JOptionPane;

import jornal.model.Noticia;
import jornal.model.Usuario;

public class Teste {
	
	public static void main(String [] args) {
		Teste teste = new Teste();
		int opc = 0;
		while (opc != 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("1 - Usuario \n"
					+ "2 - Noticia"));
			switch (opc) {
				case 1:
					while (opc != 0 && opc != 9) {
						opc = Integer.parseInt(JOptionPane.showInputDialog(
							"Usuario \n"
							+ "\n"
							+ "1 - Cadastrar \n" + "2 - Consultar \n" + "3 - Excluir \n" + "4 - Atualizar"));
						switch (opc) {
							case 1:
								teste.testeAdicionarUsuario();
								break;
							case 2:
								teste.testeConsultarUsuario();
								System.out.println("entrou");
								break;
							case 3:
								teste.testeExcluirUsuario();
								break;
							case 4:
								teste.testeAtualizarUsuario();
								break;
							default:
						}
					}
					break;
				case 2:
					while (opc != 0 && opc != 9) {
						opc = Integer.parseInt(JOptionPane.showInputDialog("Not�cia \n"
								+ "\n"
								+ "1 - Cadastrar \n"
								+ "2 - Consultar \n"
								+ "3 - Excluir \n"
								+ "4 - Atualizar"));
						switch (opc) {
							case 1:
								teste.testeAdicionarNoticia();
								break;
							case 2:
								teste.testeConsultarNoticia();
								break;
							case 3:
								teste.testeExcluirNoticia();
								break;
							case 4:
								teste.testeAtualizarNoticia();
								break;
							default:
						}
					}
					break;
				default:
			}
		}
	}
	
	public void testeAdicionarUsuario() {
		UsuarioDAO us = new UsuarioDAO();
		us.cadastrarUsuario();
	}
	
	public void testeConsultarUsuario() {
		UsuarioDAO us = new UsuarioDAO();
		Usuario user = us.consultarUsuario("marcellosilva");
		System.out.println(user.getEmail());
		System.out.println(user.getTelefone());
	}
	
	public void testeExcluirUsuario() {
		UsuarioDAO us = new UsuarioDAO();
		us.excluirUsuario("Marcello");
	}
	
	public void testeAtualizarUsuario() {
		UsuarioDAO us = new UsuarioDAO();
		String upt = "11988888888";
		String nome = "Marcello";
		us.alterarUsuario(upt, nome);
	}
	
	public void testeAdicionarNoticia() {
		NoticiaDAO not = new NoticiaDAO();
		not.cadastrarNoticia();
	}
	
	public void testeConsultarNoticia() {
		NoticiaDAO not = new NoticiaDAO();
		Noticia noticia = not.consultarNoticia("Neymar faz gol");
		System.out.println(noticia.getDescricao());
		System.out.println(noticia.getTipo());
		System.out.println(noticia.getDatacriacao());
	}
	
	public void testeExcluirNoticia() {
		
	}
	
	public void testeAtualizarNoticia() {
		
	}
}