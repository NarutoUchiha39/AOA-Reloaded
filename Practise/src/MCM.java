public class MCM
{
    public static int multiply(int[][]DP,int[]multiply,int i,int j){
        if(i==j){
            return 0;
        }
        if(DP[i][j]!=-1){
            return DP[i][j];
        }
        int res = Integer.MAX_VALUE;
        for (int k = i; k <j; k++) {
            res = Math.min(res,multiply[i-1]*multiply[k]*multiply[j]+multiply(DP, multiply, i, k)+multiply(DP, multiply, k+1, j));
        }

        DP[i][j] = res;
        return res;
    }


    public static void main(String[] args) {

    }
}
