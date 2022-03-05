package test2;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class strongConnectedComponent {







    public static void main(String[] args) {

            Scanner scanner=new Scanner(System.in);
            int n=scanner.nextInt();
            int s=scanner.nextInt();
            test2.main.edge edges[]=new main.edge[s];
            graphAdjList gr=new graphAdjList(n+1);
            graphAdjList gt=new graphAdjList(n+1);
            Stack<Integer> st=new Stack<>();
            boolean visited[]=new boolean[n+1];
            for (int i=0;i<s;i++){
                int f1=scanner.nextInt();
                int f2=scanner.nextInt();
                gr.addEdge(f1,f2);
                gt.addEdge(f2,f1);
                edges[i]=new main.edge(f1,f2);
            }
            for(int i=1;i<=n;i++){
                //only calling fillsatck() without if statement the reverse works on gr not gt

                if(!visited[i])
                    fillStack(i,visited,st,gr);
            }
        System.out.println(gr.bfs(8,7));
        System.out.println(gt.bfs(8,7));
            boolean vist[]=new boolean[n+1];
            st.pop();
            while (!st.isEmpty()){
                int v=st.pop();
                reverseTraverse(v,vist,gt);
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
            //System.out.print("  "+neighbour+"");
            if(!vis[neighbour]){
                reverseTraverse(neighbour,vis,g);
            }
        }
    }
}
