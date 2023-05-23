package robo;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Jogador player;
		int x, y, aux;
		Scanner input = new Scanner(System.in);

		System.out.println("Seja bem vindo! Informe seu nome:");
		player = new Jogador(input.next());

		System.out.println("insira o valor de x e y:");
		x = input.nextInt();
		y = input.nextInt();

		Plano p = new Plano(x, y);

		ArrayList<Robo> robos = new ArrayList<>();
		ArrayList<Aluno> listaAluno = new ArrayList<>();
		ArrayList<Bug> listaBug = new ArrayList<>();

		robos.add(new Andador(1, "Andador", 1, y, p));
		robos.add(new Peao(2, "Peao", 2, y, p));
		robos.add(new Torre(3, "Torre", 3, y, p));
		robos.add(new Bispo(4, "Bispo", 4, y, p));
		robos.add(new Cavalo(5, "Cavalo", 5, y, p));
		robos.add(new Rei(6, "Rei", 6, y, p));
		robos.add(new Rainha(7, "Rainha", 7, y, p));

		System.out.println("Informe a quantidade de Alunos:");
		aux = input.nextInt();
		for (int i = 0; i < aux; i++) {
			listaAluno.add(new Aluno((i + 8), "Aluno", x, y, p));
		}

		System.out.println("Informe a quantidade de Bugs:");
		aux = input.nextInt();
		for (int i = 0; i < aux; i++) {
			listaBug.add(new Bug((i + 9), "Bug", x, y, p));
		}

		while (player.jogando == true && p.numeroAlunos != 0) {
			p.criarGrade();
			
			for (Robo robo : robos) {
				System.out.println("Voce quer avancar(1) ou retroceder(2) com o robo: " + robo.nome);
				aux = input.nextInt();
				input.nextLine();
				while (aux != 1 && aux != 2) {
					System.out.println("valor invalido tente outro:");
					aux = input.nextInt();
					input.nextLine();
				}

				if (aux == 1)
					robo.avancar();
				else if (aux == 2)
					robo.retroceder();

				aux = 0;
			}
			System.out.println("Nesta rodada: " + (p.numeroAlunosTotais - p.numeroAlunos) + " Alunos foram encontrados");
			
			System.out.println("Digite 's' para sair do jogo, caso contrario digite qualquer coisa");
			char aux2 = input.next().charAt(0);
			if (aux2 == 's')
				player.jogando = false;
			else {}
		}
		
		System.out.println("\t\tRELATORIO");
	}

}
