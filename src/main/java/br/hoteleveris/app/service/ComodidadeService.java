package br.hoteleveris.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.hoteleveris.app.model.Cliente;
import br.hoteleveris.app.model.Comodidade;
import br.hoteleveris.app.repository.ComodidadeRepository;
import br.hoteleveris.app.request.ComodidadeList;
import br.hoteleveris.app.request.ComodidadeRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.ComodidadeResponse;

@Service
public class ComodidadeService extends BaseResponse {
	@Autowired
	ComodidadeRepository _repository;

	public BaseResponse inserir(ComodidadeRequest comodidadeRequest) { 
  
	if(comodidadeRequest.getNome().trim() == "")   
		return new BaseResponse (400, "O nome da comodidade deve ser preenchido");	
	
	if(comodidadeRequest.getNome().equals("string"))//no swagger, por padrao, o  "rótulo" dos campos fica com "string" escrito, então impedi que seja inserido no banco um comodidade com dados escritos string
		return new BaseResponse (400, "O nome da comodidade deve ser preenchido");	
	
	Comodidade comodidade = new Comodidade(comodidadeRequest.getNome());
	_repository.save(comodidade);
	return new BaseResponse(200, "Comodidade inserida com sucesso.");
	
}

	public ComodidadeResponse obter(Long id) {
		Optional<Comodidade> comodidade = _repository.findById(id);
		ComodidadeResponse response = new ComodidadeResponse();

		if (id <= 0) {
			response.setMessage("ID inválido");
			response.setStatusCode(404);
			return response;
		}

		response.setNome(comodidade.get().getNome());
		response.setMessage("Comodidade obtido com sucesso");
		response.setStatusCode(200);
		return response;
	}

	public ComodidadeList listar() {
		List<Comodidade> lista = _repository.findAll();

		ComodidadeList response = new ComodidadeList();
		response.setComodidades(lista);
		response.setStatusCode(200);
		response.setMessage("Comodidades obtidos com sucesso.");

		return response;
	}

}
