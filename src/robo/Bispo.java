package robo;

import java.util.Random;

public class Bispo extends Robo {

	Random gerador = new Random();
	int aleatorio = gerador.nextInt(2) + 1;
	int limiteX = plano.listaCelulas.get(plano.listaCelulas.size() - 1).posicaoX;
	int limiteY = plano.listaCelulas.get(plano.listaCelulas.size() - 1).posicaoY;
	int auxX = posicaox;
	int auxY = posicaoy;

	public Bispo(int id, String nome, int posicaox, int posicaoy, Plano plano) {
		super(id, nome, posicaox, posicaoy, plano, 'B', 0);
	}

	public void avancar() {

		if (auxX < limiteX && auxY > 1) {
			auxX = super.posicaox + aleatorio;
			auxY = super.posicaoy - aleatorio;
		}

		super.movimentar(4,'B',auxX,auxY);
	}

	@Override
	public void retroceder() {
		
		if (auxX > 1 && auxY < limiteY) {
			auxX = super.posicaox - aleatorio;
			auxY = super.posicaoy + aleatorio;
		}

		super.movimentar(4,'B',auxX,auxY);

	}
}
