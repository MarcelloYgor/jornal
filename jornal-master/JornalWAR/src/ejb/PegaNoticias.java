package ejb;

import java.util.List;

import javax.ejb.Stateless;

import jornal.dao.NoticiaDAO;
import jornal.model.Noticia;

@Stateless
public class PegaNoticias {
	
	private NoticiaDAO ntcDAO = new NoticiaDAO();
	private List<Noticia> noticias;
	
	public List<Noticia> pegaNoticias() {
		noticias = ntcDAO.pegarNoticias();
		return noticias;
	}
}
