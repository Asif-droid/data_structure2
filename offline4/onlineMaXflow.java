package offline4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class onlineMaXflow {

    static class edge{
        int s;
        int d;
        int w;
        public edge(int s,int d,int w){
            this.s=s;
            this.d=d;
            this.w=w;

        }
    }

    public static void main(String[] args) {
        File file=new File("F:\\2-2\\cse208\\src\\offline4\\inpt5.txt");

        Scanner sc= null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int v=sc.nextInt();
        int e=sc.nextInt();

        int [][]mat=new int[v][v];
        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                mat[i][j]=0;
            }
        }
        edge edges[]=new edge[e];
        for(int i=0;i<e;i++){
            int u=sc.nextInt();
            int x=sc.nextInt();
            int w=sc.nextInt();
            edges[i]=new edge(u,x,w);
            mat[u][x]=w;

        }
        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                System.out.print(mat[i][j]);
            }
            System.out.println();
        }
        maximumFLow mx=new maximumFLow();
        int f=mx.fordFulkerson(mat,0,v-1);
        System.out.println(f);
        for(int i=0;i<v;i++){
           if(mat[v-1][i]!=0){

           }
        }


    }


}
