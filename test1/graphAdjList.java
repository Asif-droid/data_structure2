package test1;

import test2.main;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
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

    public boolean bfs(int source,int dest){

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


    public boolean dfs(int source,int des){
        boolean visited[]=new boolean[adjList.length];
        visited[source]=true;
        return  dfsutil(source,des,visited);
    }
    public boolean dfs(int source,int des,Stack st){
        boolean visited[]=new boolean[adjList.length];
        visited[source]=true;
        return  dfsutil(source,des,visited,st);
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
    boolean dfsutil(int s,int d,boolean vis[],Stack st){
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
        st.push(s);
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
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int s=scanner.nextInt();

        test2.graphAdjList gr=new test2.graphAdjList(n+1);
        test2.graphAdjList gt=new test2.graphAdjList(n+1);
        Stack<Integer> st=new Stack<>();
        for (int i=0;i<s;i++){
            int f1=scanner.nextInt();
            int f2=scanner.nextInt();
            gr.addEdge(f1,f2);
            gt.addEdge(f2, f1);

        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(j==1)
                    continue;
                gr.dfs(i,j,st);
            }

        }





    }


}
