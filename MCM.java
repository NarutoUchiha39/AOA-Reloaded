import java.util.Arrays;
/*
Time complexity : O(N^3)
Space complexity : O(N^2)
 */
public class MCM
{
    static int MCM_Recursion(int i, int j,int[]arr,int[][]DP)
    {
        if(i==j){
            return 0;
        }
        if(DP[i][j]!=-1){
            return DP[i][j];
        }
        int res = Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            res = Math.min(res,arr[i-1]*arr[k]*arr[j]+MCM_Recursion(i,k,arr,DP)+MCM_Recursion(k+1,j,arr,DP));
        }
        DP[i][j] =  res;
        return res;
    }


    static int matrixMultiplication(int N, int arr[])
    {
        int[][]DP = new int[N][N];
        for(int[]arr1:DP){
            Arrays.fill(arr1,-1);
        }

        return MCM_Recursion(1,N-1,arr,DP);

    }

    static int matrix_chain_iterative(int[] arr)
    {
        int[][]DP = new int[arr.length][arr.length];
        int[][]paranthesis = new int[arr.length][arr.length];
        int N = arr.length;
        for(int[]ar1:DP){
            Arrays.fill(ar1,0);
        }

        for (int[]p:paranthesis){
            Arrays.fill(p,0);
        }

        for (int d = 1; d <N-1; d++) // Maintain the possible differences two matrices(i.e the length of all matrix in consideration.Example: d =1
            // Signifies division of matrices like (1,2)(3,4) or (2,3)(4,4) and difference of 2 signifies (1,3)(4,4)
        {
            for (int i = 1; i <N-d; i++) { // N-d as we move down the 2-DP array the total number of elements after the diagonal keeps on decreasing

                int res = Integer.MIN_VALUE;
                int final1 = Integer.MAX_VALUE;
                int j = i+d; // Compute diagonal values in matrix
                for (int k = i; k <=j-1; k++) {// Represents the various possible parenthesis
                    res = arr[i-1]*arr[k]*arr[j]+DP[i][k]+DP[k+1][j];
                    if(final1>res){
                        final1 = res;
                        paranthesis[i][j] = k;
                    }
                }
                DP[i][j] = final1;
            }
        }

        return DP[1][N-1];

    }
    public static void main(String[] args) {

    }
}
