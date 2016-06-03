/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jho.al.swing;

import br.com.jho.al.maze.Maze;
import javax.swing.*;

/**
 *
 * @author alana
 */
public class GraphicMaze extends JPanel{
    
    Maze maze = new Maze();
    JFrame frame;
    JPanel panel;
    
    String m = "";
    
    public void showMaze() {
        
        startWindow();
        startPanelMain();
        showWindow();
    }
    
    public void print() {
        for (int i = 0; i < maze.getSizeRow(); i++) {
            for (int j = 0; j < maze.getSizeCol(); j++) {
                m = String.valueOf(maze.getMaze());
                panel.add(m, this);
            }
        }
    }
   
    public void startWindow() {
        frame = new JFrame("Maze");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void startPanelMain() {
        panel = new JPanel();
        print();
        frame.add(panel);
    }
    
    public void showWindow() {
        //frame.pack();
        frame.setSize(600, 400);
        frame.setVisible(true);
    }
}
