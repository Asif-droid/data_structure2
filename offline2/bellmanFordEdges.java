package offline2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class bellmanFordEdges {

    static  class edge{
        int s;
        int d;

        int w;
        edge(int s,int d,int w){
            this.s=s;
            this.d=d;
            this.w=w;
        }

    }
    static class graph{
        int v;
        int e;
        int edgeC;
        edge edges[];
        graph(int v,int e){
            this.v=v;
            this.e=e;
            edgeC=0;
            edges=new edge[e];
        }
        void addEdge(int s,int d,int w){
            edges[edgeC]=new edge(s,d,w);
            edgeC++;
        }
        void bellmanFord(int s,int d){
            int cost[]=new int[v];
            int parent[]=new int[v];
            for(int i=0;i<v;i++){
                cost[i]=1000000;
                parent[i]=-1;
            }
            cost[s]=0;
            for(int i=0;i<v-1;i++){
                for(int j=0;j<e;j++){
                    int es=edges[j].s;
                    int ed=edges[j].d;
                    int w=edges[j].w;
                    if(cost[ed]>cost[es]+w){
                        cost[ed]=cost[es]+w;
                        parent[ed]=es;

                    }

                }
            }


            for(int j=0;j<e;j++){
                int es=edges[j].s;
                int ed=edges[j].d;
                int w=edges[j].w;
                if(cost[ed]>cost[es]+w){
                    System.out.println("contains negative cycle");
                    return;

                }

            }
            System.out.println("The graph does not contain a negative cycle");
            System.out.println("Shortest path cost "+cost[d]);
            Stack<Integer> stack=new Stack<>();
            while(d!=-1){

                stack.push(d);

                d=parent[d];
            }
            if(stack.pop()==s){
                System.out.print(s);
                while (!stack.isEmpty()){
                    System.out.print("->"+stack.pop());

                }

            }




        }
    }

    public static void main(String[] args) {
        File file=new File("F:\\2-2\\cse208\\src\\offline2\\input.txt");

        Scanner sc= null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int v=sc.nextInt();
        int e=sc.nextInt();
        graph g=new graph(v,e);
        for(int i=0;i<e;i++){
            int s=sc.nextInt();
            int d=sc.nextInt();
            int w=sc.nextInt();

            g.addEdge(s,d,w);
        }
        int ts=sc.nextInt();
        int td=sc.nextInt();
        g.bellmanFord(ts,td);
    }


}
