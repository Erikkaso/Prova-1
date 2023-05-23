package robo;

import java.util.Random;

public class Torre extends Robo {

	int limite = plano.listaCelulas.get(plano.listaCelulas.size() - 1).posicaoY;
	Random gerador = new Random();
	public Torre(int id, String nome, int posicaox, int posicaoy, Plano plano) {
		super(id, nome, posicaox, posicaoy, plano, 'T', 0);
	}

	public void avancar() {

		if (posicaoy <= limite && posicaoy > 1)
			posicaoy -= gerador.nextInt(2)+1;

		if (posicaoy > limite && posicaoy > 1)
			posicaoy = limite;
		else if (posicaoy < limite && posicaoy < 1)
			posicaoy = 1;

		for (int i = 0; i < plano.listaCelulas.size(); i++) {
			if (plano.listaCelulas.get(i).robo != null && plano.listaCelulas.get(i).robo.id == 3) {
				plano.listaCelulas.get(i).robo = null;
				plano.listaCelulas.get(i).imagem = '°';
			}

			if (plano.listaCelulas.get(i).posicaoX == posicaox && plano.listaCelulas.get(i).posicaoY == posicaoy) {
				super.posicaox = plano.listaCelulas.get(i).posicaoX;
				super.posicaoy = plano.listaCelulas.get(i).posicaoY;
				plano.listaCelulas.get(i).robo = this;
				plano.listaCelulas.get(i).imagem = 'T';
				
				super.verificarAlunoeBug(plano.listaCelulas.get(i), super.posicaox, super.posicaoy);
				
			}
		}
	}

	@Override
	public void retroceder() {

		if (posicaoy <= limite && posicaoy > 1)
			posicaoy += gerador.nextInt(2)+1;

		else if (posicaoy < limite && posicaoy < 1)
			posicaoy = 1;

		for (int i = 0; i < plano.listaCelulas.size(); i++) {
			if (plano.listaCelulas.get(i).robo != null && plano.listaCelulas.get(i).robo.id == 3) {
				plano.listaCelulas.get(i).robo = null;
				plano.listaCelulas.get(i).imagem = '°';
			}

			if (plano.listaCelulas.get(i).posicaoX == posicaox && plano.listaCelulas.get(i).posicaoY == posicaoy) {
				super.posicaox = plano.listaCelulas.get(i).posicaoX;
				super.posicaoy = plano.listaCelulas.get(i).posicaoY;
				plano.listaCelulas.get(i).robo = this;
				plano.listaCelulas.get(i).imagem = 'T';
				
				super.verificarAlunoeBug(plano.listaCelulas.get(i), super.posicaox, super.posicaoy);
			}
		}
	}

}
