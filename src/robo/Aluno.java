package robo;

import java.util.Random;

public class Aluno {

	public int id;
	public String tipo;;
	public int posicaox;
	public int posicaoy;
	public Plano plano;
	public char imagem;

	Random gerador = new Random();

	public Aluno(int id, String tipo, int posicaox, int posicaoy, Plano plano) {
		this.id = id;
		this.tipo = tipo;
		this.posicaox = gerador.nextInt(posicaox) + 1;
		while(this.posicaox <=7 && this.posicaoy==8) {this.posicaox = gerador.nextInt(posicaox) + 1;}
		this.posicaoy = gerador.nextInt(posicaoy) + 1;
		while(this.posicaox <=7 && this.posicaoy==8) {this.posicaoy = gerador.nextInt(posicaoy) + 1;}
		this.plano = plano;
		this.imagem = 'S';
		plano.numeroAlunos++;
		plano.numeroAlunosTotais++;

		Celula aux = null;
		for (int i = 0; i < plano.listaCelulas.size(); i++) {
			aux = plano.listaCelulas.get(i);
			if (aux.posicaoX == this.posicaox && aux.posicaoY == this.posicaoy) {
				plano.listaCelulas.get(i).aluno = this;
				plano.listaCelulas.get(i).imagem = this.imagem;
			}
		}
	}
}