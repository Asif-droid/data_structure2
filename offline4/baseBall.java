package offline4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baseBall {



    static class team{
        LinkedList<Integer> matchList;
        team(){
            matchList=new LinkedList<>();
        }
        void addMatch(int n){
            matchList.add(n);
        }
        boolean played(int i){
            return matchList.contains(i);
        }
    }


    public static void main(String[] args) {
        File file=new File("F:\\2-2\\cse208\\src\\offline4\\teams.txt");

        Scanner sc= null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        int v=sc.nextInt();
        int losing[]=new int[v];
        String teamName[]=new String[v];
        int g[][]=new int[v][v];
        sc.nextLine();
        int win[]=new int[v];
        int r[]=new int[v];

        for(int i=0;i<v;i++){
            String s=sc.nextLine();
            //System.out.println(s);
            String[] subs=s.split(" ");
            //System.out.println(subs[0]);
            //System.out.println(subs[1]+subs[3]+subs[4]+subs[5]+subs[6]+subs[7]);
            teamName[i]=subs[0];
            win[i]=Integer.parseInt(subs[1]);
            r[i]=Integer.parseInt(subs[3]);
            for(int j=0;j<v;j++){
                g[i][j]=Integer.parseInt(subs[4+j]);
            }

            losing[i]=-1;

        }


        /*
        0=at
        1=phil
        2=ny
        3=mon
        s->0
        1=0-1
        2=0-2
        3=0-3
        4=1-2
        5=1-3
        6=2-3
        7=0
        8=1
        9=2
        10=3
         */



        int net_cap=2+v+v*(v-1)/2;
        int game=v*(v-1)/2;
        maximumFLow mx=new maximumFLow();
        for(int i=0;i<v;i++){
            int [][]net=new int[net_cap][net_cap];
            /*net[0][1]=g[0][1];
            net[0][2]=g[0][2];
            net[0][3]=g[0][3];
            net[0][4]=g[1][2];
            net[0][5]=g[1][3];
            net[0][6]=g[2][3];
*/          int mat_ind=1;

            while(mat_ind<=(v*(v-1)/2)){
                for(int k=0;k<v;k++){
                    int ns=0;
                    for(int l=0;l<v;l++){
                        if(l>k){
                            net[0][mat_ind++]=g[k][l];
                            //ns+=g[k][l];
                            //System.out.println(net[0][j]);
                        }

                    }

                }
            }



            //System.out.println(s);
            int max=10000;
            /*net[1][7]=max;
            net[1][8]=max;
            net[2][7]=max;
            net[2][9]=max;
            net[3][7]=max;
            net[3][10]=max;
            net[4][8]=max;
            net[4][9]=max;
            net[5][10]=max;
            net[5][8]=max;
            net[6][9]=max;
            net[6][10]=max;*/
            int t=game;
            for(int j=1;j<game;){

                for(int m=v-1;m>0;m--){
                    t++;
                    int n=1;
                    for(int k=m;k>0;k--){
                        net[j][t]=max;
                        net[j][t+n]=max;
                        n++;
                        j++;
                    }

                }

            }
            int s=0;

            for(int j=1;j<=game;j++){
                s+=net[0][j];


            }
            //s-=neg_sum[i-1];
            for(int j=game+1;j<net_cap-1;j++){
                if(i+game+1==j){
                    net[j][net_cap-1]=win[i]+r[i];


                }
                else {
                    net[j][net_cap-1]=win[i]+r[i]-win[j-game-1];
                }
            }
            /*
            /*for(int k=0;k<12;k++){
                for(int l=0;l<12;l++){
                    System.out.print(net[k][l]+" ");
                }
                System.out.println();
            }
            System.out.println("end");
*/


            if(mx.fordFulkerson(net,0,net_cap-1)<s){
                System.out.println(teamName[i]+" is eliminated ");
                //System.out.println(win[i]+r[i]);

                losing[i]=1;





            }

        }

        /*for(int i=0;i<v;i++){
            if(losing[i]==1){
                System.out.println(teamName[i]+" is eliminated");
                int ws=0;
                Queue<Integer> q=new LinkedList<>();
                for(int j=0;j<v;j++){
                    if(losing[j]==1)
                        continue;


                    if(win[j]>win[i]+r[i]){
                        int z=win[i]+r[i];
                        System.out.println("they can win "+z);
                        System.out.println(teamName[j]+" has won "+win[j]);
                    }

                    ws+=win[j];
                    q.add(j);










                }
            }
        }


        /*for(int i=0;i<12;i++){
            for(int j=0;j<12;j++){
                System.out.print(net[i][j]+" ");
            }
            System.out.println();
        }*/


    }
}
