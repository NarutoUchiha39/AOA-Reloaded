import java.util.Arrays;
import java.util.Scanner;

public class LCS
{
    public static int LCS(String s1, String s2,int x,int y,int[][]DP)
    {
        if(x<0 || y<0){
            return 0;
        }

        if(DP[x][y]!=-1){
            return DP[x][y];
        }

        if(s1.charAt(x)==s2.charAt(y)){
            return 1+LCS(s1, s2, x-1, y-1, DP);
        }

        DP[x][y]= Math.max(LCS(s1, s2, x-1, y, DP),LCS(s1, s2, x, y-1, DP));
        return DP[x][y];

    }

    public  static int iterative(String s1,String s2,int x, int y)
    {
        int[][]DP = new int[x+1][y+1];
        StringBuilder builder = new StringBuilder();


        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    DP[i][j] = 1+DP[i-1][j-1];
                    builder.append(s1.charAt(i-1));
                }
                else
                {
                    DP[i][j] = Math.max(DP[i-1][j],DP[i][j-1]);
                }
            }
        }
        System.out.println("LCS is : "+builder);
        return DP[x][y];

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the first string: ");
        String s1 = sc.next();

        System.out.println("Enter the second string: ");
        String s2 = sc.next();
        int x = s1.length();
        int y = s2.length();
        int[][]DP = new int[x+1][];
        for(int i=0;i<x+1;i++){
            DP[i] = new int[s2.length()+1];
            Arrays.fill(DP[i],-1);
        }

        System.out.println("The LCS between "+s1+" and "+s2+" is "+LCS(s1,s2,s1.length()-1,s2.length()-1,DP));
        System.out.println("The LCS between "+s1+" and "+s2+" is "+iterative(s1,s2,x,y));





    }
}
