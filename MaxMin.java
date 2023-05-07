import java.util.Scanner;
/*
Time complexity of max-min is O(N) with recursion stack space of O(N)
*/

public class MaxMin
{
    public static int[] max_min_recursion(int[] arr, int low, int high)
    {
        if(Math.abs(high-low)==1){
            return new int[]{Math.max(arr[high],arr[low]),Math.min(arr[high],arr[low])};
        }

        if(high==low){
            return new int[]{arr[high],arr[high]};
        }
        int mid = (high+low)/2;
        int[] left = max_min_recursion(arr,low,mid);
        int[] right = max_min_recursion(arr,mid+1,high);
        return new int[]{Math.max(left[0],right[0]),Math.min(left[1],right[1])};
    }

    public static int[] max_min_normal(int[]arr)
    {
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for (int num:arr){
            max = Math.max(num,max);
            min =Math.min(num,min);
        }

        return new int[]{max,min};
    }
    public static void main(String[] args) {
        System.out.print("Enter array size: ");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[]arr = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.println("Enter "+i+" element of array");
            arr[i] = sc.nextInt();
        }
        int[]res =  max_min_recursion(arr,0,size-1);
        System.out.println("The biggest number in the array by max min is: "+ res[0]);
        System.out.println("The smallest number in the array by max min is: "+ res[1]);

        res = max_min_normal(arr);
        System.out.println("The biggest number in the array by normal method is: "+ res[0]);
        System.out.println("The smallest number in the array by normal method is: "+ res[1]);
    }
}
