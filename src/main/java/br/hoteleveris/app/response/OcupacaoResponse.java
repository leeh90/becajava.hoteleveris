package br.hoteleveris.app.response;

import java.util.Date;


import br.hoteleveris.app.model.Cliente;
import br.hoteleveris.app.model.Quarto;

public class OcupacaoResponse extends BaseResponse{
	private Long id;
	private String data;
	private int qtdeDiarias;
	private String situacao;
	private Cliente cliente;
	private Quarto quarto;

	public OcupacaoResponse() {
	}

	public OcupacaoResponse(Long id, String data, int qtdeDiarias, String situacao, Cliente cliente, Quarto quarto) {
		super();
		this.id = id;
		this.data = data;
		this.qtdeDiarias = qtdeDiarias;
		this.situacao = situacao;
		this.cliente = cliente;
		this.quarto = quarto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getQtdeDiarias() {
		return qtdeDiarias;
	}

	public void setQtdeDiarias(int qtdeDiarias) {
		this.qtdeDiarias = qtdeDiarias;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}
}
