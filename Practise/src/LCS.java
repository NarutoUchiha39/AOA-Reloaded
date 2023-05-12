import java.util.Arrays;

public class LCS
{
    public static int LCS(int i,int j,int[][]DP, String s1,String s2)
    {
        if(i<0 || j<0){
            return 0;
        }
        if(DP[i][j]!=-1){
            return DP[i][j];
        }
        int res = Integer.MAX_VALUE;
        if(s1.charAt(i)==s2.charAt(j)){
            return 1+LCS(i-1,j-1,DP,s1,s2);
        }

        else{
            res = Math.max(LCS(i-1,j,DP,s1,s2),LCS(i,j-1,DP,s1,s2));
        }
        DP[i][j] = res;
        return res;
    }
    static int lcs(int x, int y, String s1, String s2)
    {
        int[][]DP = new int[x][y];

        for(int[]arr:DP){
            Arrays.fill(arr,-1);
        }
        return LCS(x-1,y-1,DP,s1,s2);
    }
    public static void main(String[] args) {

    }
}
