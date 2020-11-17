package br.hoteleveris.app.response;

import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.hoteleveris.app.model.Quarto;
import br.hoteleveris.app.model.TipoQuarto;

public class QuartoResponse extends BaseResponse{
	private Long id;
	private int andar;
	private int noQuarto;
	private String situacao;
	private TipoQuarto tipoQuarto;

	
	
	public QuartoResponse(int statusCode, String message) {
		super();
		setStatusCode(statusCode);
		setMessage(message);
	}

	public QuartoResponse(int andar, int noQuarto, String situacao, TipoQuarto tipoQuarto) {
		super();
		this.andar = andar;
		this.noQuarto = noQuarto;
		this.situacao = situacao;
		this.tipoQuarto = tipoQuarto;
	}

	public QuartoResponse() {
	}
	
	

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
