/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze;

import java.util.ArrayList;

/**
 *
 * @author swapnil
 */
public class DepthSearch {
    public static boolean searchPath(int[][] maze , int x , int y ,ArrayList<Integer> path){
       if(maze[x][y]==9){
           path.add(x);
           path.add(y);
           return true;
       }
           
          if(maze[x][y]==0){
              maze[x][y]=2;
              int[] dx={-1,0,1,0};
              int[] dy ={0,-1,0,1};
              for(int i=0;i<4;i++){
                  int newx=dx[i]+x;
                  int newy=dy[i]+y;
                  if(searchPath(maze,newx,newy,path)){
                      path.add(x);
                      path.add(y);
                      return true;
                  }
              }
             // maze[x][y]=0;
          }
           return false;
       }
      
    }

