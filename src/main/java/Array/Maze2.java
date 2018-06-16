package Array;

import java.util.Arrays;

/**
 * Created by Administrator on 6/16/2018.
 */
public class Maze2 {

    public static void traversal(int i, int j, int[][] maze) {
        if ( i<0  || i >=maze.length || j<0 || j>=maze[0].length
        || maze[i][j] ==0 || maze[i][j] ==2){
            return;

        } else if (maze[i][j] ==1 ){
            maze[i][j] =2;
            System.out.println("i,j:"+i+","+j);
        }
        traversal(i-1,j,maze);
        traversal(i+1,j,maze);
        traversal(i,j-1,maze);
        traversal(i,j+1,maze);

    }


    public static void main(String[] args) {
        int[][] maze =
                {
                        {1,0,1,1},
                        {0,1,9,1},
                        {0,1,0,0}
                };

        Maze2.traversal(1,1,maze);
        for (int i=0;i<maze.length;i++){
            for (int j=0;j<maze[0].length;j++) {
                System.out.print(maze[i][j] + " " );
            }
            System.out.print("\n");

        }




    }


}
