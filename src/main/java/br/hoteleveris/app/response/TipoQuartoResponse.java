package br.hoteleveris.app.response;

public class TipoQuartoResponse extends BaseResponse{
	private Long id;
	private String descricao;
	private Double valor;
	
	public TipoQuartoResponse() {
	}
	public TipoQuartoResponse(int statusCode, String message) {
		super(statusCode, message);
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
}
