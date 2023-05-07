import java.util.Arrays;
import java.util.Scanner;
/*
Time complexity: O(M*N) where M is the total weight and N is the number of elements
Space complexity: O(M*N)
 */
public class KnapSackDynamic
{
    public static int dynamic(int[]cost,int[]weight,int[][]DP,int index,int totalWeight)
    {
        if(index==0){
            if (weight[index]<=totalWeight)
            {
                return cost[index];
            }

            else {
                return 0;
            }
        }
        if (DP[index][totalWeight]!=-1){
                return DP[totalWeight][index];
        }
        int val2 = Integer.MIN_VALUE;
        int val = dynamic(cost, weight, DP, index-1, totalWeight);
        if(weight[index]<totalWeight){
            val2 = cost[index]+dynamic(cost, weight, DP, index-1, totalWeight-weight[index]);
        }

        DP[index][totalWeight] = Math.max(val,val2);
        return DP[index][totalWeight];

    }


    public static void main(String[] args)
    {
        System.out.println("Enter total number of items ");
        Scanner sc = new Scanner(System.in);
        int totalItems = sc.nextInt();
        System.out.println("Enter total weight of knapsack: ");
        int totalWeight = sc.nextInt();

        int[]weights = new int[totalItems];
        int[]cost = new int[totalItems];

        for (int i = 0; i <totalItems ; i++) {
            System.out.println("Enter weight of "+i+" element");
            weights[i] = sc.nextInt();
            System.out.println("Enter profit of "+i+" element");
            cost[i] = sc.nextInt();
        }

        int DP[][] = new int[totalItems][];
        for(int i=0;i<totalItems;i++){
            DP[i] = new int[totalWeight+1];
            Arrays.fill(DP[i],-1);
        }

        System.out.println("The maximum profit by 01 knapsack is: "+dynamic(cost,weights,DP,totalItems-1,totalWeight));

    }
}
