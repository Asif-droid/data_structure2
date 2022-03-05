package offline6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class binomialHeap {

    binomialTree head;
    binomialTree cur;

    public  binomialHeap(){
        head=null;
        cur=null;

    }





    public void insert(binomialTree t){
        if(head==null){
            head=t;

        }else{
            union(t);


        }

    }
    /*public void merge(binomialTree heap){
        binomialTree rear=head;
        while(heap!=null){
            if(rear!=null){
                if(rear.degree==heap.degree){
                    binomialTree tmp=heap;
                    heap=tmp.sibling;
                    tmp.sibling=rear.sibling;
                    rear.sibling=tmp;
                    rear=tmp;

                }else{
                    if(rear.degree<heap.degree){
                        if((rear.sibling == null) ||(rear.sibling.degree>heap.degree)){
                            binomialTree tmp=heap;
                            heap=tmp.sibling;
                            tmp.sibling=rear.sibling;
                            rear.sibling=tmp;
                            rear=tmp;
                        }
                        else {
                            rear=rear.sibling;
                        }
                    }
                    else{
                        binomialTree t=rear;
                        rear=heap;
                        rear.sibling=t;
                        heap=heap.sibling;
                        if(t==head){
                            head=rear;
                        }
                    }


                }



            }/*else {
                rear=heap;
                break;

            }
        }

        if (rear == null) {
            rear = head;
            while (rear.sibling != null) {
                rear = rear.sibling;
            }
            rear.sibling = heap;
        }
    }*/
    public binomialTree mergeTree(binomialTree t1,binomialTree t2){

        if(t1==null){
            return t1;
        }

        binomialTree tmp = t2;

        tmp.sibling = t1.sibling;
        t1.sibling = tmp;
        t1 = tmp.sibling;
        return t1;
    }

    private void merge(binomialTree heap) {
        binomialTree temp1 = head;

        while (heap!= null) {
            if(temp1!=null){
                //System.out.println(temp1.value);
                if (temp1.degree == heap.degree) {

                    binomialTree tmp = heap;
                    heap=heap.sibling;
                    temp1=temp1.addTree(tmp);


                } else {
                    if (temp1.degree < heap.degree) {
                        if ((temp1.sibling==null)||(temp1.sibling.degree>heap.degree)) {
                            binomialTree tmp = heap;
                            heap=heap.sibling;
                            temp1=temp1.addTree(tmp);

                        } else {
                            temp1 = temp1.sibling;
                        }
                    } else {
                        binomialTree tmp = temp1;
                        temp1 = heap;
                        heap = heap.sibling;
                        temp1.sibling = tmp;
                        if (tmp == head) {
                            head = temp1;
                        }
                    }
                }
                /*if(temp1.sibling==null){
                    temp1.sibling=heap;
                }*/

            }

            else {
                break;
            }

        }
        if (temp1 == null) {
            temp1 = head;
            while (temp1.sibling != null) {
                temp1 = temp1.sibling;
            }
            temp1.sibling = heap;
        }
    }





    public  void union(binomialTree node){
        merge(node);
        binomialTree rear=head;
        binomialTree prev=null;
        binomialTree next=head.sibling;

        cur=new binomialTree(-1);
        while (next!=null){

            if((rear.degree!=next.degree)||(next.sibling!=null)&&(next.sibling.degree==rear.degree)){
                prev=rear;
                rear=next;
            }
            else {
                if(rear.value>=next.value){
                    rear.sibling=next.sibling;
                    rear=rear.mergeTree(next);

                }
                else{
                    if(prev==null){
                        head=next;
                    }else{
                        prev.sibling=next;
                    }
                    rear=next.mergeTree(rear);
                }
            }
            next=rear.sibling;






        }



    }

    /*public int findMax(){
        return head.findMx().value;
    }*/

    public binomialTree extractMax(){



        binomialTree  mx=head.findMx();
        //System.out.println("fo");
        binomialTree rear=head;
        binomialTree prev=null;
        binomialTree tmp;
        if(rear==null){
            return new binomialTree(-1);
        }

        while (rear.value!=mx.value){
            prev=rear;
            rear=rear.sibling;
        }
        //System.out.println("en");
        if(prev==null){
            head=rear.sibling;
        }else {
            prev.sibling=rear.sibling;
        }
        rear=rear.child;
        tmp=rear;
        while(rear!=null){
            rear.parent=null;
            rear=rear.sibling;
        }
        //System.out.println("en2");

        if(head==null){
            if(tmp!=null){
                binomialTree h=tmp.reverse(null);
                head=h;
            }
        }else{
            if(tmp!=null){
                binomialTree h=tmp.reverse(null);
                union(h);
            }
        }


        //System.out.println(mx.value);
        return mx;

    }

    public void increase(int k1,int k2){
        binomialTree rear=head.findNode(k1);
        //System.out.println(rear.value);
        if(rear==null){
            return;
        }
        rear.value=k2;

        while(rear.parent!=null){
            if(rear.value>=rear.parent.value){
                rear.value=rear.parent.value;
                rear.parent.value=k2;
                rear=rear.parent;
            }
            else {
                return;
            }
        }

    }
    public void displayHeap2() {
        System.out.print("\nHeap : ");
        displayHeapNode(head);
        System.out.println("\n");
    }/*

    private void displayHeap(binomialTree r) {
        if (r != null) {
            displayHeap(r.child);
            System.out.print(r.value + " ");
            displayHeap(r.sibling);
        }
    }*/
    void displayHeapNode(binomialTree node){
        binomialTree temp = node;

        if(temp != null){
            displayHeapNode(temp.child);
            System.out.print(temp.value + " ");
            displayHeapNode(temp.sibling);
        }
    }

    public void displayHeap(){
        binomialTree root=head;
        //System.out.println(root.value);
        //return;
        int t=1;
        while(root!=null){

            int l=0;
            System.out.println("tree "+root.degree);
            System.out.println("lvl "+l+"  "+root.value);
            Queue<binomialTree> q=new LinkedList<>();
            if(root.child==null){
                continue;
            }
            else{
                q.add(root.child);
                while(!q.isEmpty()){
                    l++;
                    binomialTree ch=q.poll();
                    System.out.print("lvl "+l);
                    while(ch!=null){
                        System.out.print("  "+ch.value);
                        if(ch.child!=null){
                            q.add(ch.child);
                        }

                        ch=ch.sibling;
                    }
                    System.out.println();
                }

            }


            System.out.println();
            root=root.sibling;
            t++;
            if(root==null){
                System.out.println("fn------------------");
                return;
            }

        }



    }

    public static void main(String[] args) {
        File file=new File("F:\\2-2\\cse208\\src\\offline6\\inpt.txt");

        Scanner sc= null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        binomialHeap heap =new binomialHeap();

        while(sc.hasNextLine()){
            String s=sc.nextLine();
            //System.out.println(s);
            String []sa=s.split(" ");
            if(sa[0].equalsIgnoreCase("INS")){
                int x=Integer.parseInt(sa[1]);
                heap.insert(new binomialTree(x));
                System.out.println("inserted "+x);

            }
            if(sa[0].equalsIgnoreCase("INC")){
                int x=Integer.parseInt(sa[1]);
                int y=Integer.parseInt(sa[2]);
                heap.increase(x,y);
                System.out.println("Increased "+x+" to "+y);

            }
            if(sa[0].equalsIgnoreCase("PRI")){
                heap.displayHeap();
                //heap.displayHeap2();

            }
            if(sa[0].equalsIgnoreCase("FIN")){
                System.out.println("maximum "+heap.head.findMx().value);

            }
            if(sa[0].equalsIgnoreCase("EXT")){
                binomialTree n=heap.extractMax();
                System.out.println("extracting mx "+n.value);

            }
            //System.out.println(sa[0]+">"+sa[1]);

        }
        /*binomialHeap heap =new binomialHeap();

        heap.insert(new binomialTree(7));
        //System.out.println("jha");
        heap.insert(new binomialTree(12));

        //System.out.println("jha");
        heap.insert(new binomialTree(19));
        //System.out.println("jha");
        heap.insert(new binomialTree(5));
        //System.out.println("jha");
        heap.insert(new binomialTree(16));
        heap.insert(new binomialTree(6));
        heap.increase(7,27);
        System.out.println(heap.head.findMx().value);
        heap.extractMax();
        heap.extractMax();
        //System.out.println("hhh");
        heap.displayHeap();*/


    }



}
