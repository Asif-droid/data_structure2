package leet;

import java.util.LinkedList;

public class courseInfo {
    static class graph{
        LinkedList <Integer> adjList[];

        public graph(int n){
            adjList=new LinkedList[n];
            for(int i=0;i<n;i++){
                adjList[i]=new LinkedList<>();
            }
        }
        public void addEdge(int s,int d){
            adjList[s].add(d);
            System.out.println(s+" "+d);
        }

        public boolean cycle(int s,boolean[] vis,boolean[] reC){
            if(reC[s]){
                return true;
            }


            vis[s]=true;
            reC[s]=true;                      //as long as we traverse the neighbour of s we keep recursion[s]=t
            for (int neighbour:adjList[s]){
                if(!vis[neighbour]){
                    boolean re=cycle(neighbour,vis,reC);
                    if(re)
                        return true;
                }
                else{                       //if the visited ancestor is sill in recursion[] then it has a cycle
                    if(reC[neighbour])
                        return true;
                }
            }
            reC[s]=false;               //when all neighbour of s is visited then recursion[s] is false
            return false;
        }

    }

    static  boolean canFinish(int n, int[][] pre){

        graph gr=new graph(n);

        for (int i=0;i<pre.length;i++){
            int f1=pre[i][0];
            int f2=pre[i][1];
            gr.addEdge(f2,f1);

            //gt.addEdge(f2,f1);

        }
        boolean vis[]=new boolean[n];
        boolean reCrSt[]=new boolean[n];
        boolean re = false;
        for(int i=0;i<n;i++){

            if(!vis[i]){
                re=gr.cycle(i,vis,reCrSt);
            }
            if(re)
                return false;

        }
        return true;


    }
    public static void main(String[] args) {

        int pre[][]={{1,0}};

        System.out.println(canFinish(2,pre));

    }


}
