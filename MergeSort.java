import java.util.Scanner;
/*
Time complexity : O(n*log(n))
space complexity : O(log(n)) (height of tree)
 */
public class MergeSort
{


    public static void mergeSort(int[]arr,int low,int mid,int high){
        int left = (mid-low+1);
        int right = (high-mid);
        int[]left_array = new int[left];
        int[]right_array = new int[right];

        int leftIndex = 0;
        int rightIndex = 0;
        int cur = low;

        for (int i = 0; i < left; i++) {
            left_array[i] = arr[low+i];
        }

        for (int i = 0; i < right; i++) {
            right_array[i] = arr[mid+i+1];
        }

        while (leftIndex<left && rightIndex<right)
        {
            if(left_array[leftIndex]<right_array[rightIndex]){
                arr[cur] = left_array[leftIndex];
                leftIndex+=1;
            }

            else{
                arr[cur] = right_array[rightIndex];
                rightIndex+=1;
            }
            cur+=1;
        }

        while (leftIndex!=left){
            arr[cur] = left_array[leftIndex];
            leftIndex+=1;
            cur+=1;
        }

        while (rightIndex!=right){

            arr[cur] = right_array[rightIndex];
            rightIndex+=1;
            cur+=1;
        }

    }


    public  static void merge(int[]arr,int low,int high){
        if(high>low){
            int mid = (high+low)/2;
            merge(arr,low,mid);
            merge(arr,mid+1,high);
            mergeSort(arr,low,mid,high);
        }

    }
    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int size = sc.nextInt();
        int[]arr = new int[size];
        for (int i = 0; i <size ; i++) {
            arr[i] = sc.nextInt();
        }
    }
}
