import java.util.Scanner;
/*
Binary search time complexity : O(log(n))
Space complexity : O(log(n))
 */
public class SearchElement
{
    public static int bin_search(int []arr,int high,int low,int num)
    {
        if(high>low) {
            int mid = (low+high)/2;
            if (arr[mid] == num)
            {
                return mid;
            }

            if(arr[mid]>num){
                high = mid-1;
            }

            if(arr[mid]<num){
                low = mid+1;
            }
            return bin_search(arr, high, low, num);
        }

        return -1;
    }

    public static int search(int[]arr,int search){

        for (int i = 0; i <arr.length ; i++) {
            if(search==arr[i]){
                return i ;
            }
        }

        return -1;
    }
    public static void main(String[] args)
    {

        System.out.println("Enter size of array: ");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[]arr = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.println("Enter "+i+" element of array");
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter number to search for ");
        int num = sc.nextInt();
        System.out.println("Element found at "+bin_search(arr,size-1,0,num)+" by binary search ");
        System.out.println("Element found at "+search(arr,num)+" by iterative search ");

    }
}
