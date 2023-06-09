import java.util.Arrays;

public class BackwardMultiStage
{
    public static void sort(int[][]graph,int vertices)
    {
        int[]dist = new int[vertices];
        int[]path = new int[vertices];
        Arrays.fill(dist,0);
        for (int i = 0;i<vertices;i++){
            int min = Integer.MAX_VALUE;
            int index = 0;
            for (int j =0;j<=i-1;j++){
                if(graph[j][i]!=Integer.MAX_VALUE && dist[j]+graph[j][i]<min){
                    min =dist[j]+graph[j][i];
                    path[j] =i;
                }
            }
            if(min!=Integer.MAX_VALUE) {
                dist[i] = min;
            }
        }

        System.out.println("Minimum cost: "+dist[dist.length-1]);
        System.out.println("Distance Array: "+Arrays.toString(path));
    }

    public static void main(String[] args) {
        int INF = Integer.MAX_VALUE;
        int[][] graph1 = new int[][] {
                { INF, 1, 2, 5, INF, INF, INF, INF },
                { INF, INF, INF, INF, 4, 11, INF, INF },
                { INF, INF, INF, INF, 9, 5, 16, INF },
                { INF, INF, INF, INF, INF, INF, 2, INF },
                { INF, INF, INF, INF, INF, INF, INF, 18 },
                { INF, INF, INF, INF, INF, INF, INF, 13 },
                { INF, INF, INF, INF, INF, INF, INF, 2 },

        };

        sort(graph1,8);
    }

}
