package br.com.jho.al.maze;

import br.com.jho.al.stackmanager.MyStack;

public class Maze {

	private Cell currentCell;
	private Cell exitCell;
	private Cell entryCell;
	private final char EXITMARKER = 'e';
	private final char ENTRYMARKER = 'm';
	private final char VISITED = '.';
	private final char PASSAGE = '0';
	private final char WALL = '1';
	private char [] maze;
	private MyStack<Cell> mazeStack;
	private MyStack<Cell> backTracking;

	public void exitMaze() {

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
