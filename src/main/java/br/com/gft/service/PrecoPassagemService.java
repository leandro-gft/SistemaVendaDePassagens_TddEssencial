package br.com.gft.service;

import br.com.gft.sistemaviagens.model.Passageiro;
import br.com.gft.sistemaviagens.model.TipoPassageiro;
import br.com.gft.sistemaviagens.model.Voo;

public class PrecoPassagemService {

	public double calcular(Passageiro passageiro, Voo voo) {
		return passageiro.getTipo().getCalculadora().calcular(voo);
	}

}
