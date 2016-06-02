package br.com.jho.al.maze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import br.com.jho.al.constants.Constants;
import br.com.jho.al.stackmanager.MyStack;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Maze {

    private Cell currentCell;
    private Cell exitCell;
    private Cell entryCell;
    private final char EXITMARKER = 'e';
    private final char ENTRYMARKER = 'm';
    private final char VISITED = '.';
    private final char PASSAGE = '0';
    private final char WALL = '1';
    private char[][] maze;
    private MyStack<String> mazeStack;
    private MyStack<Cell> backTracking;

    private int sizeRow = 0;
    private int sizeCol = 0;
    private String mazeRow = "p";
    private ArrayList<String> array = new ArrayList<>();
    
    private int value = -1;
    private BufferedReader br;
    
    public void execute() {
        menu();
    }

    private void menu() {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        
        while (value != 0) {
            System.out.println(Constants.INFOINITMENU);
            System.out.println(Constants.MENU1);
            System.out.println(Constants.MENU2);
            System.out.println(Constants.EXIT);
            
            try {
                value = Integer.valueOf(br.readLine());
            } catch (IOException ex) {
                Logger.getLogger(Maze.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            tratment(value);
            
        }

        return;
    }
    
    private void tratment(int v){
        
        switch(v){
            case 1:
                buildStack();
                break;
            case 2:
                exitMaze();
                break;
            case 0:
                break;
            default:
                System.out.println("Valor inválido!");
                break;
        }
        
    }
    
    private void exitMaze() {
        findValues();
    }
    
    private void findValues(){
        for (int i = 0; i < sizeRow + 2; i++) {
            for (int j = 0; j < sizeCol + 2; j++) {
                if(maze[i][j] == getENTRYMARKER()){
                    setEntryCell(createCell(i, j));
                    setCurrentCell(createCell(i, j));
                }
                else if(maze[i][j] == getEXITMARKER())
                    setExitCell(createCell(i, j));
            }
        }
    }
    
    private Cell createCell(int i, int j){
        return new Cell(i, j);
    }

    private void buildStack() {

        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(Constants.INFOINPUT);

        try {

            while (mazeRow.length() != 0) {

                mazeRow = br.readLine();

                if (mazeRow.length() != 0) {
                    array.add(mazeRow);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        sizeRow = array.size();
        sizeCol = array.get(0).length();

        maze = initArray(sizeRow, sizeCol);
        initMaze(sizeRow * (sizeCol + 2));
        fillMaze(array, sizeRow, sizeCol);

        fillStackMaze();

        //aux.initMaze();
        invertePilha(mazeStack, sizeRow, sizeCol);

        refillMaze();
    }

    private void fillMaze(ArrayList<String> array, int sizeRow, int sizeCol) {

        String rec = "";

        for (int i = 0; i < sizeRow; i++) {
            rec = array.get(i);
            maze[i][0] = '1';

            for (int j = 0; j < sizeCol; j++) {
                maze[i][j + 1] = rec.charAt(j);
                //System.out.print(maze[i][j+1]);
            }

            maze[i][sizeCol + 1] = '1';
        }
    }

    private void fillStackMaze() {
        for (int i = 0; i < sizeRow; i++) {
            mazeStack.push(String.valueOf(maze[i]));
        }
    }

    private void refillMaze() {

        String rec = "";

        for (int i = 0; i < sizeRow + 2; i++) {
            for (int j = 0; j < sizeCol + 2; j++) {

                if (i == 0) {
                    maze[i][j] = '1';
                } else if (i == sizeRow + 1) {
                    maze[i][j] = '1';
                } else {
                    if (j == 0) {
                        rec = mazeStack.pop();
                    }
                    maze[i][j] = rec.charAt(j);
                }

                //System.out.print(maze[i][j]);
            }
            //System.out.println();
        }
    }

    private static void invertePilha(MyStack<String> maze, int sizeRow, int sizeCol) {

        MyStack<String> aux = new MyStack<>(sizeRow * (sizeCol + 2));

        for (int i = 0; i < sizeRow; i++) {
            aux.push(maze.pop());
        }

        MyStack<String> m = new MyStack<>(sizeRow * (sizeCol + 2));

        for (int i = 0; i < sizeRow; i++) {
            m.push(aux.pop());
        }

        for (int i = 0; i < sizeRow; i++) {
            maze.push(m.pop());
        }

    }

    private void initArrayAndStacks(Maze maze, int sizeRow, int sizeCol) {
        maze.initMaze(sizeRow * (sizeCol + 2));
    }

    private char[][] initArray(int sizeRow, int sizeCol) {
        return new char[sizeRow + 2][sizeCol + 2];
    }

    public void initArrayMaze(int sizeRow, int sizeCol) {
        maze = new char[sizeRow][sizeCol];
    }

    public void setElementsArray(int l, int c, char value) {
        maze[l][c] = value;
    }

    public void initMaze(int size) {
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

    public void setMazeStack(MyStack<String> mazeStack) {
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

    public char getElementMaze(int l, int c) {
        return maze[l][c];
    }

    public MyStack<String> getMazeStack() {
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
