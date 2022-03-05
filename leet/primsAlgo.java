package leet;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class primsAlgo {
    static class edge{
        int src;
        int dest;
        double w;
        public edge(int src,int dest,double w){
            this.src=src;
            this.dest=dest;
            this.w=w;
        }
    }

    static class myCompare implements Comparator<edge>{

        @Override
        public int compare(edge o1, edge o2) {
            if(o1.w>o2.w)
                return 1;
            else
                return -1;
        }
    }

    static void printMst(edge[][] edges,int v){

        boolean visited[]=new boolean[v];
        PriorityQueue<edge> pq=new PriorityQueue<>(new myCompare());
        //visited[0]=true;
        pq.add(edges[0][0]);
        edge resultEdge[]= new edge[v];
        int e=0;

        while(!pq.isEmpty()){

            edge ce=pq.poll();
            System.out.println(ce.w);

            if(visited[ce.src]){
                continue;


            }
            else {
                if(ce.w!=-1){
                    resultEdge[e++]=ce;
                }

                visited[ce.src]=true;
            }



            for(int i=0;i<v;i++){
                if(!visited[i]){
                    if(edges[ce.src][i].w!=-1){
                        pq.add(edges[i][ce.src]);
                    }
                }

            }



        }
        double s=0;
        for(int i=0;i<v-1;i++){
            System.out.println(resultEdge[i].dest+""+resultEdge[i].src);
            s+=resultEdge[i].w;
        }
        System.out.println(s);



    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        int e=sc.nextInt();
        edge edges[][]=new edge[v][v];
        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                edge t=new edge(i,j,-1);
                edges[i][j]=t;
            }
        }
        for(int i=0;i<e;i++){
            int s=sc.nextInt();
            int d=sc.nextInt();
            double w=sc.nextDouble();
            edge edge1=new edge(s,d,w);
            edge edge2=new edge(d,s,w);
            edges[s][d]=edge1;
            edges[d][s]=edge2;
        }
        /*for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){

                System.out.print(edges[i][j].w+" ");
            }
            System.out.println();
        }*/
        printMst(edges,v);
        /*PriorityQueue<edge> pq=new PriorityQueue<>(new myCompare());
        pq.add(edges[0][0]);
        boolean vis[]=new boolean[v];
        while (!pq.isEmpty()){
            edge s=pq.poll();
            //pq.remove();
            System.out.println(s.w);
            vis[s.src]=true;
            for(int i=0;i<v;i++){
                if(!vis[i]){
                    if(edges[i][s.src].w!=-1){
                        pq.add(edges[i][s.src]);

                    }


                }

            }

        }*/






    }

}
