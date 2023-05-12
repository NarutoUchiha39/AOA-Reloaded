import java.util.Arrays;

public class MergeSort
{
    public static void mergeSort(int[]array,int low,int mid,int high){
        int leftSize = (mid-low+1);
        int rightSize = (high-mid);
        int[]left = new int[leftSize];
        int[]right = new int[rightSize];

        for (int i = 0; i <leftSize; i++) {
            left[i] = array[i+low];
        }
        for (int i = 0; i <rightSize; i++) {
            right[i] = array[i+mid+1];
        }

        int index_left = 0;
        int index_right = 0;
        int cur_index = low;
        while (index_right<rightSize && index_left<leftSize){
            if(left[index_left]<right[index_right]){
                array[cur_index] = left[index_left];
                index_left++;
            }

            else{
                array[cur_index] = right[index_right];
                index_right+=1;
            }
            cur_index+=1;
        }

        while (index_left!=leftSize){
            array[cur_index] = left[index_left];
            index_left+=1;
            cur_index+=1;
        }

        while(index_right!=rightSize){
            array[cur_index] = right[index_right];
            index_right+=1;
            cur_index+=1;
        }
    }
    public static void merge(int[]array,int low,int high)
    {
        if(high>low){
            int mid = (low+high)/2;
            merge(array,low,mid);
            merge(array,mid+1,high);
            mergeSort(array,low,mid,high);
        }
    }

    public static void main(String[] args) {
        int[] array = {9, 2, 5, 1, 7, 4, 8, 3, 6};
        int low = 0;
        int high = array.length - 1;

        MergeSort.merge(array, low, high);

        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}
