package leet;

import test2.graphAdjList;
import test2.main;

import java.util.Scanner;
import java.util.Stack;

public class strongConnectedComponent {






    public static void main(String[] args) {

            Scanner scanner=new Scanner(System.in);
            int pre[][]={{1,0},{0,1}};
            int n=2;
            int s=scanner.nextInt();

            graphAdjList gr=new graphAdjList(n+1);
            graphAdjList gt=new graphAdjList(n+1);
            Stack<Integer> st=new Stack<>();
            boolean visited[]=new boolean[n+1];
            for (int i=0;i<pre.length;i++){
                int f1=pre[i][0];
                int f2=pre[i][1];
                gr.addEdge(f2,f1);
                //gt.addEdge(f2,f1);

            }
            for(int i=1;i<=n;i++){
                fillStack(i,visited,st,gr);
            }
        //System.out.println(gr.bfs(8,7));
        //System.out.println(gt.bfs(8,7));
            boolean vist[]=new boolean[n+1];
            while (!st.isEmpty()){
                int v=st.pop();
                reverseTraverse(v,vist,gr);
                System.out.println();
            }


    }


    static void fillStack(int node,boolean vis[],Stack st,graphAdjList g){
        vis[node]=true;

        for(int neighbour:g.getAdjList()[node]){
            if(!vis[neighbour]){
                fillStack(neighbour,vis,st,g);
            }
        }
        st.push(node);

    }
    static void reverseTraverse(int node,boolean vis[],graphAdjList g){
        if(!vis[node]){
            vis[node]=true;
            System.out.print(node+"");

        }

        for(int neighbour:g.getAdjList()[node]){
            if(!vis[neighbour]){
                reverseTraverse(neighbour,vis,g);
            }
        }
    }
}
