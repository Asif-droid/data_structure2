package test1;

import java.util.LinkedList;
import java.util.Queue;

public class bipartite {
    static class graph {
        LinkedList<Integer> adjList[];

        public graph(int v) {
            adjList = new LinkedList[v];
            for (int i = 0; i < v; i++) {
                adjList[i] = new LinkedList<>();
            }
        }

        public void addEdge(int s, int d) {
            adjList[s].add(d);
            //adjList[d].add(s);
        }

        boolean isBipartite(int s){
            int color[]=new int[adjList.length];
            for(int i=0;i<adjList.length;i++){
                color[i]=-1;
            }
            color[s]=0;
            Queue<Integer> q=new LinkedList<>();
            q.add(s);
            while(!q.isEmpty()){
                int u=q.poll();
                for(int n:adjList[u]){
                    if(color[n]==-1){
                        color[n]=1-color[u];
                    }
                    if(color[n]==color[u])
                        return false;
                }
            }
            return true;


        }


    }







}
