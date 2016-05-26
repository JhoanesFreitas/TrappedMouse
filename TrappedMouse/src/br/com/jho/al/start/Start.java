package br.com.jho.al.start;

import java.util.Scanner;

import br.com.jho.al.maze.Cell;
import br.com.jho.al.maze.Maze;
import br.com.jho.al.stackmanager.MyStack;

public class Start<T> {

	public static void main(String[] args) {
		
		int size;
		String row;
		
		Scanner in = new Scanner(System.in);
		MyStack stack;
		Maze maze = new Maze();
		
		System.out.println("Digite o número de linhas para o labirinto: ");
		size = in.nextInt();
		
		stack = new MyStack(size);
		
		for (int i = 0; i < size; i++) {
			System.out.println("Linha: ");
			row = in.next();
			
			//Erro aqui, tentei com set tbm... Ja tentei mudar la na classe
			//MyStack, mas da erro ao executar
			maze.getMazeStack().push(row);;
		}
		
		maze.getMazeStack().print();
	}
}
