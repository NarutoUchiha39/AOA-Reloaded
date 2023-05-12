import java.util.Arrays;

public class KruskalAlgo
{
    static void sort(node[]arr)
    {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-i-1 ; j++) {
                if(arr[j].weight>arr[j+1].weight){
                    node temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    static class node{
        int source;
        int destination;
        int weight;
        node(int source,int destination,int weight){
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static int findParent(int[]par,int i)
    {
        if(par[i]==i){
            return par[i];
        }
        par[i] = findParent(par,par[par[i]]); // Path compression
        return par[i];
    }

    public static boolean DSU(int[]par,int[]size,int i,int j)
    {
        int par1 = findParent(par,i);
        int par2 = findParent(par,j);

        if(par1==par2){
            return false;
        }
        if(size[par1]>size[par2]){
            par[par2] = par1;
            size[par1]+=size[par2];
        }

        else{
            par[par1] = par2;
            size[par2]+=size[par1];
        }
        return true;
    }
    public static int kruskal(int[][]graph,int n,int edges)
    {

        node[]sort = new node[edges];
        int counter = 0;
        for (int i = 0; i <n; i++) {
            for (int j = 0; j < n; j++) {
                if(graph[i][j]!=0){
                    sort[counter] = new node(i,j,graph[i][j]);
                    counter+=1;
                }
            }
        }

        sort(sort);

        int[]par = new int[n];
        for (int i=0;i<n;i++){
            par[i] = i;
        }
        int[]size = new int[n];
        Arrays.fill(size,1);
        int cost = 0;

        for (int i = 0; i <edges; i++) {
                if(DSU(par,size,sort[i].source,sort[i].destination)){
                    cost+=sort[i].weight;
                }
        }
        return cost;

    }

    public static void main(String[] args) {
        int n = 6;
        int edges = 14;

        int[][] graph = {
                {0, 4, 0, 0, 0, 0},
                {4, 0, 8, 0, 0, 0},
                {0, 8, 0, 7, 9, 0},
                {0, 0, 7, 0, 5, 6},
                {0, 0, 9, 5, 0, 4},
                {0, 0, 0, 6, 4, 0}
        };

        System.out.println(KruskalAlgo.kruskal(graph, n, edges));
    }
}
