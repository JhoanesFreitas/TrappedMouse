package br.com.jho.al.maze;

public class Cell {

    private int x;
    private int y;

    public Cell() {
        // TODO Auto-generated constructor stub
    }

    public Cell(int x, int y) {
        setX(x);
        setY(y);
    }

    public boolean equals(Cell cell) {
        return (cell.getX() == getX() && cell.getY() == getY());
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
