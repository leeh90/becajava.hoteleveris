package br.hoteleveris.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Quarto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int andar;
	@Column(unique = true)
	private int noQuarto;
	private String situacao;

	public Quarto() {
	}

	public Quarto(Long id) {
		super();
		this.id = id;
	}

	public Quarto(int andar, int noQuarto, String situacao, TipoQuarto tipoQuarto) {
		this.andar = andar;
		this.noQuarto = noQuarto;
		this.situacao = situacao;
		this.tipoQuarto = tipoQuarto;
	}

	@ManyToOne
	@JoinColumn(name = "tipoQuartoId")
	private TipoQuarto tipoQuarto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAndar() {
		return andar;
	}

	public void setAndar(int andar) {
		this.andar = andar;
	}

	public int getNoQuarto() {
		return noQuarto;
	}

	public void setNoQuarto(int noQuarto) {
		this.noQuarto = noQuarto;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public TipoQuarto getTipoQuarto() {
		return tipoQuarto;
	}

	public void setTipoQuarto(TipoQuarto tipoQuarto) {
		this.tipoQuarto = tipoQuarto;
	}

}
