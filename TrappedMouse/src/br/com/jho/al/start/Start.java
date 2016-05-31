package br.com.jho.al.start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import br.com.jho.al.maze.Cell;
import br.com.jho.al.maze.Maze;

public class Start {

	private static Scanner in = new Scanner(System.in);
	private static final String INFOINPUT = "Informe os valores: \t - Enter duas vezes para terminar\n";
	private static final String INFONOTFOUND = "Nenhum valor informado!";

	public static void main(String[] args) {

		int sizeRow = 0;
		int sizeCol = 0;
		int cont = 0;
		int linha = 0;
		String mazeRow = "p";
		String[][] a;
		ArrayList<String> array = new ArrayList<>();

		Maze maze = new Maze();
		Maze aux = new Maze();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println(INFOINPUT);

		try {

			while (mazeRow.length() != 0) {

				mazeRow = br.readLine();

				if (mazeRow.length() != 0)
					array.add(mazeRow);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		if (!array.isEmpty()) {
			sizeRow = array.size();
			sizeCol = array.get(0).length();

			initArrayAndStacks(maze, sizeRow, sizeCol);
			initArrayAndStacks(aux, sizeRow, sizeCol);

			a = initArray(sizeRow, sizeCol);

			fillMaze(a, array, sizeRow, sizeCol);

			initMaze(maze, a, sizeRow, sizeCol);

			invertePilha(maze, aux, sizeRow, sizeCol);

			printMaze(a, maze, aux, sizeRow, sizeCol);
		}else
			System.out.println(INFONOTFOUND);

	}

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

	private static void fillMaze(String[][] a, ArrayList<String> array, int sizeRow, int sizeCol) {

		String rec = "";

		for (int i = 0; i < sizeRow; i++) {
			rec = array.get(i);
			rec += "11";
			a[i] = rec.split("");
		}

	}

}
