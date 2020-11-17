package br.hoteleveris.app.request;

import java.util.List;

import br.hoteleveris.app.model.Ocupacao;
import br.hoteleveris.app.response.BaseResponse;

public class OcupacaoList extends BaseResponse{
	private List<Ocupacao> Ocupacoes;

    public List<Ocupacao> getOcupacoes() {
        return Ocupacoes;
    }

    public void setOcupacoes(List<Ocupacao> ocupacoes) {
    	Ocupacoes = ocupacoes;
    }
}
