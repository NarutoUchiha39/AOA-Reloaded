import java.util.Arrays;

class Solution
{
    public static int calculate(int[][]graph,int mask,int max,int node,int[][]DP)
    {
        if(mask==max){
            return graph[node][0];
        }
        if(DP[mask][node]!=-1){
            return DP[mask][node];
        }
        int final_ans = Integer.MAX_VALUE;
        for (int i=0;i<graph.length;i++){
            if((mask&(1<<i))==0  && graph[node][i]!=0){
                    int ans = graph[node][i] + calculate(graph, (mask|(1<<i)), max, i,DP);
                    final_ans = Math.min(ans,final_ans);
            }
        }
        DP[mask][node] = final_ans;
       return final_ans;
    }
    public int total_cost(int[][] cost)
    {
        int[][]DP = new int[(int)Math.pow(2,cost.length)][cost.length];
        for (int[]arr:DP){
            Arrays.fill(arr,-1);
        }
        int max = (1<<cost.length)-1;
        return calculate(cost,1,max,0,DP);

    }
}
public class TSPDP
{

}
