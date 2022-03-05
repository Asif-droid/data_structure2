package test1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class graphSkeleton {

    File gFile;
    Scanner fileReader;

    public graphSkeleton(String s){
        gFile=new File(s);
        try {
            fileReader=new Scanner(gFile);
            System.out.println("good");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public graphAdjMat createGraphMat(){
        graphAdjMat graph;
        int v;

        String s1=fileReader.nextLine();
        v=Integer.parseInt(s1);
        graph=new graphAdjMat(v);

        String s2=fileReader.nextLine();
        String s[]=s2.split(",");
        for(int i=0;i<s.length;i++){
            String finalS[]=s[i].split("-");
            int source=Integer.parseInt(finalS[0]);
            int des=Integer.parseInt(finalS[1]);
            graph.addEdge(source,des);

        }


        return graph;
    }
    public graphAdjList createGraphList(){
        graphAdjList graph;
        int v;

        String s1=fileReader.nextLine();
        v=Integer.parseInt(s1);
        graph=new graphAdjList(v);
        String s2=fileReader.nextLine();
        String s[]=s2.split(",");
        for(int i=0;i<s.length;i++){
            String finalS[]=s[i].split("-");
            int source=Integer.parseInt(finalS[0]);
            int des=Integer.parseInt(finalS[1]);
            graph.addEdge(source,des); //one directional
            //graph.addEdgeBi(source,des); //bi directional

        }



        return graph;
    }


}
