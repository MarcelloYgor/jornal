package beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ejb.ValidaUsuario;

@ManagedBean(name = "ValidaUsuario")
@ViewScoped
public class LoginBean {
	private String login;
	private String senha;
	
	@EJB
	private ValidaUsuario valida;
	
	public String logar() {
		String retorno = null;
		setSenha(valida.pegaUsuario(login));
		if (senha != null) {
			retorno = "/noticias";
		}
		return retorno;
	}

	public ValidaUsuario getValida() {
		return valida;
	}

	public void setValida(ValidaUsuario valida) {
		this.valida = valida;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
