package test2;

import java.util.Scanner;
import java.util.Stack;

public class main {
    static class edge{
        int s;int d;
        edge(int s,int d){
            this.s=s;
            this.d=d;
        }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int s=scanner.nextInt();
        edge edges[]=new edge[s];
        graphAdjList gr=new graphAdjList(n+1);
        graphAdjList gt=new graphAdjList(n+1);
        Stack<Integer> st=new Stack<>();
        for (int i=0;i<s;i++){
            int f1=scanner.nextInt();
            int f2=scanner.nextInt();
            gr.addEdge(f1,f2);
            gt.addEdge(f2, f1);
            edges[i]=new edge(f1,f2);
        }
        for(int i=1;i<=n;i++){

        }





    }
}
