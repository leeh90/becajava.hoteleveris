package br.hoteleveris.app.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.hoteleveris.app.request.ComodidadeRequest;
import br.hoteleveris.app.request.ComodidadeRequestQ;
import br.hoteleveris.app.request.OcupacaoList;
import br.hoteleveris.app.response.BaseResponse;

@SpringBootTest
public class ComodidadeTeste {

	@Autowired
	private ComodidadeService service;

	@Test
	void inserir() {
		ComodidadeRequest request = new ComodidadeRequest();
		request.setNome("Piscina");

		BaseResponse response = service.inserir(request);

		Assertions.assertEquals(200, response.getStatusCode());
		Assertions.assertEquals("Comodidade inserida com sucesso.", response.getMessage());
	}

	@Test
	void inserirSemNome() {
		ComodidadeRequest request = new ComodidadeRequest();
		request.setNome("");

		BaseResponse response = service.inserir(request);

		Assertions.assertEquals(400, response.getStatusCode());
		Assertions.assertEquals("O nome da comodidade deve ser preenchido", response.getMessage());
	}

	@Test
	void inserirNomeString() {
		ComodidadeRequest request = new ComodidadeRequest();
		request.setNome("string");

		BaseResponse response = service.inserir(request);

		Assertions.assertEquals(400, response.getStatusCode());
		Assertions.assertEquals("O nome da comodidade deve ser preenchido", response.getMessage());
	}

	@Test
	void obterPorId() {
		BaseResponse response = service.obter(new Long(1));
		Assertions.assertEquals(200, response.getStatusCode());
	}

	@Test
	void obterPorIdNull() {
		BaseResponse response = service.obter(new Long(0));
		Assertions.assertEquals(404, response.getStatusCode());
		Assertions.assertEquals("ID inválido", response.getMessage());
	}

	@Test
	public void pegaLista() {
		OcupacaoList obj = new OcupacaoList();
		obj.setOcupacoes(obj.getOcupacoes());

		BaseResponse response = service.listar();
		Assertions.assertEquals(200, response.getStatusCode());
	}

}
