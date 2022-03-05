package online1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class main {
    public static void main(String[] args) throws FileNotFoundException {
        File file=new File("F:\\2-2\\cse208\\src\\online1\\test.txt");

        Scanner scanner= null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int v=scanner.nextInt();
        int e=scanner.nextInt();

        KruskalAlgo.graph gk=new KruskalAlgo.graph(v,e);
        PrimsAlgoList.graph gp=new PrimsAlgoList.graph(v);


        for(int i=0;i<e;i++){
            int s=scanner.nextInt();
            int d=scanner.nextInt();
            double w=scanner.nextDouble();
            gk.edges[i].createEdge(s,d,w);
            gp.addEdge(s,d,w);

        }
        System.out.println("Kruskal Algo");
        gk.PrintMst();
        System.out.println("Prim's Algo");
        gp.printMst(0);














    }
}
