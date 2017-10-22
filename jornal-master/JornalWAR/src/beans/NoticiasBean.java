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

	public PegaNoticias getPega() {
		return pega;
	}

	public void setPega(PegaNoticias pega) {
		this.pega = pega;
	}

	public List<Noticia> getNoticias() {
		return noticias;
	}

	public void setNoticias(List<Noticia> noticias) {
		this.noticias = noticias;
	}
}