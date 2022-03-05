package offline7;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class avlTree {
    class  node{
        int key;
        int height;
        node left;
        node right;
        node parent;
        node(int key){
            this.key=key;
            this.height=1;      ///change
            left=null;
            right=null;
            parent=null;
        }

        public int getHeight() {
            return height;
        }

    }



    node root;
    int nodeHeight(node n){
        if(n==null){
            return 0;
        }
        else
            return n.getHeight();
    }

    int getMax(int x,int y){
        if(x>y)
            return x;
        else
            return y;
    }

    node rightRotate(node y){
        node p=y.parent;
        node x=y.left;
        node t2=y.left.right;
        x.right=y;
        y.left=t2;
        x.parent=p;
        y.parent=x;

        y.height=getMax(nodeHeight(y.left),nodeHeight(y.right))+1;
        x.height=getMax(nodeHeight(x.left),nodeHeight(x.right))+1;
        return x;


    }
    node leftRotate(node y){
        node p=y.parent;
        node x=y.right;
        node t2=y.right.left;
        x.left=y;
        y.right=t2;
        x.parent=p;
        y.parent=x;

        y.height=getMax(nodeHeight(y.left),nodeHeight(y.right))+1;
        x.height=getMax(nodeHeight(x.left),nodeHeight(x.right))+1;
        return x;


    }
     void insert(int k){
        root=insert(root,k);
        print();

     }
    node insert(node n,int key){
        if(n==null){
            n=new node(key);
            return n;
        }

        if(key<n.key){
            n.left=insert(n.left,key);
        }
        else if(key>n.key){
            n.right=insert(n.right,key);
        }
        else
            return n;
        n.height=getMax(nodeHeight(n.left),nodeHeight(n.right))+1;
        int balance=nodeHeight(n.left)-nodeHeight(n.right);

        if(balance>1){
            System.out.println("Height invariant violated");
            System.out.println("After rebalancing: ");
            if(key<n.left.key){
                return rightRotate(n);
            }
            else{
                n.left=leftRotate(n.left);
                return rightRotate(n);
            }

        }else if(balance<-1){
            System.out.println("Height invariant violated");
            System.out.println("After rebalancing: ");
            if(key>n.right.key){
                return leftRotate(n);
            }
            else{
                n.right=rightRotate(n.right);
                return leftRotate(n);
            }
        }
        return  n;


     }

     boolean findKey(int k){
        node current =root;
        node r=find(current,k);
        if(r==null)
            return false;
        else
            return true;

     }
     node find(node n,int key){
        if(n==null){
            return n;
        }
        if(n.key==key){
            return n;
        }
        else if(key>n.key){
            return find(n.right,key);
        }
        else if(key<n.key){
            return find(n.left,key);
        }
        else
            return null;
     }

     node getMinimum(node n){
        if(n.left==null){
            return n;
        }
        else{
            return getMinimum(n.left);
        }
     }

     void delete(int key){
        node current=root;
        root=delete(current,key);
        print();

     }
     node delete(node n,int key){
        if(n==null){
            return n;
        }
        if(key>n.key){
            n.right= delete(n.right,key);
        }
        else if(key<n.key){
            n.left = delete(n.left,key);
        }
        else{
            //System.out.println(n.key);
            if(n.right==null||n.left==null){
                if(n.left==null){
                    node temp=n.right;
                    n=temp;
                    //System.out.println(n.key);

                }
                else if(n.right==null){
                    node temp=n.left;
                    n=temp;
                    //System.out.println(n.key);
                }
            }
            else{
                node minNode=getMinimum(n.right);
                int minKey=minNode.key;
                n.key=minKey;
                n.right=delete(n.right,minKey);

            }

        }


        if(n==null)
            return n;

        n.height=getMax(nodeHeight(n.left),nodeHeight(n.right))+1;
        int balance=nodeHeight(n.left)-nodeHeight(n.right);
        if(balance>1){
            System.out.println("Height invariant violated");
            System.out.println("After rebalancing: ");
            int blnL=nodeHeight(n.left.left)-nodeHeight(n.left.right);
            if (blnL >= 0) {
                return rightRotate(n);
            } else {
                n.left = leftRotate(n.left);
                return rightRotate(n);
            }

        }
        else if(balance<-1){
            System.out.println("Height invariant violated");
            System.out.println("After rebalancing: ");
            int blnR=nodeHeight(n.right.left)-nodeHeight(n.right.right);
            if (blnR <= 0) {
                return leftRotate(n);
            } else {
                n.right = rightRotate(n.right);
                return leftRotate(n);
            }

        }
        return n;
     }



     void print(){
        node current=root;
        print(current);
         System.out.println();

     }
     void print(node n){
        if(n!=null){
            System.out.print(n.key);
            //System.out.print("(");
            if(n.left!=null || n.right!=null){
                System.out.print("(");
                print(n.left);
                System.out.print(")");
                System.out.print("(");
                print(n.right);
                System.out.print(")");
            }

            //System.out.print(")");
        }
     }


    public static void main(String[] args) {
        avlTree tree= new avlTree();
        /*System.out.println(tree.findKey(5));
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.delete(5);
        tree.delete(6);
        tree.insert(0);
        //tree.print();*/
        File file=new File("F:\\2-2\\cse208\\src\\offline7\\in27.txt");

        Scanner sc= null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (sc.hasNextLine()){
            String s=sc.nextLine();
            String [] sa=s.split(" ");
            int key=Integer.parseInt(sa[1]);
            if(sa[0].equalsIgnoreCase("I")){
                tree.insert(key);
            }else if(sa[0].equalsIgnoreCase("D")){
                tree.delete(key);
            }else if(sa[0].equalsIgnoreCase("F")){
                System.out.println(tree.findKey(key));
            }
        }





    }


}
