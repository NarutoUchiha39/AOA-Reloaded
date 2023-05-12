import java.util.Arrays;

public class QuikSort
{
    public static void QuickSort(int[]array,int low,int high)
    {
        if(low>=high){
            return;
        }
        int left  = low;
        int right = high;
        int mid = (high+low)/2;
        int pivot = array[mid];

        while (left<right)
        {
            while (array[left]<pivot){
                left++;
            }

            while (array[right]>pivot){
                right-=1;
            }

            if(left<=right){
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
        }

        if (left < high) {
            QuickSort(array,left,high);
        }
        if(right>low){
            QuickSort(array,low,right);
        }
    }
    public static void main(String[] args) {
        int[] array = {9, 2, 5, 1, 7, 4, 8, 3, 6};
        int low = 0;
        int high = array.length - 1;

        QuickSort(array, low, high);

        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}
