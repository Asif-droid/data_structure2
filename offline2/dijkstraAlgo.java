package offline2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class dijkstraAlgo {

    static  class node{
        int index;
        int key;
        int parent=-1;
        LinkedList<node> abjList;
        node(int index){
            this.index=index;
            abjList=new LinkedList<>();
        }
        node(int index,int key,int parent){
            this.index=index;
            this.key=key;
            this.parent=parent;
            abjList=new LinkedList<>();

        }
    }
    static class myCompare implements Comparator<node>{

        @Override
        public int compare(node o1, node o2) {
            if(o1.key>o2.key)
                return 1;        //o1 should be placed after o2
            else
                return -1;        //o2 should be placed after o1
        }
    }
    static class graph{
        int v;
        int e;
        node nodes[];
        graph(int v,int e){
            this.v=v;
            this.e=e;
            nodes=new node[v];
            for(int i=0;i<v;i++){
                nodes[i]=new node(i);
            }
        }
        void addEdge(int s,int d,int w){
            node n=new node(d,w,s);
            nodes[s].abjList.add(n);
        }
        void path(int s,int d){
            PriorityQueue<node> pq=new PriorityQueue<>(new myCompare());
            boolean visited[]=new boolean[v];
            int parent[]=new int[v];
            int cost[]=new int[v];
            for(int i=0;i<v;i++){
                cost[i]=10000000;
                parent[i]=-1;
            }
            cost[s]=0;
            pq.add(nodes[s]);

            while(!pq.isEmpty()){

                node u=pq.poll();
                visited[u.index]=true;
                //System.out.print(u.index+"---");
                parent[u.index]=u.parent;
                //System.out.println(u.index+" "+parent[u.index]+"---");
                if(u.index==d)
                    break;
                for(node n:nodes[u.index].abjList){
                    if(!visited[n.index]){
                        int c=cost[u.index]+n.key;
                        if(c<cost[n.index]){
                            cost[n.index]=c;
                            n.key=c;

                        }
                        pq.add(n);
                    }
                }



            }
            System.out.println("Shortest path cost "+cost[d]);
            Stack<Integer> stack=new Stack();
            while(d!=-1){

                //System.out.println(d);
                stack.push(d);
                d=parent[d];

            }

            if(stack.pop()==s){
                System.out.print(s);
                while (!stack.isEmpty()){
                    System.out.print("->"+stack.pop());

                }

            }





        }




    }

    public static void main(String[] args) {

        File file=new File("F:\\2-2\\cse208\\src\\offline2\\input2.txt");

        Scanner sc= null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        int v=sc.nextInt();
        int e=sc.nextInt();
        graph g=new graph(v,e);
        for(int i=0;i<e;i++){
            int s=sc.nextInt();
            int d=sc.nextInt();
            int w=sc.nextInt();
            g.addEdge(s,d,w);
        }
        int so=sc.nextInt();
        int ds=sc.nextInt();
        g.path(so,ds);

    }




}
