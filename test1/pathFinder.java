package test1;

import java.util.LinkedList;
import java.util.Queue;

public class pathFinder {

    static class graph{
        LinkedList<Integer> adjList[];

        public graph(int n){
            adjList=new LinkedList[n];
            for(int i=0;i<n;i++){
                adjList[i]=new LinkedList<>();
            }
        }
        public void addEdge(int s,int d){
            adjList[s].add(d);
        }

        public void pathFind(int s,int d){
            int parent[]=new int[adjList.length];
            for(int i=0;i<adjList.length;i++){
                parent[i]=-1;
            }
            boolean re = bfs(s,d,parent);
            if(re){
                int cost=0;
                while(d!=-1){
                    System.out.println(d);
                    d=parent[d];
                    cost++;
                }
                System.out.println(cost-1);

            }
            else
                System.out.println(d +" not reachable from "+s);


        }
        boolean bfs(int s,int d,int[] parent){
            boolean visited[]=new boolean[adjList.length];
            Queue<Integer> q=new LinkedList();
            q.add(s);
            visited[s]=true;
            while (!q.isEmpty()){
                int x=q.poll();

                for(int n:adjList[x]){
                    if(!visited[n]){
                        visited[n]=true;
                        parent[n]=x;
                        //System.out.println(x+" "+n);
                        q.add(n);
                        if(n==d)
                            return true;
                    }
                }

            }
            return false;
        }
    }

    public static void main(String[] args) {
        graph g=new graph(6);

        g.addEdge(0,1);
        g.addEdge(2,5);
        g.addEdge(3,5);
        g.addEdge(0,4);
        g.addEdge(3,4);
        g.addEdge(1,2);

        g.pathFind(0,2);
    }


}
