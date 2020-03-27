package br.com.gft.service;

import br.com.gft.sistemaviagens.model.Voo;

public class PrecoPassagemSilver implements CalculadoraPrecoPassagem {

	public double calcular(Voo voo) {
		if (voo.getPreco() > 700)
			return voo.getPreco() * 0.90;
		return voo.getPreco() * 0.94;
	}

}
