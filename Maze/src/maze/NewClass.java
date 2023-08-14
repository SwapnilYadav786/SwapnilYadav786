/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze;

import java.awt.*;
import java.awt.Graphics;
import javax.swing.*;
import java.util.*;

/**
 *
 * @author swapnil
 */
public class NewClass extends JFrame{
            private int[][] maze={
                                {1,1,1,1,1,1,1,1,1,1,1,1,1},
                                {1,0,1,0,1,0,1,0,0,0,0,0,1},
                                {1,0,1,0,0,0,1,0,1,1,1,0,1},
                                {1,0,1,1,1,1,1,0,0,1,0,0,1},
                                {1,0,0,1,0,0,0,0,1,1,1,0,1},
                                {1,0,1,0,1,1,1,0,1,0,0,0,1},
                                {1,0,1,0,1,0,0,0,1,1,1,0,1},
                                {1,0,1,0,1,1,1,0,1,0,1,0,1},
                                {1,0,0,0,0,0,0,0,0,0,1,9,1},
                                {1,1,1,1,1,1,1,1,1,1,1,1,1},
                
        };
            public ArrayList<Integer> path = new ArrayList<>();

            public NewClass(){
                setTitle("Maze Solver");
                setSize(650,720);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                boolean flag =true;
                      flag=DepthSearch.searchPath(maze,1,1,path);
                      if(flag){
                          System.out.print(path);
                      }
            }
            @Override
            public void paint(Graphics g){
                g.translate(50, 50);
                for(int i=0;i<maze.length;i++){
                    for(int j=0;j<maze[0].length;j++){
                        Color color = null;
                        switch(maze[i][j]){
                            case 1 : color=color.black;break;
                            case 9 : color = color.red;break;
                            default : color=Color.white;break;
                            
                        }
                        g.setColor(color);
                        g.fillRect(30*j,30*i,30,30);
                        g.setColor(color.red);
                          g.drawRect(30*j,30*i,30,30);

                    }
                }
                for(int i=2;i<path.size();i+=2){
                    int pathx=path.get(i);
                    int pathy=path.get(i+1);
                    
                    g.setColor(Color.GREEN);
                    g.fillRect(30*pathy,30*pathx,30,30);
                }
                
            }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        NewClass view = new NewClass();
        view.setVisible(true);
    }
    
}
