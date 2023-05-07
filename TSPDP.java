import java.util.Arrays;
/*
Worst sum ever.....
Time complexity : O(N*(2**N))
Space Complexity : O(N*(2**N))

Approach : Initially we set thr mask as 1. 1 in binary is 00000...1 representing that our 0th city has been visited. Next we traverse through all the nodes and check
if they have been visited in the current mask. This is done by taking an and operation between the current mask and leftshifting the one in for loop by n times
where n represents the city to be checked. 1<<2 = 100. Now suppose our current mask is 101 and we wanna check if the first city is visited or not. For this
we do and operation between 101 and 1<<1 or 010 since the and operation gives 0, it means that the city has not been visited yet. So we add the cost it takes
to go from our latest position(i.e 2) to our destination (i.e 1) and then use recursion to further calculate the distance between 1 and our starting node .
Now since we found that the current city is not visited we need to mark it as visited for that we take our current mask(101) and do the or operation with left
shifted 1 (010) this gives output as 111 indicating the first city has been visited.

Now to represent tha all the n cities have been visited we use 1<<n times to get 1_____....(n times) notices how there are total of (n+1) digits. Noe to get the largest
number that is n digits long with all ones, we simply subtract 1 from the 1<<n to get the largest number that can be represented by 1___(n-1 times, total n). If our
current mask ever becomes equal to the above number we will know that all the cities have been visited. When all the cities have been visited we check the distance
of the latest added node with our source node since a hamiltonian cycle has to be formed.

If we observe carefully there are N maximum bits a state can have and each state can have an option from 2 digits(i.e. 0 or 1) so the total number of possible states
are 2**N where N is the number of cities. Each state can have a destination of anyone of the N nodes available in the total number of cities. Thus the
space required for DP array becomes (2**N)*(N) which is our time complexity too.

All the cities that are not connected to any particular node in consideration should be marked by 0
 */
public class TSPDP
{
    public static int TSP(int[][]graph,int mask,int pos,int city,int visitedAll,int [][]DP)
    {
        int finalAns = Integer.MAX_VALUE;
        if(mask==visitedAll)
        {
            return graph[pos][0];
        }

        if(DP[mask][pos]!=-1){
            return DP[mask][pos];
        }

        for (int i = 0; i < city; i++) {
            if((mask&(1<<i))==0){
                int ans = graph[pos][i]+TSP(graph, (mask|(1<<i)), i, city,visitedAll,DP);
                finalAns = Math.min(finalAns,ans);
            }
        }
        DP[mask][pos]=finalAns;
        return finalAns;
    }
    public int total_cost(int[][] cost)
    {
        int visited = (1<<cost.length)-1;
        int[][]DP = new int[(int)Math.pow(2,cost.length)][cost.length];
        for(int i=0;i<(int)Math.pow(2,cost.length);i++){
            Arrays.fill(DP[i],-1);
        }
        return TSP(cost,1,0,cost.length,visited,DP);
    }

}
