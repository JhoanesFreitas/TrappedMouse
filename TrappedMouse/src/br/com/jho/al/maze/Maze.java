package br.com.jho.al.maze;

import br.com.jho.al.stackmanager.MyStack;

public class Maze {

	private Cell currentCell;
	private Cell exitCell;
	private Cell entryCell;
	private final char EXITMARKER = 'e';
	private final char ENTRYMARKER = 'y';
	private final char VISITED = 'v';
	private final char PASSAGE = 'p';
	private final char WALL = 'w';
	private MyStack<Cell> mazeStack;

	public void exitMaze() {

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
