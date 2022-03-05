package test1;


public class graphAdjMat {


    private int adjMat[][];
    public graphAdjMat(int v){
        adjMat=new int[v][v];
        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                adjMat[i][j]=0;
            }
        }
    }
    //source in row and destination in column

    public void addEdge(int s,int d){       //one directional edge
        adjMat[s][d]=1;

    }

    public void addEdgeBi(int s,int d){     //bidirectional edge
        adjMat[s][d]=1;
        adjMat[d][s]=1;
    }
    public boolean Edge (int s,int d){
        if(adjMat[s][d]==1)
            return true;
        else
            return false;
    }

}
