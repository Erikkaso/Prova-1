package robo;

import java.util.Random;

public class Andador extends Robo {
	Random gerador = new Random();
	int aleatorio = 0;

	public Andador(int id, String nome, int posicaox, int posicaoy, Plano plano) {
		super(id, nome, posicaox, posicaoy, plano, 'A', 0);
	}

	public void avancar() {

		aleatorio = gerador.nextInt(plano.listaCelulas.get(plano.listaCelulas.size() - 1).posicaoY) + 1;

		while (aleatorio >= super.posicaoy) {
			aleatorio = gerador.nextInt(plano.listaCelulas.get(plano.listaCelulas.size() - 1).posicaoY) + 1;
		}

		super.movimentar(1,'A',1,aleatorio);

	}

	@Override
	public void retroceder() {
		aleatorio = gerador.nextInt(plano.listaCelulas.get(plano.listaCelulas.size() - 1).posicaoY) + 1;

		while (aleatorio < super.posicaoy) {
			aleatorio = gerador.nextInt(plano.listaCelulas.get(plano.listaCelulas.size() - 1).posicaoY) + 1;
		}

		super.movimentar(1,'A',1,aleatorio);
	}
	
}
