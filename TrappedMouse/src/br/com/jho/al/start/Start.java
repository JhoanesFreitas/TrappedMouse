package br.com.jho.al.start;

import br.com.jho.al.maze.Maze;
import br.com.jho.al.swing.GraphicMaze;

public class Start {

    public static void main(String[] args) {

        Maze maze = new Maze();
        maze.execute();
        
        GraphicMaze grap = new GraphicMaze();
        
        grap.showMaze();
 
    }
}
