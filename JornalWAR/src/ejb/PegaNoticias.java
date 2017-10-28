package ejb;

import java.util.List;

import javax.ejb.Stateless;

import jornal.dao.NoticiaDAO;
import jornal.model.Noticia;

@Stateless
public class PegaNoticias {
	
	private NoticiaDAO ntcDAO = new NoticiaDAO();
	
	public List<Noticia> pegaNoticias() {
		List<Noticia> noticias;
		noticias = ntcDAO.pegarNoticias();
		return noticias;
	}
	
	public void insereNoticia() {
		
	}
	
	public Noticia alteraNoticia(int id) {
		Noticia noticia = ntcDAO.consultarNoticia(id);
		System.out.println(id);
		System.out.println("alterou");
		return noticia;
	}
	
	public void excluiNoticia(String titulo) {
		System.out.println(titulo);
	}
}
