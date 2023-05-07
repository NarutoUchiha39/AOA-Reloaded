import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
Space complexity : O(N)
time complexity : O(nlogn) + O(N)
 */
public class KnapSackGreedy
{
    public static class store
    {
        double cost;
        int weight;

        store(double cost,int weight)
        {
            this.cost = cost/weight;
            this.weight = weight;
        }
    }
    public static double helper(int []weight,int[]profit,int totalWeight,int size)
    {
        store[]arr = new store[size];
        Comparator<store>comparator = new Comparator<store>() {
            @Override
            public int compare(store o1, store o2) {
                return -Double.compare(o1.cost, o2.cost);
            }
        };
        for (int i = 0; i < size; i++) {
            arr[i] = new store((double) profit[i],weight[i]);
        }

        Arrays.sort(arr,comparator);
        int items = 0;
        double curProfit = 0f;
        int curWeight = 0;

        while (items<size && curWeight<totalWeight )
        {
            if(curWeight+arr[items].weight<=totalWeight){
                curWeight+=arr[items].weight;
                curProfit += arr[items].cost*arr[items].weight;
            }

            else {
                curProfit += arr[items].cost*(totalWeight-curWeight);
                curWeight = totalWeight;
            }
            items+=1;
        }

        return curProfit;

    }
    public static void main(String[] args) {
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

        System.out.println("Maximum profit is "+helper(weights,cost,totalWeight,totalItems));
    }
}
