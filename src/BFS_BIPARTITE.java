//PURPOSE OF PROGRAM: This program checks if a graph is bipartite. It uses two different algorithms to confirm if a graph is Bi-partite or not.
// The two algorithms used here are BFS (Breadth First Search) and DFS (Depth First Search) to assess if an input graph is Bi-partite.

//PROGRAMMER:   OSABHIE EBENEZER FERGUSON;
//COURSE NUMBER: CSCI 7432
//PROGRAMMING ASSIGNMENT NO.: 3;
//DATE: MARCH 15TH 2022;

import java.util.*;
import java.lang.*;

class BFS_BIPARTITE{

        int V; // No. of Vertices
        int colorArr[] ;

        BFS_BIPARTITE(int vertexSize){
            this.V = vertexSize;
            this.colorArr = new int[vertexSize];
        }

        public static void main (String[] args) {
            int G1[][] = {
                    {0,	0,	0,	0,	0,	0,	0,	1,	1,	0,	0,	0,	},

                    {0,	0,	0,	0,	0,	1,	0,	1,	0,	0,	0,	0,	},

                    {0,	0,	0,	0,	0,	1,	1,	0,	0,	0,	0,	0,	},

                    {0,	0,	0,	0,	0,	0,	1,	0,	0,	0,	0,	1,	},

                    {0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	1,	1,	},

                    {0,	1,	1,	0,	0,	0,	0,	0,	1,	1,	0,	0,	},

                    {0,	0,	1,	1,	0,	0,	0,	0,	0,	1,	1,	0,	},

                    {1,	1,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	},

                    {1,	0,	0,	0,	0,	1,	0,	0,	0,	0,	0,	0,	},

                    {0,	0,	0,	0,	0,	1,	1,	0,	0,	0,	0,	0,	},

                    {0,	0,	0,	0,	1,	0,	1,	0,	0,	0,	0,	0,	},

                    {0,	0,	0,	1,	1,	0,	0,	0,	0,	0,	0,	0,	},
            };

            int G2[][] = {
                    {0,	0,	1,	0,	0,	1,	1,	0,	0,	1,	},

                    {0,	0,	0,	1,	1,	0,	0,	1,	1,	0,	},

                    {1,	0,	0,	1,	0,	0,	0,	1,	1,	0,	},

                    {0,	1,	1,	0,	0,	0,	1,	0,	0,	1,	},

                    {0,	1,	0,	0,	0,	1,	1,	0,	0,	1,	},

                    {1,	0,	0,	0,	1,	0,	0,	1,	1,	0,	},

                    {1,	0,	0,	1,	1,	0,	0,	1,	0,	0,	},

                    {0,	1,	1,	0,	0,	1,	1,	0,	0,	0,	},

                    {0,	1,	1,	0,	0,	1,	0,	0,	0,	1,	},

                    {1,	0,	0,	1,	1,	0,	0,	0,	1,	0,	},
            };



            String [] vertex = {"a","b","c","d","e","f","g","h","i","j","k","l"};

            BFS_BIPARTITE bipartiteG1 = new BFS_BIPARTITE(12);
            BFS_BIPARTITE bipartiteG2 = new BFS_BIPARTITE(10);

            System.out.println("//////////////////////// BFS(G) RESULTS //////////////////");

            if (bipartiteG1.isBipartite(G1, 0)){
                System.out.println("\nGraph G1 is bipartite");
                for(int i=0; i<bipartiteG1.colorArr.length; i++){
                    String color = null;
                    if(bipartiteG1.colorArr[i]==1){
                        color = "blue";
                    }
                    else{
                        color = "red";
                    }
                    System.out.print(vertex[i] + "(" + color + "), " );
                }

//                System.out.println(Arrays.toString(bipartite.colorArr));
            }
            else {
                System.out.println("\nGraph G1 is NOT bipartite");
                for (int i = 0; i < bipartiteG1.colorArr.length; i++) {
                    String color = null;
                    if (bipartiteG1.colorArr[i] == 1 || bipartiteG1.colorArr[i] == 0) {
                        color = "gray";
                        System.out.print(vertex[i] + "(" + color + "), ");
                    }


                }
//
//                System.out.println(Arrays.toString(bipartite.colorArr));
            }

            System.out.println("\n");

            if (bipartiteG2.isBipartite(G2, 0)){
                System.out.println("\nGraph G2 is bipartite");
                for(int i=0; i<bipartiteG2.colorArr.length; i++){
                    String color = null;
                    if(bipartiteG2.colorArr[i]==1){
                        color = "blue";
                    }
                    else{
                        color = "red";
                    }
                    System.out.print(vertex[i] + "(" + color + "), " );
                }

//                System.out.println(Arrays.toString(bipartite.colorArr));
            }
            else {
                System.out.println("\n Graph G2 is NOT bipartite");
                for (int i = 0; i < bipartiteG2.colorArr.length; i++) {
                    String color = null;
                    if (bipartiteG2.colorArr[i] == 1 || bipartiteG2.colorArr[i] == 0) {
                        color = "gray";
                        System.out.print(vertex[i] + "(" + color + "), ");
                    }

                }
//
//                System.out.println(Arrays.toString(bipartite.colorArr));
            }


        }



        boolean isBipartite(int G[][],int src)
        {
            for (int i=0; i<V; ++i)
                colorArr[i] = -1;


            colorArr[src] = 1;

            LinkedList<Integer>q = new LinkedList<Integer>();
            q.add(src);

            while (q.size() != 0)
            {
                // Dequeue first vertex in queue
                int u = q.poll();

                for (int v=0; v<V; ++v){
                    if (G[u][v]==1 && colorArr[v]==-1){
                        colorArr[v] = 1-colorArr[u];
                        q.add(v);
                    }

                    else if (G[u][v]==1 && colorArr[v]==colorArr[u])
                        return false;
                }
            }

            return true;
        }


    }

