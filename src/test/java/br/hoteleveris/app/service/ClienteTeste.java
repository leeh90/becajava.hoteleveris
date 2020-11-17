package br.hoteleveris.app.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.hoteleveris.app.model.Cliente;
import br.hoteleveris.app.request.ClienteList;
import br.hoteleveris.app.request.ClienteRequest;
import br.hoteleveris.app.response.BaseResponse;

@SpringBootTest
public class ClienteTeste {

	@Autowired
	private ClienteService service;

	@Test
	void inserir() {
		Cliente cliente = new Cliente();
		ClienteRequest request = new ClienteRequest();
		request.setNome("Isa");
		request.setCpf("123456789");
		request.setHash(cliente.getHash());

		BaseResponse response = service.inserir(request);

		Assertions.assertEquals(201, response.getStatusCode());
		Assertions.assertEquals("Cliente inserido com sucesso.", response.getMessage());
	}

	@Test
	void inserirNomeVazio() {
		Cliente cliente = new Cliente();
		ClienteRequest request = new ClienteRequest();
		request.setNome("");
		request.setCpf("123456789");
		request.setHash(cliente.getHash());

		BaseResponse response = service.inserir(request);

		Assertions.assertEquals(400, response.getStatusCode());
		Assertions.assertEquals("O nome do cliente deve ser preenchido", response.getMessage());
	}

	@Test
	void inserirNomeString() {
		Cliente cliente = new Cliente();
		ClienteRequest request = new ClienteRequest();
		request.setNome("string");
		request.setCpf("123456789");
		request.setHash(cliente.getHash());

		BaseResponse response = service.inserir(request);

		Assertions.assertEquals(400, response.getStatusCode());
		Assertions.assertEquals("O nome do cliente deve ser preenchido", response.getMessage());
	}

	@Test
	void obterPorId() {
		BaseResponse response = service.obter(new Long(1));
		Assertions.assertEquals(200, response.getStatusCode());
		Assertions.assertEquals("Cliente obtido com sucesso!", response.getMessage());
	}

	@Test
	void obterPorIdNull() {
		BaseResponse response = service.obter(new Long(0));
		Assertions.assertEquals(404, response.getStatusCode());
		Assertions.assertEquals("Esse cliente não existe!", response.getMessage());
	}

	@Test
	public void pegaLista() {
		ClienteList obj = new ClienteList();
		obj.setClientes(obj.getClientes());

		BaseResponse response = service.listar();
		Assertions.assertEquals(200, response.getStatusCode());
	}

}
