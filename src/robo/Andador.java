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

		for (int i = 0; i < plano.listaCelulas.size(); i++) {
			if (plano.listaCelulas.get(i).robo != null && plano.listaCelulas.get(i).robo.id == 1) {
				plano.listaCelulas.get(i).robo = null;
				plano.listaCelulas.get(i).imagem = '°';
			}

			if (plano.listaCelulas.get(i).posicaoY == aleatorio && plano.listaCelulas.get(i).posicaoX == 1) {
				super.posicaox = plano.listaCelulas.get(i).posicaoX;
				super.posicaoy = plano.listaCelulas.get(i).posicaoY;
				plano.listaCelulas.get(i).robo = this;
				plano.listaCelulas.get(i).imagem = 'A';
				
				super.verificarAlunoeBug(plano.listaCelulas.get(i), super.posicaox, super.posicaoy);
			}
		}

	}

	@Override
	public void retroceder() {
		aleatorio = gerador.nextInt(plano.listaCelulas.get(plano.listaCelulas.size() - 1).posicaoY) + 1;

		while (aleatorio < super.posicaoy) {
			aleatorio = gerador.nextInt(plano.listaCelulas.get(plano.listaCelulas.size() - 1).posicaoY) + 1;
		}

		for (int i = 0; i < plano.listaCelulas.size(); i++) {
			if (plano.listaCelulas.get(i).robo != null && plano.listaCelulas.get(i).robo.id == 1) {
				plano.listaCelulas.get(i).robo = null;
				plano.listaCelulas.get(i).imagem = '°';
			}

			if (plano.listaCelulas.get(i).posicaoY == aleatorio && plano.listaCelulas.get(i).posicaoX == 1) {
				super.posicaox = plano.listaCelulas.get(i).posicaoX;
				super.posicaoy = plano.listaCelulas.get(i).posicaoY;
				plano.listaCelulas.get(i).robo = this;
				plano.listaCelulas.get(i).imagem = 'A';
				
				super.verificarAlunoeBug(plano.listaCelulas.get(i), super.posicaox, super.posicaoy);
			}
		}
	}
	
}
