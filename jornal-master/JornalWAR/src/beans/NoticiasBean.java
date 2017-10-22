package beans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import ejb.PegaNoticias;
import jornal.model.Noticia;

@ApplicationScoped
@ManagedBean(name = "PegaNoticias")
public class NoticiasBean {
	
	private List<Noticia> noticias;
	
	@EJB
	private PegaNoticias pega = new PegaNoticias();
	
	public NoticiasBean() {
		noticias = pega.pegaNoticias();
	}
	
	public void inserirNoticia() {
		
	}
	
	public void alterarNoticia() {
		
	}
	
	public void excluirNoticia() {
		
	}

	public List<Noticia> getNoticias() {
		return noticias;
	}

	public void setNoticias(List<Noticia> noticias) {
		this.noticias = noticias;
	}
}