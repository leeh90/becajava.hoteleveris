package br.hoteleveris.app.request;

import java.util.List;

import br.hoteleveris.app.model.Comodidade;
import br.hoteleveris.app.response.BaseResponse;

public class ComodidadeList extends BaseResponse{
	private List<Comodidade> Comodidades;

    public List<Comodidade> getComodidades() {
        return Comodidades;
    }

    public void setComodidades(List<Comodidade> comodidades) {
    	Comodidades = comodidades;
    }
}
