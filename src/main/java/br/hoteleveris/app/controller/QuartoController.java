package br.hoteleveris.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.hoteleveris.app.request.QuartoRequest;
import br.hoteleveris.app.request.SituacaoRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.QuartoResponse;
import br.hoteleveris.app.service.QuartoService;

@RestController
@RequestMapping("/quarto")
public class QuartoController extends BaseController {

	@Autowired
	private QuartoService _service;

	@PostMapping
	public ResponseEntity inserir(@RequestBody QuartoRequest request) {
		try {
			BaseResponse response = _service.inserir(request);
			return ResponseEntity.status(response.getStatusCode()).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Não foi possivel completar a requisição.");
		}
	}

	@GetMapping(path = "/{noQuarto}")
	public ResponseEntity obter(@PathVariable int noQuarto) {
		try {
			QuartoResponse response = _service.obter(noQuarto);
			return ResponseEntity.status(response.getStatusCode()).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.getStatusCode()).body(errorBase);
		}
	}

	@GetMapping(path = "/tipo/{tipoQuartoId}")
	public ResponseEntity<BaseResponse> obterPorTipo(@PathVariable Long tipoQuartoId) {
		try {
			BaseResponse response = _service.obterPorTipo(tipoQuartoId);
			return ResponseEntity.status(response.getStatusCode()).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.getStatusCode()).body(errorBase);
		}
	}

	@PatchMapping("/{id}")
	public ResponseEntity<BaseResponse> atualizar(@Validated @PathVariable("id") Long id,
			@RequestBody SituacaoRequest request) {
		try {
			BaseResponse response = _service.atualizar(id, request);
			return ResponseEntity.status(response.getStatusCode()).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.getStatusCode()).body(errorBase);
		}

	}

}