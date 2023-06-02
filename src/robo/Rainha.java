package robo;

import java.util.Random;

public class Rainha extends Robo {

	Random gerador = new Random();
	int aleatorio = gerador.nextInt(4) + 1;
	int limiteX = plano.listaCelulas.get(plano.listaCelulas.size() - 1).posicaoX;
	int limiteY = plano.listaCelulas.get(plano.listaCelulas.size() - 1).posicaoY;
	int auxX = getPosicaox();
	int auxY = getPosicaoy();

	public Rainha(int id, String nome, int posicaox, int posicaoy, Plano plano) {
		super(id, nome, posicaox, posicaoy, plano,'Q',0);
	}

	public void avancar() {

		if (super.getPosicaox() + aleatorio < limiteX && super.getPosicaoy() - aleatorio > 1) {
			auxX = super.getPosicaox() + aleatorio;
			auxY = super.getPosicaoy() - aleatorio;
		}

		super.movimentar(7,'Q',auxX,auxY);
	}

	@Override
	public void retroceder() {
		
		if (super.getPosicaox() - aleatorio > 1 && super.getPosicaoy() + aleatorio < limiteY) {
			auxX = super.getPosicaox() - aleatorio;
			auxY = super.getPosicaoy() + aleatorio;
		}

		super.movimentar(7,'Q',auxX,auxY);

	}
}
