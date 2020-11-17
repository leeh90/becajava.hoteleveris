package br.hoteleveris.app.controller;

import br.hoteleveris.app.response.BaseResponse;

public class BaseController{
	public BaseResponse errorBase = new BaseResponse();
	
	public BaseController() {
		errorBase.setStatusCode(500);
		errorBase.setMessage("Ocorreu um erro inesperado. Contate o administrador");
	}
}
