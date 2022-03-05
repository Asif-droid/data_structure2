package test1;

import java.util.LinkedList;
import java.util.Scanner;

public class union_find {

    static class graph{
        LinkedList<Integer> adjList[];

        public graph(int v){
            adjList=new LinkedList[v];
            for(int i=0;i<v;i++){
                adjList[i]=new LinkedList<>();
            }
        }
        public void addEdge(int s,int d){
            adjList[s].add(d);
            adjList[d].add(s);
        }

        int findParent(int s,int[] parent){
            if(parent[s]==-1)
                return s;

            return findParent(parent[s],parent);

        }
        void union(int s,int d,int[] parent){
            parent[d]=s;
        }

        boolean isCycle(){
            int parent[]=new int[adjList.length];
            boolean visited[]=new boolean[adjList.length];
            for(int i=0;i<adjList.length;i++){
                parent[i]=-1;
            }
            for(int i=0;i<adjList.length;i++){
                int p=findParent(i,parent);
                int c=-1;
                visited[i]=true;
                System.out.print(i+"-");
                for(int n:adjList[i]){
                    if(!visited[n]){
                        c=findParent(n,parent);
                        System.out.println(p+ "  "+""+n+""+c);
                        if(p==c)
                            return true;
                        union(p,c,parent);

                    }

                }

            }
            return false;

        }




    }

    public static void main(String[] args) {
        graph g=new graph(4);
        g.addEdge(0,1);
        g.addEdge(1,3);
        g.addEdge(2,1);
        //g.addEdge(3,2);
        System.out.println(g.isCycle());

    }


}
