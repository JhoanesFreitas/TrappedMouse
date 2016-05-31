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
		Maze aux = new Maze();

		System.out.println("Digite o número de linhas para o labirinto: ");
		sizeRow = in.nextInt();

		System.out.println("Digite o número de colunas para o labirinto: ");
		sizeCol = in.nextInt();

		initArrayAndStacks(maze, sizeRow, sizeCol);
		initArrayAndStacks(aux, sizeRow, sizeCol);

		a = initArray(sizeRow, sizeCol);

		fillMaze(a, sizeRow, sizeCol);

		initMaze(maze, a, sizeRow, sizeCol);

		invertePilha(maze, aux, sizeRow, sizeCol);

		printMaze(a, maze, aux, sizeRow, sizeCol);

	}

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
					

	private static void printMaze(String[][] a, Maze maze, Maze aux, int sizeRow, int sizeCol) {

		for (int i = 0; i < sizeRow + 2; i++) {
			for (int j = 0; j < sizeCol + 2; j++) {

				if (i == 0) {
					a[i][j] = "1";
				} else if (i == sizeRow + 1) {
					a[i][j] = "1";
				} else {
					Cell cell = aux.getMazeStack().pop();
					a[i][j] = maze.getElementMaze(cell.getX(), cell.getY());
				}
				
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
	}

	private static void invertePilha(Maze maze, Maze aux, int sizeRow, int sizeCol) {

		for (int i = 0; i < sizeRow * (sizeCol + 2); i++) {
			aux.getMazeStack().push(maze.getMazeStack().pop());
		}
	}

	private static void initMaze(Maze maze, String[][] a, int sizeRow, int sizeCol) {

		for (int i = 0; i < sizeRow; i++) {

			maze.getMazeStack().push(new Cell(i, 0));
			maze.setElementsArray(i, 0, "1");

			for (int j = 0; j < sizeCol; j++) {
				maze.getMazeStack().push(new Cell(i, j + 1));
				maze.setElementsArray(i, j + 1, a[i][j]);
			}

			maze.getMazeStack().push(new Cell(i, sizeCol + 1));
			maze.setElementsArray(i, sizeCol + 1, "1");

		}

	}

	private static String[][] initArray(int sizeRow, int sizeCol) {
		return new String[sizeRow + 2][sizeCol + 2];
	}

	private static void initArrayAndStacks(Maze maze, int sizeRow, int sizeCol) {
		maze.initMaze(sizeRow * (sizeCol + 2));
		maze.initArrayMaze(sizeRow, (sizeCol + 2));
	}

	private static void fillMaze(String[][] a, int sizeRow, int sizeCol) {

		String rec = "";
		System.out.println("Informe os valores: \n");
		
		for (int i = 0; i < sizeRow; i++) {
			rec = in.next();
			rec += "11";
			a[i] = rec.split("");
		}
		
	}

}
