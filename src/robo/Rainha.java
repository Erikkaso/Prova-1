package robo;

import java.util.Random;

public class Rainha extends Robo {

	Random gerador = new Random();
	int aleatorio = gerador.nextInt(4) + 1;
	int limiteX = plano.listaCelulas.get(plano.listaCelulas.size() - 1).posicaoX;
	int limiteY = plano.listaCelulas.get(plano.listaCelulas.size() - 1).posicaoY;
	int auxX = posicaox;
	int auxY = posicaoy;

	public Rainha(int id, String nome, int posicaox, int posicaoy, Plano plano) {
		super(id, nome, posicaox, posicaoy, plano,'Q',0);
	}

	public void avancar() {

		if (super.posicaox + aleatorio < limiteX && super.posicaoy - aleatorio > 1) {
			auxX = super.posicaox + aleatorio;
			auxY = super.posicaoy - aleatorio;
		}

		super.movimentar(7,'Q',auxX,auxY);
	}

	@Override
	public void retroceder() {
		
		if (super.posicaox - aleatorio > 1 && super.posicaoy + aleatorio < limiteY) {
			auxX = super.posicaox - aleatorio;
			auxY = super.posicaoy + aleatorio;
		}

		super.movimentar(7,'Q',auxX,auxY);

	}
}
