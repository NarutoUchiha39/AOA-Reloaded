public class GreedyKnapsack
{
    static class Item {
        int value, weight;
        Item(int x, int y){
            this.value = x;
            this.weight = y;
        }
    }
    public static void findMin(Item[]arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if((arr[j].value*(1.0)/arr[j].weight)< (arr[j+1].value*(1.0)/arr[j+1].weight)){
                    Item temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static float Greedy(int W,Item[]arr,int n)
    {
        findMin(arr);
        int item = 0;
        float totalProfit = 0f;
        int curWeight  = 0;
        while (item<n && curWeight<W){
            if(curWeight+arr[item].weight<=W){
                curWeight = curWeight+arr[item].weight;
                totalProfit += arr[item].value;
            }

            else{
                totalProfit+= (W-curWeight)*(arr[item].value*(1.0)/arr[item].weight);
                curWeight = W;
            }

            item+=1;
        }

        return totalProfit;
    }

}
