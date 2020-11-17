package br.hoteleveris.app.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.hoteleveris.app.model.Ocupacao;
import br.hoteleveris.app.model.Quarto;
import br.hoteleveris.app.request.OcupacaoRequest;
import br.hoteleveris.app.response.BaseResponse;

@SpringBootTest
public class OcupacaoTeste {

	@Autowired
	private OcupacaoService service;

	@Test
	void inserir() {
		//Quarto quarto = new Quarto();
		Ocupacao ocupacao = new Ocupacao();
		OcupacaoRequest request = new OcupacaoRequest();
		request.setData("17/11/2020");
		request.setQtdeDiarias(2);
		request.setSituacao("N");
		//request.setQuarto(Qu);
		//request.setClienteId(null);
		
		BaseResponse response = service.inserir(request);

		Assertions.assertEquals(201, response.getStatusCode());
		Assertions.assertEquals("Nova ocupação salva com sucesso!", response.getMessage());
	}

}
