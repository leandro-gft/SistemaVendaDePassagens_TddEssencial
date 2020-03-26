package br.com.gft.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.gft.sistemaviagens.model.Passageiro;
import br.com.gft.sistemaviagens.model.TipoPassageiro;
import br.com.gft.sistemaviagens.model.Voo;

public class PrecoPassagemServiceTest {
	private PrecoPassagemService precoPassagemService;
	
	@Before
	public void setup() {
		 precoPassagemService = new PrecoPassagemService();
	}

	private void assertValorPassagem(Passageiro passageiro, Voo voo, double esperado) {
		double valor = precoPassagemService.calcular(passageiro, voo);
		assertEquals(esperado, valor, 0.0001);
	}
	
	@Test
	public void deveCalcularValorPassagemParaPassageiroGoldComValorAbaixoDoLimite() {
		
		Passageiro passageiro = new Passageiro("Joao", TipoPassageiro.GOLD);
		Voo voo = new Voo("São Paulo", "Rio de Janeiro", 100.0);
		assertValorPassagem(passageiro, voo, 90.0);
		}

	
	@Test
	public void deveCalcularValorPassagemParaPassageiroGoldComValorAcimaDoLimite() {

		Passageiro passageiro = new Passageiro("Joao", TipoPassageiro.GOLD);
		Voo voo = new Voo("São Paulo", "Rio de Janeiro", 600.0);
		assertValorPassagem(passageiro, voo, 510.0);

		}
	
	@Test
	public void deveCalcularValorPassagemParaPassageiroDilverComValorAbaixoDoLimite() {
		
		Passageiro passageiro = new Passageiro("Joao", TipoPassageiro.SILVER);
		Voo voo = new Voo("São Paulo", "Rio de Janeiro", 100.0);
		assertValorPassagem(passageiro, voo, 94.0);

		}
	
	@Test
	public void deveCalcularValorPassagemParaPassageiroSilverComValorAcimaDoLimite() {

		Passageiro passageiro = new Passageiro("Joao", TipoPassageiro.SILVER);
		Voo voo = new Voo("São Paulo", "Rio de Janeiro", 800.0);
		assertValorPassagem(passageiro, voo, 720.0);

		}

}
