import java.util.Arrays;

public class PrimsAlgo
{
    public static int findMin(int[]dist,boolean[]visited){
        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i=0;i<dist.length;i++){
            if(!visited[i] && dist[i]<min){
                min = dist[i];
                index = i;
            }
        }

        return index;
    }

    public static boolean check(boolean []check){
        for (int i = 0; i <check.length;i++) {
            if(!check[i]){
                return true;
            }
        }
        return false;
    }
    public static int[] Prims(int[][]graph)
    {
        int[]parents = new int[graph.length];
        int[]dist = new int[graph.length];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0] = 0;
        int[]MST = new int[dist.length];
        boolean[]visited = new boolean[graph.length];
        Arrays.fill(visited,false);
        while (check(visited)){
            int index = findMin(dist,visited);
            visited[index] = true;
            for (int i=0;i<dist.length;i++){
                if(!visited[i] && graph[index][i]!=0){
                    if(dist[index]+graph[index][i]<dist[i]){
                        dist[i] = dist[index]+graph[index][i];
                        MST[i] = index ;
                    }
                }
            }
        }

        return MST;

    }
    public static void main(String[] args) {
        int[][] graph = {
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}
        };
        int[]MST = Prims(graph);
        for (int i = 0; i < graph.length; i++) {
            System.out.println("Parent "+(MST[i])+"-------> Child "+(i));
        }
    }

}
