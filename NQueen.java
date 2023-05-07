import java.util.ArrayList;
import java.util.Arrays;
/*
Time complexity : O(N!)
Space Complexity : O(N^2)
 */
public class NQueen
{
    public static boolean canPlace(int[][]board,int col,int row,int size)
    {
        int dummycol = col;
        int dummyrow = row;

        while(dummycol>=0 && dummyrow>=0)
        {
            if(board[dummyrow][dummycol]!=-1){
                return false;
            }
            dummycol-=1;
            dummyrow-=1;
        }


        dummycol = col;
        while (dummycol>=0)
        {
            if(board[row][dummycol]!=-1){
                return false;
            }
            dummycol-=1;
        }

        dummycol = col;
        dummyrow = row;

        while (dummyrow<size && dummycol>=0){
            if(board[dummyrow][dummycol]!=-1){
                return false;
            }
            dummyrow+=1;
            dummycol-=1;
        }

        return true;
    }
    public static void solve(int total, int[][]board ,int col,ArrayList<ArrayList<Integer>>temp)
    {
        if(col==total)
        {
            ArrayList<Integer>temp2 = new ArrayList<>();
            for (int i = 0; i < total; i++) {
                for (int j = 0; j < total; j++) {
                    if(board[j][i]!=-1){
                        temp2.add(j+1);
                    }
                }
            }
            System.out.println(temp2);
            temp.add(temp2);
            return ;
        }

        for (int i = 0; i < total; i++)
        {
            if(canPlace(board,col,i,total)){
                board[i][col] = i;
                solve(total, board, col+1, temp);
                board[i][col]=-1;
            }
        }
    }

    static ArrayList<ArrayList<Integer>> nQueen(int n)
    {
        int[][] board = new int[n][n];
        for (int[]arr:board){
            Arrays.fill(arr,-1);
        }
        ArrayList<ArrayList<Integer>>temp = new ArrayList<>();
        solve(n,board,0,temp);
        return temp;
    }

    public static void main(String[] args) {
        int size = 4;

        nQueen(4);
    }
}
