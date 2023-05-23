package robo;

public abstract class Robo implements Movimento {

	public int id;
	public String nome;
	public int posicaox;
	public int posicaoy;
	public Plano plano;
	private char imagem;
	private int pontos;
	Celula aux;

	public Robo(int id, String nome, int posicaox, int posicaoy, Plano plano, char imagem, int pontos) {
		this.id = id;
		this.nome = nome;
		this.posicaox = posicaox;
		this.posicaoy = posicaoy;
		this.plano = plano;
		this.imagem = imagem;
		this.pontos = pontos;
		aux = null;
		for (int i = 0; i < plano.listaCelulas.size(); i++) {
			aux = plano.listaCelulas.get(i);
			if (aux.posicaoX == posicaox && aux.posicaoY == posicaoy) {
				plano.listaCelulas.get(i).robo = this;
				plano.listaCelulas.get(i).imagem = this.imagem;
			}
		}
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

	
	public void verificarAlunoeBug(Celula aux, int x, int y) {
		if (aux.aluno != null && aux.aluno.posicaox == x && aux.aluno.posicaoy == y) {
			this.setPontos(10);
			aux.aluno.imagem = '-';
			aux.aluno = null;
			plano.numeroAlunos--;
			System.out.println("UM ALUNO FOI ENCONTRADO!");
		}

		if (aux.bug != null && aux.bug.posicaox == x && aux.bug.posicaoy == y) {
			this.setPontos(-15);
			aux.bug.imagem = '-';
			aux.bug = null;
			System.out.println("UM ROBO FOI ATACADO!");
		}
	}

}
