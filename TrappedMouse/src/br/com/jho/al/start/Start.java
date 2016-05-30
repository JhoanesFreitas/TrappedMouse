package br.com.jho.al.start;

import java.util.Scanner;

import br.com.jho.al.maze.Cell;
import br.com.jho.al.maze.Maze;
import br.com.jho.al.stackmanager.MyStack;

public class Start {

	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		int sizeRow;
		int sizeCol;
		int cont = 0;
		int linha = 0;
		String mazeRow;
		String[][] a = null;

		Maze maze = new Maze();

		System.out.println("Digite o número de linhas para o labirinto: ");
		sizeRow = in.nextInt();

		System.out.println("Digite o número de colunas para o labirinto: ");
		sizeCol = in.nextInt();

		initArrayAndStacks(maze, sizeRow, sizeCol);
		a = initArray(sizeRow, sizeCol);

		fillMaze(a, sizeRow, sizeCol);
		
		initMaze(maze, a, sizeRow, sizeCol);
		
		printMaze(maze, sizeRow, sizeCol);
		
		

	}
	
	private static void printMaze(Maze maze, int sizeRow, int sizeCol){
		
		for(int i = 0; i < sizeRow; i++){
			for(int j = 0; j < sizeCol + 2; j++){
				System.out.print(maze.getElementMaze(i, j));
			}
			System.out.println();
		}
	}
	
	private static void initMaze(Maze maze, String[][] a, int sizeRow, int sizeCol){
		
		for(int i = 0; i < sizeRow; i++){
			
			maze.getMazeStack().push(new Cell(i, 0));
			maze.setElementsArray(i, 0, "1");
			
			for(int j = 0; j < sizeCol; j++){
				maze.getMazeStack().push(new Cell(i, j + 1));
				maze.setElementsArray(i, j + 1, a[i][j]);
			}
			
			maze.getMazeStack().push(new Cell(i, sizeCol));
			maze.setElementsArray(i, sizeCol + 1, "1");
			
		}
		
	}
	
	private static String[][] initArray(int sizeRow, int sizeCol){
		return new String[sizeRow][sizeCol + 2];
	}

	private static void initArrayAndStacks(Maze maze, int sizeRow, int sizeCol) {
		maze.initMaze(sizeRow * (sizeCol + 2));
		maze.initArrayMaze(sizeRow, (sizeCol + 2));
	}

	private static void fillMaze(String[][] a, int sizeRow, int sizeCol){
		
		System.out.println("Informe os valores: \n");
		
		for(int i = 0; i < sizeRow; i++){
			for(int j = 0; j < sizeCol; j++){
				a[i][j] = in.next();
			}
		}
		
	}

}
