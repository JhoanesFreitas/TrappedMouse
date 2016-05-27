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
	private char [][] maze;
	private MyStack<Cell> mazeStack;
	private MyStack<Cell> backTracking;

	public void exitMaze() {

	}
	
	public void initArrayMaze(int size){
		maze = new char[size][size];
	}
	
	public void setElementsArray(int l, int c, char value){
		maze[l][c] = value;
	}
	
	public void initMaze(int size){
		mazeStack = new MyStack<>(size);
	}
	
	public void setBackTracking(MyStack<Cell> backTracking) {
		this.backTracking = backTracking;
	}
	
	public void setCurrentCell(Cell currentCell) {
		this.currentCell = currentCell;
	}
	
	public void setEntryCell(Cell entryCell) {
		this.entryCell = entryCell;
	}
	
	public void setExitCell(Cell exitCell) {
		this.exitCell = exitCell;
	}
	 
	public void setMaze(char[][] maze) {
		this.maze = maze;
	}
	
	public void setMazeStack(MyStack<Cell> mazeStack) {
		this.mazeStack = mazeStack;
	}
	
	public MyStack<Cell> getBackTracking() {
		return backTracking;
	}
	
	public Cell getCurrentCell() {
		return currentCell;
	}
	
	public Cell getEntryCell() {
		return entryCell;
	}
	
	public char getENTRYMARKER() {
		return ENTRYMARKER;
	}
	
	public Cell getExitCell() {
		return exitCell;
	}
	
	public char getEXITMARKER() {
		return EXITMARKER;
	}
	
	public char[][] getMaze() {
		return maze;
	}
	
	public MyStack<Cell> getMazeStack() {
		return mazeStack;
	}
	
	public char getPASSAGE() {
		return PASSAGE;
	}
	
	public char getVISITED() {
		return VISITED;
	}
	
	public char getWALL() {
		return WALL;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
