package br.hoteleveris.app.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.hoteleveris.app.response.BaseResponse;

@SpringBootTest
public class FaturaTeste {

	@Autowired
	private FaturaService service;
	
	/*
	 * @Test public void inserirTransferencia() { BaseResponse response = new
	 * BaseResponse(); service.inserir();
	 * Assertions.assertEquals(200,response.getStatusCode()); }
	 */
}
