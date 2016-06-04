package br.com.jho.al.maze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import br.com.jho.al.constants.Constants;
import br.com.jho.al.stackmanager.MyStack;
import br.com.jho.al.start.Tracking;
import java.awt.GridLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Maze extends JFrame {

    private Cell currentCell;
    private Cell exitCell;
    private Cell entryCell;
    private final char EXITMARKER = 'e';
    private final char ENTRYMARKER = 'm';
    private final char VISITED = '.';
    private final char PASSAGE = '0';
    private final char WALL = '1';
    private char[][] maze;
    private MyStack<String> mazeRows;
    private MyStack<Cell> mazeStack;

    private int sizeRow = 0;
    private int sizeCol = 0;
    private boolean existMouse = false;
    private boolean existExit = false;
    private String mazeCmpAux = "p";
    private ArrayList<String> array = new ArrayList<>();

    private int value = -1;
    private BufferedReader br;
    
    JFrame frame;
    JPanel panel;
    JLabel[][] label;

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
    }

    private void tratment(int v) {

        switch (v) {
            case 1:
                buildStack();
                break;
            case 2:
                exitMaze();
                showMaze();
                showMazeConsole();
                break;
            case 0:
                print(Constants.BYE);
                break;
            default:
                print(Constants.NOTVALUE);
                break;
        }

    }

    private void exitMaze() {
        try {
            findValues();
            backTrack();
        } catch (Exception e) {
            if (e.getCause() == null) {
                print(Constants.EXCEPTION);
            }
        }
    }

    private void findValues() throws Exception{
        
        for (int i = 0; i < sizeRow + 2; i++){
            
            for (int j = 0; j < sizeCol + 2; j++){
                
                if (maze[i][j] == getENTRYMARKER()){
                    
                    setEntryCell(createCell(i, j));
                    setCurrentCell(createCell(i, j));
                    setExistMouse(!isExistMouse());
                    
                }else if(maze[i][j] == getEXITMARKER()){
                    
                    setExitCell(createCell(i, j));
                    setExistExit(!isExistExit());
                    
                }
            }
        }

        if (!isExistExit() || !isExistMouse()){
            throw new Exception("Nulo");
        }
    }

    private Cell createCell(int i, int j) {
        return new Cell(i, j);
    }

    private void backTrack() {

        Tracking track = new Tracking(this);

        System.out.println("Início...\t" + getCurrentCell().getY()
                + getCurrentCell().getX());
        mazeStack = new MyStack<>(maze.length);

        while (!getCurrentCell().equals(getExitCell())) {

            maze[getCurrentCell().getY()][getCurrentCell().getX()] = getVISITED();
            track.backTrack(getCurrentCell());

            if (getMazeStack().isEmpty()) {
                print(Constants.WAYNOTFOUND);
                break;
            } else {
                setCurrentCell(getMazeStack().pop());
            }
            System.out.println("Caminhando...\t" + getCurrentCell().getY()
                    + getCurrentCell().getX());
            
            for (int i = 0; i < sizeRow + 2; i++) {
                for (int j = 0; j < sizeCol + 2; j++) {
                    System.out.print(maze[i][j]);
                }
                System.out.println("");
            }
        }

        if (getCurrentCell().equals(getExitCell())) {
            System.out.println("Saiu!");
        }
    }

    private void buildStack() {

        print(Constants.INFOINPUT);

        try {

            while (mazeCmpAux.length() != 0) {

                mazeCmpAux = br.readLine();

                if (mazeCmpAux.length() != 0) {
                    array.add(mazeCmpAux);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!getArray().isEmpty()) {

            setSizeRow(array.size());
            setSizeCol(getArray().get(0).length());

            maze = initArray(getSizeRow(), getSizeCol());
            initMaze(getMaze().length);
            fillMaze(getArray(), getSizeRow(), getSizeCol());

            fillStackMaze();

            invertePilha(getMazeRows(), getSizeRow(), getSizeCol());

            refillMaze();

        } else {
            array.clear();
            mazeCmpAux = "p";
            print(Constants.NULL);
        }
    }

    private void print(String msg) {
        System.out.println(msg);
    }
    
    public void showMazeConsole() {
        for (int i = 0; i < sizeRow + 2; i++) {
            for (int j = 0; j < sizeCol + 2; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }

    private void fillMaze(ArrayList<String> array, int sizeRow, int sizeCol) {

        String rec = "";

        for (int i = 0; i < sizeRow; i++) {
            rec = array.get(i);
            maze[i][0] = '1';

            for (int j = 0; j < sizeCol; j++) {
                maze[i][j + 1] = rec.charAt(j);
            }

            maze[i][sizeCol + 1] = '1';
        }
    }

    private void fillStackMaze() {
        for (int i = 0; i < sizeRow; i++) {
            mazeRows.push(String.valueOf(maze[i]));
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
                        rec = mazeRows.pop();
                    }
                    maze[i][j] = rec.charAt(j);
                }
            }
        }
    }

    private void invertePilha(MyStack<String> maze, int sizeRow, int sizeCol) {

        MyStack<String> aux;
        MyStack<String> m;

        if (maze != null) {

            aux = new MyStack<>(this.maze.length);
            m = new MyStack<>(this.maze.length);

            for (int i = 0; i < sizeRow; i++) {
                aux.push(maze.pop());
            }

            for (int i = 0; i < sizeRow; i++) {
                m.push(aux.pop());
            }

            for (int i = 0; i < sizeRow; i++) {
                maze.push(m.pop());
            }
        }

    }
    
    //Métodos da animação
    
    public void showMaze() {
        startWindow();
        startPanelMain();
        showWindow();
    }
    
//    public void print() {
//        panel.setLocation(sizeRow + 2, sizeCol + 2);
//        
//        for (int i = 0; i < sizeRow; i++) {
//            for (int j = 0; j < sizeCol; j++) {
//                label[i][j] = new JLabel(String.valueOf(maze[i][j]));
//                panel.add(label[i][j]);
//            }
//        }
//    }
   
    public void startWindow() {
        frame = new JFrame("Maze");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void startPanelMain() {
        panel = new JPanel();
        panel.setLayout(new GridLayout(sizeRow + 2, sizeCol + 2));
        
        for (int i = 0; i < sizeRow; i++) {
            for (int j = 0; j < sizeCol; j++) {
                //label[i][j] = String.valueOf(maze[i][j]);
                panel.add(label[i][j]);
            }
        }
        frame.add(panel);
    }
    
    public void showWindow() {
        //frame.pack();
        frame.setSize(600, 400);
        frame.setVisible(true);
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
        mazeRows = new MyStack<>(size);
    }

    public boolean isExistMouse() {
        return existMouse;
    }

    public void setExistMouse(boolean existMouse) {
        this.existMouse = existMouse;
    }

    public boolean isExistExit() {
        return existExit;
    }

    public void setExistExit(boolean existExit) {
        this.existExit = existExit;
    }

    public void setSizeRow(int value) {
        this.sizeRow = value;
    }

    public void setSizeCol(int value) {
        this.sizeCol = value;
    }

    public void setArray(ArrayList<String> array) {
        this.array = array;
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

    public ArrayList<String> getArray() {
        return array;
    }

    public int getSizeRow() {
        return sizeRow;
    }

    public int getSizeCol() {
        return sizeCol;
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

    public MyStack<Cell> getMazeStack() {
        return mazeStack;
    }

    public MyStack<String> getMazeRows() {
        return mazeRows;
    }

    public void setMazeRows(MyStack<String> mazeRows) {
        this.mazeRows = mazeRows;
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
