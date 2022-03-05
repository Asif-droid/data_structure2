import java.util.Stack;

public class test {

    public static void main(String[] args) {
        //graphSkeleton gS=new graphSkeleton("test.txt");

        //graphAdjList grph= gS.createGraphList();

        //System.out.println(grph.dfs(1,5));
        //grph.topologicalSort();
        String [] words={"baa","abcd","abca","cab","cad"};

        graphAdjList g=new graphAdjList(4);

        for(int i=0;i<words.length-1;i++){

            String w1=words[i];
            String w2=words[i+1];

            for(int j=0;j< Math.min(w1.length(),w2.length());j++){
                if(w1.charAt(j)!=w2.charAt(j)){
                    g.addEdge(w1.charAt(j)-'a',w2.charAt(j)-'a');
                    break;
                }
            }

        }
        g.topologicalSort();





    }

}
