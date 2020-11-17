package br.hoteleveris.app.request;

import java.util.UUID;

public class ClienteRequest {
	private String nome;
	private String cpf;
	private String hash;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getHash() {
		hash = UUID.randomUUID().toString().substring(0, 16);
		return hash.replace("-", "");
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
}
