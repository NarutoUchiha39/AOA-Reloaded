import java.util.Arrays;

public class ForwardMultiStage
{
    public static void sort(int[][]graph,int vertices)
    {
        int[]dist = new int[vertices];
        int[]path = new int[vertices];
        Arrays.fill(dist,0);
        for (int i = vertices-1;i>=0;i--){
            int min = Integer.MAX_VALUE;
            int index = 0;
            for (int j =i+1;j< vertices;j++){
                if(graph[i][j]!=Integer.MAX_VALUE && dist[j]+graph[i][j]<min){
                    min =dist[j]+graph[i][j];
                    index = j;
                }
            }
            if(min!=Integer.MAX_VALUE) {
                dist[i] = min;
                path[i] = index;
            }
        }

        System.out.println("Minimum cost: "+dist[0]);
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
                { INF, INF, INF, INF, INF, INF, INF, 2 }
        };

        sort(graph1,8);
    }
}
