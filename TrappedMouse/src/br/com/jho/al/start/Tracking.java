package br.com.jho.al.start;

import br.com.jho.al.maze.Cell;
import br.com.jho.al.maze.Maze;
import br.com.jho.al.stackmanager.MyStack;

public class Tracking {

    private Maze maze;

    public Tracking(Maze maze) {
        this.maze = maze;
    }

    public void trackBack(Cell cell) {

        maze.setBackTracking(new MyStack<Cell>(
                maze.getSizeRow() * (maze.getSizeRow() + 2)));
        
        try {
            if (isValue(cell.getX() - 1, cell.getY(), maze.getPASSAGE(), maze.getEXITMARKER())) {
                maze.getBackTracking().push(new Cell(cell.getX() - 1, cell.getY()));
            }
        } catch (NullPointerException e) {
            
        }

        try {
            if (isValue(cell.getX() + 1, cell.getY(), maze.getPASSAGE(), maze.getEXITMARKER())) {
                maze.getBackTracking().push(new Cell(cell.getX() + 1, cell.getY()));
            }
        } catch (NullPointerException e) {

        }

        try {
            if (isValue(cell.getX(), cell.getY() - 1, maze.getPASSAGE(), maze.getEXITMARKER())) {
                maze.getBackTracking().push(new Cell(cell.getX(), cell.getY() - 1));
            }
        } catch (NullPointerException e) {

        }

        try {
            if (isValue(cell.getX(), cell.getY() + 1, maze.getPASSAGE(), maze.getEXITMARKER())) {
                maze.getBackTracking().push(new Cell(cell.getX(), cell.getY() + 1));
            }
        } catch (NullPointerException e) {

        }
        
        //System.out.println(maze.getBackTracking().isFull());
    }
    
    private boolean isValue(int i, int j, char cmp1, char cmp2){
        return ((maze.getElementMaze(i, j) == cmp1) || (maze.getElementMaze(i, j) == cmp2));
    }

}
