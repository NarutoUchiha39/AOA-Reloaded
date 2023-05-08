import java.util.Arrays;

public class ForwardApproachGraphs
{

    public static void check_forward(int[][]graph,int vertices)
    {
        int[]cost  = new int[vertices];
        int[]dist = new int[vertices];
        Arrays.fill(cost,0);
        Arrays.fill(dist,0);

        for (int i = vertices-1; i>=0; i--) {
            int min = Integer.MAX_VALUE;
            for (int j = i+1; j <vertices; j++) {
                if(graph[i][j]!=Integer.MAX_VALUE && graph[i][j]+cost[j]<min){
                    min = graph[i][j]+cost[j];
                    dist[i] =j;
                }
            }
            if(min!=Integer.MAX_VALUE) {
                cost[i] = min;
            }
        }

        System.out.println("Minimum cost is : "+cost[0]);
        System.out.println("Distance Array is: "+Arrays.toString(dist));
        int[]path = new int[vertices];
        int i =0;
        while(i!=vertices-1) {
            path[i] = dist[i];
            i = dist[i];
        }

        System.out.println("Minimum path is ");
        for (int k : path) {
            if (k != 0) {
                System.out.print(k + " ");
            }
        }
    }
    public static void main(String[] args) {
//        System.out.println("Enter number of vertices: ");
//        Scanner sc = new Scanner(System.in);
//
//        int vertices = sc.nextInt();
//        int[][]graph = new int[vertices-1][];// No need to store last row
//        for (int i = 0; i < vertices-1; i++) { // Vertices -1 cause last row we are not keeping as full infinity since its not connected to anything
//            for (int j = 0; j < vertices; j++) {
//                System.out.println("Enter weight between "+i+" "+j+" give 0 for no connection");
//                graph[i][j] = sc.nextInt();
//            }
//        }
        int INF = Integer.MAX_VALUE;
        int[][] graph1 = new int[][] {
                { INF, 1, 2, 5, INF, INF, INF, INF },
                { INF, INF, INF, INF, 4, 11, INF, INF },
                { INF, INF, INF, INF, 9, 5, 16, INF },
                { INF, INF, INF, INF, INF, INF, 2, INF },
                { INF, INF, INF, INF, INF, INF, INF, 18 },
                { INF, INF, INF, INF, INF, INF, INF, 13 },
                { INF, INF, INF, INF, INF, INF, INF, 2 }
        };
        check_forward(graph1,8);

    }
}
