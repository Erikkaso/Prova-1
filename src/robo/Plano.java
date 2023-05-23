package robo;

import java.util.ArrayList;

public class Plano {

	public ArrayList<Celula> listaCelulas;
	public int numeroAlunos;
	public int numeroAlunosTotais;
	
	public Plano(int tamanhoX, int tamanhoY) {
		listaCelulas = new ArrayList<Celula>();

		int contador = 1;
		for (int i = 1; i <= tamanhoY; i++) {
			for (int j = 1; j <= tamanhoX; j++) {
				Celula celula = new Celula(contador, i, j);// id;x;y
				listaCelulas.add(celula);
				contador++;
			}
		}
	}

	public void verificarSeTemRobo() {
		for (int i = 0; i < listaCelulas.size(); i++) {
			// Celula aux = listaCelulas.get(i);
			if (listaCelulas.get(i).robo != null) {
				System.out.println("tem robo" + listaCelulas.get(i).robo.nome + "  - x: " + listaCelulas.get(i).posicaoX
						+ "  - y: " + listaCelulas.get(i).posicaoY);
			}
		}
	}

	public Celula retornarCelula(int x, int y) {

		for (int i = 0; i < listaCelulas.size(); i++) {
			if (listaCelulas.get(i).posicaoX == x && listaCelulas.get(i).posicaoY == y) {
				return listaCelulas.get(i);
			}
		}
		return null;
	}

	public void retornarCelulas() {
		for (int i = 0; i < listaCelulas.size(); i++) {
			System.out.println(listaCelulas.get(i).imprimir());
		}
	}

	public void criarGrade() {
		int tamanho = listaCelulas.size()-1;
		int xMax = listaCelulas.get(tamanho).posicaoX;
		
		for (Celula celula : listaCelulas) {
			System.out.print(" "+celula.imagem + " ");
			if(celula.posicaoX == xMax)
				System.out.println();
		}
	}

}
