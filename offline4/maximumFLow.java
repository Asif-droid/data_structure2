package offline4;

import java.util.LinkedList;
import java.util.Queue;

public  class maximumFLow {




        boolean  bfs(int rgrph[][],int s,int t,int parent[]){

            boolean[] visited=new boolean[rgrph.length];
            parent[s]=-1;
            Queue<Integer> queue=new LinkedList();
            queue.add(s);

            while(!queue.isEmpty()){
                int u=queue.poll();
                for(int v=0;v<rgrph.length;v++){
                    if(!visited[v]&&rgrph[u][v]>0){
                        visited[v]=true;
                        queue.add(v);
                        parent[v]=u;
                    }
                }
            }
            if(visited[t])
                return true;
            else
                return false;

        }


        void dfs(int gr[][],int s,boolean visited[]){
            visited[s]=true;
            for(int i=0;i<gr.length;i++){
                if(gr[s][i]>0&&!visited[i]){
                    dfs(gr,i,visited);
                }
            }
        }

        int fordFulkerson(int graph[][],int s,int t){

            int sz=graph.length;
            int v,u;
            int maxFlow=0;
            int parent[]=new int[graph.length];
            int pathFlow=Integer.MAX_VALUE;
        /*for(int i=0;i<sz;i++){
            for(int j=0;j<sz;j++){

            }
        }*/

            while(bfs(graph,s,t,parent)){

                for(v=t;v!=s;v=parent[v]){
                    u=parent[v];
                    pathFlow=Math.min(pathFlow,graph[u][v]);
                }

                for(v=t;v!=s;v=parent[v]){
                    u=parent[v];
                    graph[u][v]-=pathFlow;
                    graph[v][u]+=pathFlow;
                }

                maxFlow+=pathFlow;

            }

            return maxFlow;
        }











    public static void main(String[] args) {

        int [][]graph={ {0, 16, 13, 0, 0, 0},
                {0, 0, 10, 12, 0, 0},
                {0, 4, 0, 0, 14, 0},
                {0, 0, 9, 0, 0, 20},
                {0, 0, 0, 7, 0, 4},
                {0, 0, 0, 0, 0, 0}
        };
        //graph g=new graph();
        //System.out.println(g.fordFulkerson(graph,0,5));

    }


}
