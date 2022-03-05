package offline5;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class separateChaining {
    int n;
    Hash h;
    LinkedList<pair> list1[];
    LinkedList<pair> list2[];
    separateChaining(int n){
        this.n=n;
        h=new Hash(n);
        list1=new LinkedList[n];
        list2=new LinkedList[n];
        for(int i=0;i<n;i++){
            list1[i]=new LinkedList<>();
            list2[i]=new LinkedList<>();
        }
    }
    int v1=1;
    int v2=1;

    int searchprobeC1(String key){
        int k=h.h1(key);
        int p1=0;
        for(pair p:list1[k]){
            if(p.key.equalsIgnoreCase(key)){
                return p1;
            }
            p1++;
        }
        return p1;

    }
    int searchprobeC2(String key){
        int k=h.h2(key);
        int p2=0;
        for(pair p:list2[k]){
            if(p.key.equalsIgnoreCase(key)){
                return p2;
            }
            p2++;
        }
        return p2;

    }



    boolean search1(String key){
        int k=h.h1(key);
        for(pair p:list1[k]){
            if(p.key.equalsIgnoreCase(key)){
                return true;
            }
        }
        return false;

    }

    boolean search2(String key){
        int k=h.h2(key);
        for(pair p:list2[k]){
            if(p.key.equalsIgnoreCase(key)){
                return true;
            }
        }
        return false;

    }

    int  insert1(String key){
        if(search1(key))
            return 0;
        else
        {
            int c=0;
            int k=h.h1(key);
            if(list1[k].size()>0){
                c=1;
            }
            list1[k].add(new pair(key,v1));
            v1++;
            //System.out.println("sz  "+list1[k].size());
            //return list1[k].size()-1;
            return c;

        }


    }
    int  insert2(String key){
        if(search2(key))
            return 0;
        else
        {
            int c=0;
            int k=h.h2(key);
            if(list2[k].size()>0){
                c=1;
            }
            list2[k].add(new pair(key,v2));
            v2++;


            //return list2[k].size()-1;
            return c;

        }


    }
    void delete1(String key){
        int k=h.h1(key);
        for(pair P:list1[k]){
            if(P.key.equalsIgnoreCase(key))
                list1[k].remove(P);
        }
    }
    void delete2(String key){
        int k=h.h2(key);
        for(pair P:list1[k]){
            if(P.key.equalsIgnoreCase(key))
                list1[k].remove(P);
        }
    }

    void show1(){
        for(int i=0;i<n;i++){
            for(pair p:list1[i]){
                System.out.print(p.key+":"+p.value+ "  ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Random rnd=new Random();
        Random rn=new Random();
        separateChaining cH=new separateChaining(n);
        int col1=0;
        int col2=0;

        String rw1[]=new String[1000];
        String rw2[]=new String[1000];
        int rwin=0;
        while(true){
            String key="";
            for(int j=0;j<7;j++){
                int r=rnd.nextInt(25)+'a';
                key+=(char)r;
            }

            col2+=cH.insert2(key);
            col1+= cH.insert1(key);
            if(rwin<1000){
                int rx=rn.nextInt(500);
                if(rx>250){
                    rw1[rwin]=new String(key);
                    rw2[rwin]=new String(key);
                    rwin++;
                }

            }
            //System.out.println(col1);
            if(cH.v1>10000){
                break;
            }
        }

        System.out.println(" col "+col1+" avg"+(double)col1/10000);
        System.out.println(" col "+col2+" avg"+(double)col2/10000);
        //cH.show1();
        int p1=0;
        int p2=0;
        for(int i=0;i<1000;i++){
            p1+=cH.searchprobeC1(rw1[i]);
            p2+=cH.searchprobeC2(rw2[i]);
        }
        System.out.println(p1+"  "+p2);

    }
    


}
