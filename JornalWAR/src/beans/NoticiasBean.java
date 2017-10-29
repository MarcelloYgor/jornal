package beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import ejb.PegaNoticias;
import jornal.model.Noticia;

@ManagedBean(name = "PegaNoticias")
@SessionScoped
public class NoticiasBean {
	
	private List<Noticia> noticias;
	private Noticia noticia;
	
	@EJB
	private PegaNoticias pega = new PegaNoticias();
	
	public String altera(int id) {
		String retorno = "/altnoticia.xhtml";
		for (Noticia peganoticia : noticias) {
			if (peganoticia.getId() == id) {
				noticia = peganoticia;
			}
		}
		return retorno;
	}
	
	public String cancela() {
		String retorno = "/noticias.xhtml";
		return retorno;
	}
	
	public String salva() {
		String retorno = "/noticias.xhtml";
		pega.alteraNoticia(noticia);
		return retorno;
	}

	@PostConstruct
	public void init() {
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

	public Noticia getNoticia() {
		return noticia;
	}

	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}
}