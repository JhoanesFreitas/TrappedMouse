package br.com.jho.al.start;

import br.com.jho.al.maze.Cell;
import br.com.jho.al.maze.Maze;

public class Tracking {
	
	Maze maze = new Maze();
	
	public void trackBack(String[][] a, int sizeRow, int sizeCol) {
		
		for (int i = 0; i < sizeRow; i++) {
			for (int j = 0; j < sizeCol; j++) {
				if (a[i][j] != "m") {
					System.out.println("Labirinto formado incorretamente");
					
				//Gambiarra pra poder comparar string com char
				} else if (a[i][j] == String.valueOf(maze.getENTRYMARKER())) {
					
					maze.getBackTracking().push(new Cell (i, j));
					
				}
			}
		}
	}
}
