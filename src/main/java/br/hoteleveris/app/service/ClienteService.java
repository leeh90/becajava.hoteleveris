package br.hoteleveris.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.hoteleveris.app.model.Cliente;
import br.hoteleveris.app.repository.ClienteRepository;
import br.hoteleveris.app.request.ClienteRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.request.ClienteList;
import br.hoteleveris.app.response.ClienteResponse;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	public BaseResponse inserir(ClienteRequest request) {

		if (request.getNome().trim().equals("") || request.getNome().equals("string")) {// no swagger, por padrao, o
																						// "rótulo" dos campos fica com
																						// "string" escrito, então
																						// impedi que seja inserido no
																						// banco um cliente com dados
																						// escritos string
			return new BaseResponse(400, "O nome do cliente deve ser preenchido");
		}
		if (request.getCpf().trim().equals("") || request.getCpf().equals("string")) {// no swagger, por padrao, o
																						// "rótulo" dos campos fica com
																						// "string" escrito, então
																						// impedi que seja inserido no
																						// banco um cliente com dados
																						// escritos string
			return new BaseResponse(400, "O CPF do cliente deve ser preenchido");

		}
		if (request.getHash().trim().equals("") || request.getHash().equals("string")) {// no swagger, por padrao, o
																						// "rótulo" dos campos fica com
																						// "string" escrito, então
																						// impedi que seja inserido no
																						// banco um cliente com dados
																						// escritos string
			return new BaseResponse(400, "O hash do cliente deve ser preenchido");

		}
		Cliente cliente = new Cliente(request.getNome(), request.getCpf(), request.getHash());
		repository.save(cliente);
		return new BaseResponse(201, "Cliente inserido com sucesso.");

	}

	public ClienteResponse obter(Long id) {
		ClienteResponse response = new ClienteResponse();

		Optional<Cliente> cliente = repository.findById(id);

		if (repository.existsById(id) == false) {
			return new ClienteResponse(404, "Esse cliente não existe!");
		}

		response.setId(cliente.get().getId());
		response.setNome(cliente.get().getNome());
		response.setCpf(cliente.get().getCpf());
		response.setStatusCode(200);
		response.setMessage("Cliente obtido com sucesso!");

		return response;
	}

	public ClienteList listar() {
		List<Cliente> lista = repository.findAll();

		ClienteList response = new ClienteList();
		response.setClientes(lista);
		response.setStatusCode(200);
		response.setMessage("Clientes obtidos com sucesso.");

		return response;
	}

	public BaseResponse atualizar(Long id, ClienteRequest clienteRequest) {

		Cliente cliente = new Cliente();

		if (clienteRequest.getNome().trim().equals("") || clienteRequest.getNome().equals("string")) {
			return new BaseResponse(400, "O nome do cliente não foi preenchido.");
		}
		if (clienteRequest.getCpf().trim().equals("") || clienteRequest.getCpf().equals("string")) {
			return new BaseResponse(400, "O CPF do cliente não foi preenchido.");
		}
		if (clienteRequest.getHash().trim().equals("") || clienteRequest.getHash().equals("string")) {
			return new BaseResponse(400, "O Hash do cliente não foi preenchido.");
		}

		cliente.setId(id);
		cliente.setNome(clienteRequest.getNome());
		cliente.setCpf(clienteRequest.getCpf());
		cliente.setHash(clienteRequest.getHash());
		repository.save(cliente);
		return new BaseResponse(201, "Cliente atualizado com sucesso.");
	}

	public BaseResponse deletar(Long id) {
		BaseResponse response = new BaseResponse();

		if (repository.existsById(id) == false) {
			return new BaseResponse(400, "Cliente inválido!");
		}

		repository.deleteById(id);
		return new BaseResponse(201, "Cliente excluído!");
	}
}
