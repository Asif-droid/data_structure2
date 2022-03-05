package test1;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class priorityQ {


    static class graph{
        LinkedList<node> adjList[];
        public graph(int n){
            adjList=new LinkedList[n];
            for(int i=0;i<n;i++){
                adjList[i]=new LinkedList<>();
            }
        }
        void addEdge(node s,node d){

            adjList[s.index].add(d);
            adjList[d.index].add(s);
        }
    }
    static class node{
        int key;
        int index;
        public node(int key,int index){
            this.key=key;
            this.index=index;
        }
    }
    static class myCompare implements Comparator<node> {

        @Override
        public int compare(node o1,node o2) {
            if(o1.key>o2.key)
                return -1;
            else
                return 1;
        }


    }

    public static void main(String[] args) {
        PriorityQueue<node> q=new PriorityQueue<>(new myCompare());

        for(int i=0;i<5;i++){
            q.add(new node(i,i));
            if(i==3){
                System.out.println(q.poll().index);
            }
        }
        while (q.peek()!=null){
            node n=q.poll();
            System.out.println(n.index+" "+n.key);
        }


    }

}
