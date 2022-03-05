package test2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class graphAdjList {
    private LinkedList<Integer> adjList[];

    public graphAdjList(int v){
        adjList=new LinkedList[v];

        for(int i=0;i<v;i++){
            adjList[i]=new LinkedList<Integer>();
        }
    }


    public void addEdge(int s,int d){  //one directional edge
        adjList[s].add(d);
    }
    public void addEdgeBi(int s,int d){     //bidirectional edge
        adjList[s].add(d);
        adjList[d].add(s);
    }
    public boolean Edge(int s,int d){
        if(adjList[s].contains(d))
            return true;
        else
            return false;
    }

    public LinkedList<Integer>[] getAdjList() {
        return adjList;
    }

    public boolean bfs(int source, int dest){

        boolean visited[]=new boolean[adjList.length];
        Queue<Integer> q= new LinkedList<>();
        q.add(source);
        visited[source]=true;
        while (!q.isEmpty()){
            int cur=q.poll();
            if(cur==dest)
                return true;

            for(int neighbour :adjList[cur]){
                if(!visited[neighbour]){
                    q.add(neighbour);
                    visited[neighbour]=true;
                }
            }

        }
        return false;

    }


    public boolean dfs(int source, int des, Stack<Integer> st){
        boolean visited[]=new boolean[adjList.length];
        visited[source]=true;
        return  dfsutil(source,des,visited);
    }
    boolean dfsutil(int s,int d,boolean vis[]){
        if(s==d){
            return true;
        }
        for(int neighbour: adjList[s]){
            if(!vis[neighbour]){
                vis[neighbour]=true;
                boolean found=dfsutil(neighbour,d,vis);
                if(found)
                    return true;
            }
        }
        return false;
    }

    public void topologicalSort(){
        Stack<Integer> st = new Stack<Integer>();
        boolean visited[]=new boolean[adjList.length];
        //System.out.println(adjList.length);
        for(int i=0;i<adjList.length;i++){
            topoSorting(i,st,visited);
        }
        System.out.println("printing");
        while(!st.isEmpty()){
            System.out.println(st.pop());
        }

    }
    public void topoSorting(int node,Stack s,boolean visited[]){

        if(adjList[node].isEmpty()){        // stacks the node if it has no outgoing edge
            if(!visited[node]){
                s.push(node);
                visited[node]=true;
                //System.out.println(node);
            }
        }
        else{
            for(int neighbour :adjList[node]){              //recursively traverse every node in adjList
                //System.out.println(neighbour+""+node);
                if(visited[neighbour]){
                    int ind=adjList[node].indexOf(neighbour);
                    adjList[node].remove(ind);
                    continue;
                }
                topoSorting(neighbour,s,visited);
            }
            s.push(node);                               //after completing all node in list the node
                                                        // itself has no new outgoing edge
            visited[node]=true;

        }



    }


}
