package robo;

import java.util.Random;

public class Cavalo extends Robo {

	Random gerador = new Random();
	int aleatorio = gerador.nextInt(2) + 1;
	int limiteX = plano.listaCelulas.get(plano.listaCelulas.size() - 1).posicaoX;
	int limiteY = plano.listaCelulas.get(plano.listaCelulas.size() - 1).posicaoY;
	int auxX = posicaox;
	int auxY = posicaoy;

	public Cavalo(int id, String nome, int posicaox, int posicaoy, Plano plano) {
		super(id, nome, posicaox, posicaoy, plano, 'C', 0);
	}

	public void avancar() {

		if (auxX > 1 && auxY > 1) {
			auxX = super.posicaox - aleatorio;
			auxY = super.posicaoy - aleatorio;
		}

		super.movimentar(5,'C',auxX,auxY);
	}

	@Override
	public void retroceder() {
		if (auxX < limiteX && auxY < limiteY) {
			auxX = super.posicaox + aleatorio;
			auxY = super.posicaoy + aleatorio;
		}

		super.movimentar(5,'C',auxX,auxY);

	}
}
