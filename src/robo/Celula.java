package robo;

public class Celula {

	public int posicaoX;
	public int posicaoY;
	public int id;
	public char imagem;
	public Robo robo;	
	public Aluno aluno;
	public Bug bug;
	
	public Celula(int id, int y , int x) {
		posicaoX = x;
		posicaoY = y;
		this.id = id;
		robo =null;
		aluno = null;
		imagem = '-';
		bug = null;
	}
	
	public String imprimir() {
		return "Celula:  " + id + " x: " + posicaoX + " y: " + posicaoY;
	}
}

