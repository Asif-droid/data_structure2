package online1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class KruskalAlgo {





    static class graph{
        int v;
        int e;
        edge edges[];
        int Parr[];
        public graph(int v,int e){
            this.v=v;
            this.e=e;
            edges=new edge[e];
            for(int i=0;i<e;i++){
                edges[i]=new edge();
            }
            Parr=new int[v];
            for(int i=0;i<v;i++){
                Parr[i]=-1;
            }

        }

        int findP(int n){
            if(Parr[n]==-1){
                return n;
            }
            return findP(Parr[n]);
        }

        void union(int p,int c){

            Parr[c]=p;

        }

        void sortEdge(){
            Arrays.sort(edges);
            /*for(int i=0;i<e;i++){
                System.out.println(edges[i].src+"-"+edges[i].dest);
            }
            System.out.println("sorted");
*/
        }
        void PrintMst(){
            sortEdge();
            int e=0;
            int i=0;
            double sum=0;
            while((e<v-1)&&(i<edges.length)){
                int n1=edges[i].src;
                int n2=edges[i].dest;
                int x=findP(n1);
                int y=findP(n2);

                if(x!=y){
                    union(x,y);
                    System.out.println(n1+"-"+n2);
                    sum+=edges[i].w;
                    e++;
                }

                i++;

            }
            System.out.println("Minimum cost "+sum);



        }




    }

    static class  edge implements Comparable<edge>{
        int src;
        int dest;
        double w;

        public edge(){

        }
        public  void createEdge(int s,int d,double w){
            src=s;
            dest=d;
            this.w=w;
            //System.out.println(src+""+dest);
        }

        public int getDest() {
            return dest;
        }

        public int getSrc() {
            return src;
        }


        @Override
        public int compareTo(edge e) {
            if(this.w >= e.w)        //if 1 else -1 ascending
                return 1;

            else
                return -1;
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        int e=sc.nextInt();

        graph g=new graph(v,e);
        for(int i=0;i<e;i++){
            int s=sc.nextInt();
            int d=sc.nextInt();
            double w=sc.nextDouble();
            g.edges[i].createEdge(s,d,w);
        }

        g.PrintMst();
    }




}
