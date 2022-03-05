package offline5;

import java.util.Random;
import java.util.Scanner;

public class customProbing {
    int n;
    pair ht1[];
    pair ht2[];
    Hash h;

    customProbing(int n){
        this.n=n;
        ht1=new pair[n];
        ht2=new pair[n];
        h=new Hash(n);

    }
    int v1=1;
    int v2=1;
    int c1=7;
    int c2=11;

    int search1(String key){

        int ah=h.auxh(key);
        int hh;
        for(int i=0;i<n;i++){
            hh=(h.h1(key)+i*ah*c1+i*i*c2)%n;
            if(ht1[hh]==null){
                return -1;

            }
            if(ht1[hh].key.equalsIgnoreCase(key)){
                return i;

            }

            if(i+1==n)
                return -1;

        }

        return -1;

    }
    int search2(String key){

        int ah=h.auxh(key);
        int hh;
        for(int i=0;i<n;i++){
            hh=(h.h2(key)+i*ah*c1+i*i*c2)%n;
            if(ht2[hh]==null){
                return -1;

            }
            if(ht2[hh].key.equalsIgnoreCase(key)){
                return i;

            }

            if(i+1==n)
                return -1;

        }

        return -1;

    }

    void delete1(String key){
        int ah=h.auxh(key);
        int hh;
        for(int i=0;i<n;i++){
            hh=(h.h1(key)+i*ah*c1+i*i*c2)%n;
            if(ht2[hh]==null){
                return ;

            }

            if(ht1[hh].key.equalsIgnoreCase(key)){
                ht1[hh]=new pair("tmbstn",-1);

            }



        }



    }
    void delete2(String key){
        int ah=h.auxh(key);
        int hh;
        for(int i=0;i<n;i++){
            hh=(h.h2(key)+i*ah*c1+i*i*c2)%n;

            if(ht2[hh]==null){
                return ;

            }

            if(ht2[hh].key.equalsIgnoreCase(key)){
                ht2[hh]=new pair("tmbstn",-1);

            }



        }



    }

    int insert1(String key){
        if(search1(key)!=-1)
            return 0;
        else
        {
            int ah=h.auxh(key);
            int col=0;
            int hh;

            while(true){
                hh=(h.h1(key)+col*ah*c1+col*col*c2)%n;
                if(ht1[hh]==null||ht1[hh].key.equalsIgnoreCase("tmbstn")){

                    break;
                }
                if(col==n)
                    break;

                col++;

            }
            if(col<n){
                ht1[hh]=new pair(key,v1);
                v1++;
                return col;
            }

            return 0;

        }
    }
    int insert2(String key){
        if(search2(key)!=-1)
            return 0;
        else
        {
            int ah=h.auxh(key);
            int col=0;
            int hh;

            while(true){
                hh=(h.h2(key)+col*ah*c1+col*col*c2)%n;
                if(ht2[hh]==null||ht2[hh].key.equalsIgnoreCase("tmbstn")){

                    break;
                }
                if(col==n)
                    break;

                col++;

            }
            if(col<n){
                ht2[hh]=new pair(key,v2);
                v2++;
                return col;
            }

            return 0;

        }
    }
    void show1(){
        for(int i=0;i<n;i++){
            if(ht1[i]!=null)
                System.out.println(ht1[i].key+" "+ht1[i].value);
        }
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Random rnd=new Random();
        Random rn=new Random();
        customProbing cpH=new customProbing(n);
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
            //col2+=cH.insert2(key);
            col1+= cpH.insert1(key);
            col2+=cpH.insert2(key);


            if(rwin<1000){
                int rx=rn.nextInt(500);
                if(rx%2==0){
                    rw1[rwin]=new String(key);
                    rw2[rwin]=new String(key);
                    rwin++;
                }

            }
            //System.out.println(col1);
            if(cpH.v1>10000){
                break;
            }
        }
        //dH.show1();

        System.out.println(" col "+col1+" avg"+(double)col1/10000);
        System.out.println(" col "+col2+" avg"+(double)col2/10000);
        int p1=0;
        int p2=0;
        for(int i=0;i<1000;i++){
            p1+=cpH.search1(rw1[i]);
            p2+=cpH.search2(rw2[i]);
        }
        System.out.println(p1+"  "+p2);

    }

}
