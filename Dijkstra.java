import java.util.Arrays;

public class Dijkstra
{
    public static int findMin(int[]dist, boolean[] visited){
        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < dist.length; i++) {
            if(!visited[i] && dist[i]<min){
                min = dist[i];
                index = i;
            }
        }
        return index;
    }
    public static int[] dijk(int[][]graph,int source)
    {
        int[]dist = new int[graph.length];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[source] = 0;
        boolean[] visited = new boolean[graph.length];

        for (int i = 0; i < graph.length ; i++) {
            int min_index = findMin(dist,visited);
            visited[min_index] = true;
            for (int j = 0; j < graph.length; j++) {
                if(!visited[j] && graph[min_index][j]!=0){
                    if(dist[min_index]+graph[min_index][j]<dist[j]){
                        dist[j] = dist[min_index]+graph[min_index][j];
                    }
                }
            }
        }

        return dist;
    }
    public static void main(String[] args) {

        int graph[][] = new int[][] { {0,4,5,0,0,0},
                {4,0,11,9,7,0},
                {5,11,0,0,3,0},
                {0,9,0,0,13,2},
                {0,7,3,13,0,6},
                {0,0,0,2,6,0}};

        int[]dist = dijk(graph,0);
        for (int e:dist){
            System.out.println(e);
        }

    }
}