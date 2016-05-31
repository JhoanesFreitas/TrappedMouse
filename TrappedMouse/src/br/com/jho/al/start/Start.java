package br.com.jho.al.start;

import java.util.Scanner;

import br.com.jho.al.maze.Cell;
import br.com.jho.al.maze.Maze;
import br.com.jho.al.stackmanager.MyStack;

public class Start {

	public static void main(String[] args) {

		int size;
		int cont = 0;
		int linha = 0;
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
		maze.initArrayMaze(size);
		

		for (int i = 0; i < size; i++) {
			System.out.println("Linha: ");

			//row = in.next();
			
			//Erro aqui, tentei com set tbm... Ja tentei mudar la na classe
			//MyStack, mas da erro ao executar
			//maze.getMazeStack().push(row);

			mazeRow = in.next();

			a = mazeRow.split("");

			while (cont < a.length) {

				if (a[cont].equals(maze.getPASSAGE())) {
					
					maze.setElementsArray(linha, cont, maze.getPASSAGE());
					
				} else if (a[cont].equals(maze.getENTRYMARKER())) {
					
					maze.setElementsArray(linha, cont, maze.getENTRYMARKER());
					
				} else if (a[cont].equals(maze.getEXITMARKER())) {
					
					maze.setElementsArray(linha, cont, maze.getEXITMARKER());
					
				} else if (a[cont].equals(maze.getVISITED())) {
					
					maze.setElementsArray(linha, cont, maze.getVISITED());
					
				} else if (a[cont].equals(maze.getWALL())) {
					
					maze.setElementsArray(linha, cont, maze.getWALL());
					
				}
				
				Cell cell = new Cell();
				
				cell.setX(linha);
				cell.setY(cont);
				
				maze.getMazeStack().push(cell);
				
				cont++;
			}
			
			linha++;
			
		}

		// Erro aqui, tentei com set tbm... Ja tentei mudar la na classe
		// MyStack, mas da erro ao executar
		// maze.getMazeStack().push(new Cell());

		// maze.getMazeStack().print();
	}
}
