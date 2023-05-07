import java.util.Arrays;
import java.util.Scanner;

/*
Time complexity : O(N^M)
Space complexity : O(N^2) + O(N)
 */
public class GraphColoring
{
    public static boolean canColor(boolean[][]graph,int k,int[]color,int node,int color1)
    {

        for (int j = 0; j <graph.length ; j++)
        {
            if(graph[node][j]) {
                if (color[j]==color1){
                    return false;
                }
            }
        }
        return true;
    }

    public static void helper(boolean[][] graph, int node, int[]color,int m, int total)
    {
        if(node==total){
            System.out.println(Arrays.toString(color));
            return;
        }

        for (int i = 0; i < m; i++) {
            if(canColor(graph,m,color,node,i))
            {
                color[node] = i;

                helper(graph, node+1, color,m,total);

                color[node] = -1;
            }
        }

    }
    public static void graphColoring(boolean graph[][], int m, int n)
    {
        int[]color = new int[n];
        Arrays.fill(color,-1);

        helper(graph,0,color,m,n);
    }

    public static void main(String[] args)
    {
        System.out.println("Enter number of vertices ");
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        System.out.println("Enter number of edges: ");
        int edges = sc.nextInt();
        boolean [][]graph = new boolean[vertices][vertices];
        for (boolean[]arr:graph){
            Arrays.fill(arr,false);
            System.out.println(Arrays.toString(arr));
        }

        System.out.println("Enter number of colors: ");
        int m = sc.nextInt();

        for (int i = 0; i < edges; i++) {
            System.out.println("Enter first node: ");
            int node1 = sc.nextInt();
            System.out.println("Enter second node: ");
            int node2 = sc.nextInt();
            graph[node1][node2] = true;
            graph[node2][node1] = true;
        }

       graphColoring(graph,m,vertices);

    }
}
