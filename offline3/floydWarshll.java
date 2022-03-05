package offline3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class floydWarshll {


    static class graph{
        int adjMat[][];
        int v;
        int INF=1000000;
        graph(int v){
            this.v=v;
            adjMat=new int[v][v];


            for(int i=0;i<v;i++){
                for(int j=0;j<v;j++){
                    if(i==j){
                        adjMat[i][j]=0;
                    }
                    else {
                        adjMat[i][j]=INF;
                    }
                }
            }
        }
        void addEdge(int s,int d,int w){
            adjMat[s][d]=w;
        }
        void allPairPath(){

            for(int k=0;k<v;k++){
                for(int i=0;i<v;i++){
                    for(int j=0;j<v;j++){
                        if(adjMat[i][j]>adjMat[i][k]+adjMat[k][j]){
                            adjMat[i][j]=adjMat[i][k]+adjMat[k][j];
                        }
                    }
                }
            }

            for(int i=0;i<v;i++){
                for(int j=0;j<v;j++){
                    if(adjMat[i][j]==INF){
                        System.out.print("INF ");
                    }
                    else{
                        System.out.print(adjMat[i][j]+"   ");
                    }

                }
                System.out.println();
            }

        }




    }


    public static void main(String[] args) {


        File file=new File("F:\\2-2\\cse208\\src\\offline3\\input3.txt");

        Scanner sc= null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int n=sc.nextInt();
        int e=sc.nextInt();

        graph g=new graph(n);
        for(int i=0;i<e;i++){
            int s=sc.nextInt();
            int d=sc.nextInt();
            int w=sc.nextInt();
            g.addEdge(s-1,d-1,w);


        }
        g.allPairPath();
    }


}
