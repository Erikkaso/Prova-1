package robo;

import java.util.Random;

public class Torre extends Robo {

	int limite = plano.listaCelulas.get(plano.listaCelulas.size() - 1).posicaoY;
	Random gerador = new Random();
	public Torre(int id, String nome, int posicaox, int posicaoy, Plano plano) {
		super(id, nome, posicaox, posicaoy, plano, 'T', 0);
	}

	public void avancar() {

		if (super.getPosicaoy() <= limite && super.getPosicaoy() > 1)
			super.setPosicaoy(super.getPosicaoy() - (gerador.nextInt(2)+1));

		if (super.getPosicaoy() > limite && super.getPosicaoy() > 1)
			super.setPosicaoy(limite);
		else if (super.getPosicaoy() < limite && super.getPosicaoy() < 1)
			super.setPosicaoy(1);

		super.movimentar(3,'T',super.getPosicaox(),super.getPosicaoy());
	}

	@Override
	public void retroceder() {

		if (super.getPosicaoy() <= limite && super.getPosicaoy() > 1)
			super.setPosicaoy(super.getPosicaoy() + (gerador.nextInt(2)+1));

		if (super.getPosicaoy() > limite && super.getPosicaoy() > 1)
			super.setPosicaoy(limite);
		else if (super.getPosicaoy() < limite && super.getPosicaoy() < 1)
			super.setPosicaoy(1);

		super.movimentar(3,'T',getPosicaox(),getPosicaoy());
	}

}
