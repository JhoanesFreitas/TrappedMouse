package br.com.jho.al.start;

import br.com.jho.al.maze.Cell;
import br.com.jho.al.maze.Maze;

public class Tracking {

    private Maze maze;

    public Tracking(Maze maze) {
        this.maze = maze;
    }

    public void backTrack(Cell cell) {

        if (isValue(cell.getX(), cell.getY() - 1, maze.getPASSAGE(), maze.getEXITMARKER())) {
            maze.getMazeStack().push(new Cell(cell.getY() - 1, cell.getX()));
        }
        if (isValue(cell.getX(), cell.getY() + 1, maze.getPASSAGE(), maze.getEXITMARKER())) {
            maze.getMazeStack().push(new Cell(cell.getY() + 1, cell.getX()));
        }
        if (isValue(cell.getX() - 1, cell.getY(), maze.getPASSAGE(), maze.getEXITMARKER())) {
            maze.getMazeStack().push(new Cell(cell.getY(), cell.getX() - 1));
        }
        if (isValue(cell.getX() + 1, cell.getY(), maze.getPASSAGE(), maze.getEXITMARKER())) {
            maze.getMazeStack().push(new Cell(cell.getY(), cell.getX() + 1));
        }
    }

    private boolean isValue(int j, int i, char cmp1, char cmp2) {
        return ((maze.getElementMaze(i, j) == cmp1) || (maze.getElementMaze(i, j) == cmp2));
    }
}
