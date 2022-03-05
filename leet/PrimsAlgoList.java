package leet;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PrimsAlgoList {



    static  class node{
        int index;
        double key;
        int parent=-1;
        LinkedList<node> adjLst;
        node(int index)
        {
            this.index=index;
            adjLst=new LinkedList<>();
        }
        node(int index,double key,int parent){
            this.index=index;
            this.key=key;
            this.parent=parent;
            adjLst=new LinkedList<>();
        }
    }
    static class myCompare implements Comparator<node>{



        @Override
        public int compare(node o1, node o2) {
            if(o1.key>o2.key)
                return 1;
            else
                return -1;
        }
    }

    static class graph{
        node nodes[];
        int v;
        graph(int v){
            this.v=v;
            nodes=new node[v];
            for(int i=0;i<v;i++){
                nodes[i]=new node(i);
            }

        }
        void addEdge(int s,int d,double w){
            node n1=new node(d,w,s);
            nodes[s].adjLst.add(n1);
            node n2=new node(s,w,d);
            nodes[d].adjLst.add(n2);
            //System.out.println(s+" "+d+" "+w);
        }
        double printMst(int s){
            boolean visited[]=new boolean[v];
            PriorityQueue<node> pq=new PriorityQueue<>(new myCompare());

            pq.add(nodes[s]);
            //visited[s]=true;
            double sum=0;
            while(!pq.isEmpty()){
                node u=pq.poll();
                if(!visited[u.index]&&u.parent!=-1){
                    //System.out.println(u.index+"-"+u.parent);
                    sum+=u.key;
                }


                visited[u.index]=true;

                for(node n:nodes[u.index].adjLst){
                    if(!visited[n.index]){
                        pq.add(n);
                    }
                }
            }
            //System.out.println("Minimum cost "+sum);
            return sum;
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        int e=sc.nextInt();
        int k=sc.nextInt();
        int cost[]=new int[k+1];
        for(int i=1;i<=k;i++){
            cost[i]=sc.nextInt();
            //System.out.println(cost[i]);

        }

        graph g=new graph(v+1);
        /*for(int i=0;i<=e;i++){
            int s=sc.nextInt();
            int d=sc.nextInt();
            double w=sc.nextDouble();
            g.addEdge(s,d,w);
        }*/
        for(int i=1;i<=e;i++){
            int s=sc.nextInt();
            int d=sc.nextInt();
            int l=sc.nextInt();
            int w=0;
            for(int j=1;j<=l;j++){
                int t=sc.nextInt();
                w+=cost[t];
            }
            //System.out.println("ed");
            g.addEdge(s,d,w);
        }
        //System.out.println("as");

        System.out.println(g.printMst(1));
    }

}
