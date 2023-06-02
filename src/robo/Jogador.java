package robo;

public class Jogador {
	private String nome;
	private boolean jogando;
	
	public Jogador(String nome) {
		this.nome = nome;
		this.jogando = true;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isJogando() {
		return jogando;
	}

	public void setJogando(boolean jogando) {
		this.jogando = jogando;
	}
	
	
}

