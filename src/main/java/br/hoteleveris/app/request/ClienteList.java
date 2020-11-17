package br.hoteleveris.app.request;

import java.util.List;

import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.model.Cliente;

public class ClienteList extends BaseResponse {

    private List<Cliente> Clientes;
    
    
    public ClienteList() {
	}
    

	public ClienteList(int statusCode, String message) {
		super(statusCode, message);
		this.setMessage(message);
		this.setStatusCode(statusCode);
	}


	public ClienteList(List<Cliente> clientes) {
		super();
		Clientes = clientes;
	}

	public List<Cliente> getClientes() {
        return Clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        Clientes = clientes;
    }

}
