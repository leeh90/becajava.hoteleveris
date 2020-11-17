package br.hoteleveris.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.hoteleveris.app.model.TipoQuarto;
import br.hoteleveris.app.repository.TipoQuartoRepository;
import br.hoteleveris.app.request.TipoQuartoList;
import br.hoteleveris.app.request.TipoQuartoRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.TipoQuartoResponse;

@Service
public class TipoQuartoService extends BaseResponse {

	@Autowired
	private TipoQuartoRepository repository;

	public BaseResponse inserir(TipoQuartoRequest request) {

		if (request.getDescricao().trim().equals("") || request.getDescricao().equals("string")) {
			return new BaseResponse(400, "O nome do cliente deve ser preenchido");
		}
		if (request.getValor() == null || request.getValor().equals("")) {
			return new BaseResponse(400, "O valor do quarto deve ser preenchido");
		}
		TipoQuarto tipoQuarto = new TipoQuarto(request.getDescricao(), request.getValor());
		repository.save(tipoQuarto);
		return new BaseResponse(201, "Tipo de quarto inserido com sucesso.");

	}
	
	public TipoQuartoResponse obter(Long id) {
		TipoQuartoResponse response = new TipoQuartoResponse();

		Optional<TipoQuarto> tipoQuarto = repository.findById(id);

		if (repository.existsById(id) == false) {
			return new TipoQuartoResponse(404, "Esse tipo de quarto não existe!");
		}
		response.setId(tipoQuarto.get().getId());
		response.setDescricao(tipoQuarto.get().getDescricao());
		response.setValor(tipoQuarto.get().getValor());
		response.setStatusCode(200);
		response.setMessage("Tipo de quarto obtido com sucesso!");

		return response;
	}

	public TipoQuartoList listar() {
		List<TipoQuarto> lista = repository.findAll();

		TipoQuartoList response = new TipoQuartoList();
		response.setTipoQuartos(lista);
		response.setStatusCode(200);
		response.setMessage("Tipo Quarto obtidos com sucesso.");

		return response;
	}
 

}
