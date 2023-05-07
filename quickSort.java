import java.util.Arrays;
/*
Time complexity of quicksort : O(nlogn) (best case)
Worst case : O(n^2)
Average case : O(nlogn)
space complexity : O(logn) (recursion tree height)
 */

public class quickSort
{
    public static void Randomized_QuickSort(int[]arr,int low,int high)
    {
        int low1 = low;
        int high1 = high;

        if(high<=low){
            return;
        }


        int pivot = arr[(int)(Math.random()*(high-low+1))+low];
        while (low1 < high1)
        {
            while (arr[low1] < pivot) {
                low1 += 1;
            }

            while (arr[high1] > pivot) {
                high1 -= 1;
            }

            if (high1 >= low1) {
                int temp = arr[high1];
                arr[high1] = arr[low1];
                arr[low1] = temp;
                low1 += 1;
                high1 -= 1;
            }
        }


        Randomized_QuickSort(arr,low,high1);
        Randomized_QuickSort(arr,low1,high);
    }
    public static void Quick(int[]arr,int low,int high)
    {
        int low1 = low;
        int high1 = high;

        if(high<=low){
            return;
        }

            int mid = (high + low) / 2;
            int pivot = arr[mid];
            while (low1 < high1)
            {
                while (arr[low1] < pivot) {
                    low1 += 1;
                }

                while (arr[high1] > pivot) {
                    high1 -= 1;
                }

                if (high1 >= low1) {
                    int temp = arr[high1];
                    arr[high1] = arr[low1];
                    arr[low1] = temp;
                    low1 += 1;
                    high1 -= 1;
                }
            }


        Quick(arr,low,high1);
        Quick(arr,low1,high);
    }
    public static void main(String[] args)
    {
        int[] arr = {4,1,3,9,7};
        Randomized_QuickSort(arr,0,4);
        System.out.println(Arrays.toString(arr));

    }
}
