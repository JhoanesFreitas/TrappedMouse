package br.com.jho.al.start;

import java.util.Scanner;

import br.com.jho.al.maze.Cell;
import br.com.jho.al.maze.Maze;
import br.com.jho.al.stackmanager.MyStack;

public class Start {

	public static void main(String[] args) {

		int size;
		int cont = 0;
		// char a = 'p';
		String mazeRow;
		String[] a;// = new String[10];

		Scanner in = new Scanner(System.in);
		MyStack stack;
		Maze maze = new Maze();
		maze.initMaze(4);

		System.out.println("Digite o número de linhas para o labirinto: ");
		size = in.nextInt();

		// mazeRow = new String[size];
		stack = new MyStack(size);

		for (int i = 0; i < size; i++) {
			System.out.println("Linha: ");
			mazeRow = in.next();

			a = mazeRow.split("");

			while (cont < a.length) {

				if (a[cont].equals(maze.getPASSAGE())) {
					

				} else if (a[cont].equals(maze.getENTRYMARKER())) {

				} else if (a[cont].equals(maze.getEXITMARKER())) {

				} else if (a[cont].equals(maze.getVISITED())) {

				} else if (a[cont].equals(maze.getWALL())) {

				}
				
				cont++;
			}
		}

		// Erro aqui, tentei com set tbm... Ja tentei mudar la na classe
		// MyStack, mas da erro ao executar
		// maze.getMazeStack().push(new Cell());

		// maze.getMazeStack().print();
	}
}
