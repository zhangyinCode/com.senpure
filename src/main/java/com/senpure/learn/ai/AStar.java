package com.senpure.learn.ai;

/**
 * Created by Administrator on 2017/2/26.
 */
public class AStar {

    public  static  void printMap( int [][] map)
    {
        int row=map.length;
        int col=map[0].length;

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                System.out.print(map[i][j]);
                System.out.print("  ");
            }
            System.out.println("");
        }
    }


    public static void main(String[] args) {

        int i=10;
        int j=10;
        int [][] map=new int [j][i];
        map[3][5]=1;
         printMap(map);



    }
}
