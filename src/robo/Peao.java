package robo;

public class Peao extends Robo {

	int limite = plano.listaCelulas.get(plano.listaCelulas.size() - 1).posicaoX;

	public Peao(int id, String nome, int posicaox, int posicaoy, Plano plano) {
		super(id, nome, posicaox, posicaoy, plano, 'P', 0);
	}

	public void avancar() {

		if (posicaox <= limite && posicaox > 1)
			posicaox++;

		for (int i = 0; i < plano.listaCelulas.size(); i++) {
			if (plano.listaCelulas.get(i).robo != null && plano.listaCelulas.get(i).robo.id == 2) {
				plano.listaCelulas.get(i).robo = null;
				plano.listaCelulas.get(i).imagem = '°';
			}

			if (plano.listaCelulas.get(i).posicaoX == posicaox && plano.listaCelulas.get(i).posicaoY == plano.listaCelulas.get(plano.listaCelulas.size() - 1).posicaoY) {
				super.posicaox = plano.listaCelulas.get(i).posicaoX;
				super.posicaoy = plano.listaCelulas.get(i).posicaoY;
				plano.listaCelulas.get(i).robo = this;
				plano.listaCelulas.get(i).imagem = 'P';
				
				super.verificarAlunoeBug(plano.listaCelulas.get(i), super.posicaox, super.posicaoy);
			}
		}

	}

	@Override
	public void retroceder() {
		if (posicaox <= limite && posicaox > 1)
			posicaox--;
		for (int i = 0; i < plano.listaCelulas.size(); i++) {
			if (plano.listaCelulas.get(i).robo != null && plano.listaCelulas.get(i).robo.id == 2) {
				plano.listaCelulas.get(i).robo = null;
				plano.listaCelulas.get(i).imagem = '°';
			}

			if (plano.listaCelulas.get(i).posicaoX == posicaox && plano.listaCelulas
					.get(i).posicaoY == plano.listaCelulas.get(plano.listaCelulas.size() - 1).posicaoY) {
				super.posicaox = plano.listaCelulas.get(i).posicaoX;
				super.posicaoy = plano.listaCelulas.get(i).posicaoY;
				plano.listaCelulas.get(i).robo = this;
				plano.listaCelulas.get(i).imagem = 'P';
				
				super.verificarAlunoeBug(plano.listaCelulas.get(i), super.posicaox, super.posicaoy);
			}
		}

	}
}
