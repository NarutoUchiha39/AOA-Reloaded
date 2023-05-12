import java.util.Arrays;
import java.util.Scanner;

public class FloydWarshall
{
    public static void graph(int[][]graph)
    {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j <graph.length; j++) {
                for (int k = 0; k < graph.length; k++) {
                    if(graph[j][i]==-1 || graph[i][k]==-1){
                        continue;
                    }
                    if(graph[j][k]==-1 ||( graph[j][i]+graph[i][k]<graph[j][k])){
                        graph[j][k] =graph[j][i]+graph[i][k];
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter number of vertices");
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        int[][]graph = new int[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.println("Enter edge weight between "+i+" "+j+" Enter -1 for no connection");
                graph[i][j] = sc.nextInt();
            }
        }

        graph(graph);
        for(int[]i: graph){
            System.out.println(Arrays.toString(i));
        }
    }
}
