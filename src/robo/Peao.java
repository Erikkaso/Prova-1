package robo;

public class Peao extends Robo {

	int limite = plano.listaCelulas.get(plano.listaCelulas.size() - 1).posicaoX;

	public Peao(int id, String nome, int posicaox, int posicaoy, Plano plano) {
		super(id, nome, posicaox, posicaoy, plano, 'P', 0);
	}

	public void avancar() {

		if (super.posicaox <= limite && posicaox > 1)
			posicaox++;

		super.movimentar(2,'P',posicaox,posicaoy);

	}

	@Override
	public void retroceder() {
		if (posicaox <= limite && posicaox > 1)
			posicaox--;
		super.movimentar(2,'P',posicaox,posicaoy);

	}
}
