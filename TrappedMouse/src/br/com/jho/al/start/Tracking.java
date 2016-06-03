package br.com.jho.al.start;

import br.com.jho.al.maze.Cell;
import br.com.jho.al.maze.Maze;

public class Tracking {

	private Maze maze;

	public Tracking(Maze maze, int sizeRow, int sizeCol) {
		this.maze = maze;
	}

	public void execute(){
		
	}
	
	public void trackBack(String[][] a, int sizeRow, int sizeCol) {

		validate(sizeRow, sizeCol, String.valueOf(maze.getENTRYMARKER()));
		
		for (int i = 0; i < sizeRow; i++) {
			for (int j = 0; j < sizeCol; j++) {
				if (a[i][j] == String.valueOf(maze.getENTRYMARKER())) {

					maze.getBackTracking().push(new Cell(i, j));

				}
			}
		}
	}

	private boolean validate(int sizeRow, int sizeCol, String search) {
		for (int i = 0; i < sizeRow; i++) {
			for (int j = 0; j < sizeCol; j++) {
//				if (maze.getElementMaze(i, j).equals(search)) {
//					return true;
//				}
			}
		}
		return false;
	}

}
