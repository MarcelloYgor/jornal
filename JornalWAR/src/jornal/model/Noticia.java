package jornal.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Noticia {
	
	@Id
	private int id;
	
	private String tipo;
	private String jornalista;
	private String titulo;
	private String descricao;
	private Date datacriacao;
	private String aprovadorId;
	private Date aprovadordata;
	private int assinantes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getJornalista() {
		return jornalista;
	}

	public void setJornalista(String jornalista) {
		this.jornalista = jornalista;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDatacriacao() {
		return datacriacao;
	}

	public void setDatacriacao(Date datacriacao) {
		this.datacriacao = datacriacao;
	}

	public String getAprovadorId() {
		return aprovadorId;
	}

	public void setAprovadorId(String aprovadorId) {
		this.aprovadorId = aprovadorId;
	}

	public Date getAprovadordata() {
		return aprovadordata;
	}

	public void setAprovadordata(Date aprovadordata) {
		this.aprovadordata = aprovadordata;
	}

	public int getAssinantes() {
		return assinantes;
	}

	public void setAssinantes(int assinantes) {
		this.assinantes = assinantes;
	}
}
