import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution1 {
    public static boolean check(String[][]board,int row,int col){
        int dummyrow = row;
        int dummycol = col;

        while (dummyrow>=0 && dummycol>=0){
            if(board[dummyrow][dummycol].equals("Q")){
                return false;
            }
            dummyrow-=1;
            dummycol-=1;
        }
        dummyrow = row;
        dummycol = col;

        while (dummycol>=0){
            if(board[dummyrow][dummycol].equals("Q")){
                return false;
            }
            dummycol-=1;
        }

        dummycol = col;

        while (dummycol>=0 && dummyrow<board.length){
            if(board[dummyrow][dummycol].equals("Q")){
                return false;
            }
            dummycol-=1;
            dummyrow+=1;
        }

        return true;
    }

    public static void check1(List<List<String>>Temp,String[][]board,int curCol,int n)
    {
        if(curCol==n){
            String[]temp = new String[n];
            for (int i=0;i<n;i++){
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j <n ; j++) {
                    builder.append(board[i][j]);
                };
                temp[i] = builder.toString();
            }
            Temp.add(Arrays.asList(temp));
            return;
        }

        for (int i = 0; i < n; i++) {
            if(check(board, i, curCol)){
                board[i][curCol] = "Q";
                check1(Temp,board,curCol+1,n);
                board[i][curCol] = ".";
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {

        String[][]board = new String[n][n];
        for (String[]arr:board){
            Arrays.fill(arr,".");
        }

        List<List<String>>ans = new LinkedList<>();
        check1(ans,board,0,n);
        return ans;
    }
}

public class NQueen
{

}
