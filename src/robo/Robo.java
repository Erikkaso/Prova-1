package robo;

import java.util.ArrayList;

public abstract class Robo implements Movimento {

	private int id;
	private String nome;
	private int posicaox;
	private int posicaoy;
	public Plano plano;
	private char imagem;
	private int pontos;
	private int resgatouAluno;
	private int bugEncontrado;
	public ArrayList<Integer> posx;
	public ArrayList<Integer> posy;

	public Robo(int id, String nome, int posicaox, int posicaoy, Plano plano, char imagem, int pontos) {
		this.id = id;
		this.setNome(nome);
		this.posicaox = posicaox;
		this.posicaoy = posicaoy;
		this.plano = plano;
		this.imagem = imagem;
		this.pontos = pontos;
		this.resgatouAluno = 0;
		this.bugEncontrado = 0;

		posx = new ArrayList<Integer>();
		posx.add(posicaox);
		posy = new ArrayList<Integer>();
		posy.add(posicaoy);

		for (int i = 0; i < plano.listaCelulas.size(); i++) {
			Celula aux = plano.listaCelulas.get(i);
			if (aux.posicaoX == posicaox && aux.posicaoY == posicaoy) {
				plano.listaCelulas.get(i).robo = this;
				plano.listaCelulas.get(i).imagem = this.imagem;
			}
		}
	}

	public void movimentar(int id, char imagem, int x, int y) {
		for (int i = 0; i < plano.listaCelulas.size(); i++) {
			if (plano.listaCelulas.get(i).robo != null && plano.listaCelulas.get(i).robo.id == id) {
				plano.listaCelulas.get(i).robo = null;
				plano.listaCelulas.get(i).imagem = '°';
			}

			if (plano.listaCelulas.get(i).posicaoX == x && plano.listaCelulas.get(i).posicaoY == y) {
				posicaox = plano.listaCelulas.get(i).posicaoX;
				posicaoy = plano.listaCelulas.get(i).posicaoY;
				posx.add(posicaox);
				posy.add(posicaoy);

				plano.listaCelulas.get(i).robo = this;
				plano.listaCelulas.get(i).imagem = imagem;

				verificarAlunoeBug(plano.listaCelulas.get(i), posicaox, posicaoy);

			}
		}
	}

	public void verificarAlunoeBug(Celula aux, int x, int y) {
		if (aux.aluno != null && aux.aluno.posicaox == x && aux.aluno.posicaoy == y) {
			this.setPontos(10);
			aux.aluno.imagem = '-';
			aux.aluno = null;
			plano.numeroAlunos--;
			System.out.println("UM ALUNO FOI ENCONTRADO!");
			resgatouAluno++;
		}

		if (aux.bug != null && aux.bug.posicaox == x && aux.bug.posicaoy == y) {
			this.setPontos(-15);
			aux.bug.imagem = '-';
			aux.bug = null;
			this.plano.ataquesBugs++;
			System.out.println("UM ROBO FOI ATACADO!");
			bugEncontrado++;
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getBugEncontrado() {
		return bugEncontrado;
	}

	public void setBugEncontrado(int bugEncontrado) {
		this.bugEncontrado = bugEncontrado;
	}

	public int getResgatouAluno() {
		return resgatouAluno;
	}

	public void setResgatouAluno(int resgatouAluno) {
		this.resgatouAluno = resgatouAluno;
	}

	public char getImagem() {
		return imagem;
	}

	public void setImagem(char imagem) {
		this.imagem = imagem;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos += pontos;
	}

	public int getPosicaox() {
		return posicaox;
	}

	public void setPosicaox(int posicaox) {
		this.posicaox = posicaox;
	}

	public int getPosicaoy() {
		return posicaoy;
	}

	public void setPosicaoy(int posicaoy) {
		this.posicaoy = posicaoy;
	}

}
