//PURPOSE OF PROGRAM: This program checks if a graph is bipartite. It uses two different algorithms to confirm if a graph is Bi-partite or not.
// The two algorithms used here are BFS (Breadth First Search) and DFS (Depth First Search) to assess if an input graph is Bi-partite.

//PROGRAMMER:   OSABHIE EBENEZER FERGUSON;
//COURSE NUMBER: CSCI 7432
//PROGRAMMING ASSIGNMENT NO.: 3;
//DATE: MARCH 15TH 2022;



import java.util.Arrays;
public class createMatrix {
    int vertices; //number of vertices or nodes
    int [][] adjMatrix ; //adjacent matrix

    createMatrix(int numberOfVertices){
        this.vertices = numberOfVertices;
        this.adjMatrix = new int[numberOfVertices][numberOfVertices];
    }


    int a = 0;
    int b = 1;
    int c = 2;
    int d = 3;
    int e = 4;
    int f = 5;
    int g = 6;
    int h = 7;
    int i = 8;
    int j = 9;
    int k = 10;
    int l = 11;

    public static void main(String[] args) {
        createMatrix matrix1 = new createMatrix(12);
        createMatrix matrix2 = new createMatrix(10);
        matrix1.G1();
        matrix2.G2();

    }


    public void addEdges(int u, int v){
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1;
    }

    public void G1(){

        addEdges(a,h);
        addEdges(a,i);
        addEdges(b,h);
        addEdges(b,f);
        addEdges(c,f);
        addEdges(c,g);
        addEdges(d,g);
        addEdges(d,l);
        addEdges(e,k);
        addEdges(e,l);
        addEdges(f,j);
        addEdges(f,i);
        addEdges(g,j);
        addEdges(g,k);

        System.out.println("\n*********************ADJACENCY Matrix for Graph G1***************************");

        System.out.println("\n2-DIMENSIONAL ARRAY REPRESENTATION\n");
        System.out.println(Arrays.deepToString(adjMatrix) + "\n");

        System.out.println("\n2-CONVENTIONAL ARRAY REPRESENTATION\n");
        for (int[] a : adjMatrix) {
            System.out.print("{");
            for (int i : a) {
                System.out.print(i + ",\t");
            }
            System.out.println("},\n");
        }
    }

    public void G2(){


        addEdges(a,c);
        addEdges(a,g);
        addEdges(a,j);
        addEdges(a,f);
        addEdges(b,e);
        addEdges(b,i);
        addEdges(b,h);
        addEdges(b,d);
        addEdges(c,i);
        addEdges(c,h);
        addEdges(c,d);
        addEdges(d,g);
        addEdges(d,j);
        addEdges(e,g);
        addEdges(e,j);
        addEdges(e,f);
        addEdges(f,i);
        addEdges(f,h);
        addEdges(g,h);
        addEdges(i,j);

        System.out.println("\n*********************ADJACENCY Matrix for Graph G2 ***************************");

        System.out.println("\n2-DIMENSIONAL ARRAY REPRESENTATION\n");
        System.out.println(Arrays.deepToString(adjMatrix) + "\n");

        System.out.println("\n2-CONVENTIONAL ARRAY REPRESENTATION\n");
        for (int[] a :adjMatrix) {
            System.out.print("{");
            for (int i : a) {
                System.out.print(i + ",\t");
            }
            System.out.println("},\n");
        }
    }


}
