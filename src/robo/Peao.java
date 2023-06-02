package robo;

public class Peao extends Robo {

	int limite = plano.listaCelulas.get(plano.listaCelulas.size() - 1).posicaoX;

	public Peao(int id, String nome, int posicaox, int posicaoy, Plano plano) {
		super(id, nome, posicaox, posicaoy, plano, 'P', 0);
	}

	public void avancar() {

		if (super.getPosicaox() <= limite && getPosicaox() > 1)
			super.setPosicaox(getPosicaox()+1);

		super.movimentar(2,'P',getPosicaox(),getPosicaoy());

	}

	@Override
	public void retroceder() {
		if (getPosicaox() <= limite && getPosicaox() > 1)
			super.setPosicaox(getPosicaox()-1);
		super.movimentar(2,'P',getPosicaox(),getPosicaoy());

	}
}
