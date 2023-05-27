package robo;

import java.util.Random;

public class Torre extends Robo {

	int limite = plano.listaCelulas.get(plano.listaCelulas.size() - 1).posicaoY;
	Random gerador = new Random();
	public Torre(int id, String nome, int posicaox, int posicaoy, Plano plano) {
		super(id, nome, posicaox, posicaoy, plano, 'T', 0);
	}

	public void avancar() {

		if (super.posicaoy <= limite && super.posicaoy > 1)
			super.posicaoy -= gerador.nextInt(2)+1;

		if (super.posicaoy > limite && super.posicaoy > 1)
			super.posicaoy = limite;
		else if (super.posicaoy < limite && super.posicaoy < 1)
			super.posicaoy = 1;

		super.movimentar(3,'T',super.posicaox,super.posicaoy);
	}

	@Override
	public void retroceder() {

		if (super.posicaoy <= limite && super.posicaoy > 1)
			posicaoy += gerador.nextInt(2)+1;

		if (super.posicaoy > limite && super.posicaoy > 1)
			super.posicaoy = limite;
		else if (super.posicaoy < limite && super.posicaoy < 1)
			posicaoy = 1;

		super.movimentar(3,'T',posicaox,posicaoy);
	}

}
