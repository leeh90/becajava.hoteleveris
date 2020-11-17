package br.hoteleveris.app.request;

import java.util.List;

import br.hoteleveris.app.model.Quarto;
import br.hoteleveris.app.response.BaseResponse;

public class QuartoList extends BaseResponse{
	private List<Quarto> Quartos;

    public List<Quarto> getQuartos() {
        return Quartos;
    }

    public void setQuartos(List<Quarto> quartos) {
    	Quartos = quartos;
    }

}
