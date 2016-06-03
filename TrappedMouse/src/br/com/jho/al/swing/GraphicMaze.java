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
public class GraphicMaze {
    
    Maze maze = new Maze();
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    
    public void showMaze() {
        
        frame.add(panel);
        frame.setVisible(true);
    }
    //panel.add(maze);
    
    //maze.
    
    //JOptionPane.showMessageDialog (parentComponent, maze);
    //JOptionPane.showMessageDialog();
}
