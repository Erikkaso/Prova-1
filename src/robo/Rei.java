package robo;

import java.util.Random;

public class Rei extends Robo {

	Random gerador = new Random();
	int aleatorio = gerador.nextInt(4) + 1;
	int limiteX = plano.listaCelulas.get(plano.listaCelulas.size() - 1).posicaoX;
	int limiteY = plano.listaCelulas.get(plano.listaCelulas.size() - 1).posicaoY;
	int auxX = posicaox;
	int auxY = posicaoy;

	public Rei(int id, String nome, int posicaox, int posicaoy, Plano plano) {
		super(id, nome, posicaox, posicaoy, plano, 'K', 0);
	}

	public void avancar() {

		if (super.posicaox - aleatorio > 1 && super.posicaoy - aleatorio > 1) {
			auxX = super.posicaox - aleatorio;
			auxY = super.posicaoy - aleatorio;
		}

		for (int i = 0; i < plano.listaCelulas.size(); i++) {

			if (plano.listaCelulas.get(i).robo != null && plano.listaCelulas.get(i).robo.id == 6) {
				plano.listaCelulas.get(i).robo = null;
				plano.listaCelulas.get(i).imagem = '°';
			}

			if (plano.listaCelulas.get(i).posicaoY == auxY && plano.listaCelulas.get(i).posicaoX == auxX) {
				super.posicaox = plano.listaCelulas.get(i).posicaoX;
				super.posicaoy = plano.listaCelulas.get(i).posicaoY;
				plano.listaCelulas.get(i).robo = this;
				plano.listaCelulas.get(i).imagem = 'K';
				
				super.verificarAlunoeBug(plano.listaCelulas.get(i), super.posicaox, super.posicaoy);

			}
		}
	}

	@Override
	public void retroceder() {
		if (super.posicaox + aleatorio < limiteX && super.posicaoy + aleatorio < limiteY) {
			auxX = super.posicaox + aleatorio;
			auxY = super.posicaoy + aleatorio;
		}

		for (int i = 0; i < plano.listaCelulas.size(); i++) {

			if (plano.listaCelulas.get(i).robo != null && plano.listaCelulas.get(i).robo.id == 6) {
				plano.listaCelulas.get(i).robo = null;
				plano.listaCelulas.get(i).imagem = '°';
			}

			if (plano.listaCelulas.get(i).posicaoY == auxY && plano.listaCelulas.get(i).posicaoX == auxX) {
				super.posicaox = plano.listaCelulas.get(i).posicaoX;
				super.posicaoy = plano.listaCelulas.get(i).posicaoY;
				plano.listaCelulas.get(i).robo = this;
				plano.listaCelulas.get(i).imagem = 'K';
				
				super.verificarAlunoeBug(plano.listaCelulas.get(i), super.posicaox, super.posicaoy);

			}
		}

	}
}
