package offline6;

public class binomialTree {

    int value;
    int degree;
    binomialTree parent;
    binomialTree sibling;
    //binomialTree r_sibling;
    binomialTree child;

    public binomialTree(int value){
        this.value=value;
        this.degree=0;
        this.parent=null;
        //this.r_sibling=null;
        this.sibling=null;
        this.child=null;
    }

    public binomialTree mergeTree(binomialTree tree){
        binomialTree ch=this.child;
        this.child=tree;
        tree.parent=this;
        tree.sibling=ch;
        //ch.sibling=tree;
        //tree.sibling=ch;
        this.degree++;
        return  this;
    }

    public  binomialTree addTree(binomialTree t){
        //binomialTree tmp = t;

        t.sibling = this.sibling;
        this.sibling = t;

        return this.sibling;
    }

    public  binomialTree findMx(){
        int r=0;
        binomialTree node=new binomialTree(-1);
        binomialTree st=this;
        while(st!=null){
            if(st.value>=r){
                r=st.value;
                node=st;
            }
            st=st.sibling;
        }
        return node;
    }

    public  binomialTree findNode(int value){
        binomialTree tmp=this;
        binomialTree rn=null;


        while (tmp!=null){
            if(tmp.value==value){
                rn=tmp;
                return rn;
            }
            else if(tmp.child==null){
                tmp=tmp.sibling;
            }
            else {
                rn=tmp.child.findNode(value);
                if(rn==null)
                    tmp=tmp.sibling;
                else
                    return rn;
            }
        }

        return rn;
    }

    public binomialTree reverse(binomialTree node){
        binomialTree rT;

        if(sibling !=null){
            rT=sibling.reverse(this);
        }else {
            rT=this;
        }
        sibling=node;
        return rT;

    }

}
