import java.util.*;
import java.lang.*;
public class DFS_BIPARTITE {

        static int V;
        int[] color;

        DFS_BIPARTITE(int vertexSize){
            this.V = vertexSize;
            this.color =  new int[vertexSize];
        }



        public static void main(String[] args){
            DFS_BIPARTITE bipartiteG1 = new DFS_BIPARTITE(12);
            DFS_BIPARTITE bipartiteG2 = new DFS_BIPARTITE(10);

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

            System.out.println("//////////////////////// DFS(G) RESULTS //////////////////");

            System.out.println("\n");
            if (bipartiteG1.isBipartite(G1)) {
                System.out.print("\nG1 is Bipartite\n");
                for(int i=0; i<bipartiteG1.color.length; i++){
                    String color = null;
                    if(bipartiteG1.color[i]==1){
                        color = "blue";
                    }
                    else{
                        color = "red";
                    }
                    System.out.print(vertex[i] + "(" + color + "), " );
                }
//                System.out.println("\n" + Arrays.toString(bipartiteG1.color));
            }
            else {
                System.out.print("\nG1 is not Bipartite\n");
                for (int i = 0; i < bipartiteG1.color.length; i++) {
                    String color = null;
                    if (bipartiteG1.color[i] == 1 || bipartiteG1.color[i] == 0) {
                        color = "gray";
                        System.out.print(vertex[i] + "(" + color + "), ");
                    }


                }
//                System.out.println("\n" + Arrays.toString(bipartiteG1.color));
            }

            System.out.println("\n");
            if (bipartiteG2.isBipartite(G2)) {
                System.out.print("\nG2 is Bipartite\n");
                for(int i=0; i<bipartiteG2.color.length; i++){
                    String color = null;
                    if(bipartiteG2.color[i]==1){
                        color = "blue";
                    }
                    else{
                        color = "red";
                    }
                    System.out.print(vertex[i] + "(" + color + "), " );
                }
//                System.out.println("\n" + Arrays.toString(bipartiteG2.color));
            }
            else {
                System.out.print("\nG2 is not Bipartite\n");
                for (int i = 0; i < bipartiteG2.color.length; i++) {
                    String color = null;
                    if (bipartiteG2.color[i] == 1 || bipartiteG2.color[i] == 0) {
                        color = "gray";
                        System.out.print(vertex[i] + "(" + color + "), ");
                    }

                }
//                System.out.println("\n" + Arrays.toString(bipartiteG2.color));
            }
        }

        static boolean colorGraph(int G[][], int color[], int state, int c){
            if (color[state] != -1 && color[state] != c)
                return false;

            // color this state as c and
            // all its neighbours as 1-c
            color[state] = c;
            boolean ans = true;
            for (int i = 0; i < V; i++){
                if (G[state][i] == 1)
                {
                    if (color[i] == -1)
                        ans &= colorGraph(G, color, i, 1 - c);

                    if (color[i] != -1 && color[i] != 1 - c)
                        return false;
                }
                if (!ans)
                    return false;
            }

            return true;
        }

        boolean isBipartite(int G[][]){

            for (int i = 0; i < V; i++)
                color[i] = -1;

//            System.out.println("\n asdfasdafsdfasdasd" + Arrays.toString(color));

            // start is vertex 0;
            int state = 0;

            // two colors 1 and 0
            return colorGraph(G, color, state, 1);
        }



}
