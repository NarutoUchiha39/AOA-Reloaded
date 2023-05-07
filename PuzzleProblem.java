public class PuzzleProblem
{
    public static int check(int[][]cur,int[][]target) // Hamming distance
    {
        int m =0;
        for (int j = 0;j<cur.length;j++){
            for (int i = 0; i <cur.length; i++) {
                if(cur[j][i]!=target[j][i]){
                    m+=1;
                }
            }
        }
        return m;
    }

    public static boolean correct(int[][]cur, int[][]target)
    {
        for (int i = 0; i < cur.length; i++) {
            for (int j = 0; j <target.length; j++) {
                if(cur[i][j]!=target[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
    public static void copy(int[][]temp,int[][]arr){
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp.length; j++) {
                temp[i][j] = arr[i][j];
            }
        }
    }
    public static void solve(int[][]target,int[][]initial)
    {
        int[][]temp = new int[4][4];
        int size = 4;

        int l = 0;
        int dmin = 0;
        int x = 0;
        int y = 0;
        int[][]r = new int[4][4];



        while (!correct(initial,target)){ //Keep going till the final configuration isn't reached
            int d = Integer.MAX_VALUE;
            l+=1; // Keep track of the number of iterations will be used later for hamming distance error correction
            // Check in the upward direction
            for (int i = 0;i< temp.length;i++){
                for (int j = 0; j < temp.length; j++) {
                    if(initial[i][j]==0){
                        x = i;
                        y = j; // Get x and y coordinate of blank space
                    }
                }
            }
            copy(temp,initial);
            if(x!=0){ // Cause if  x is zero then nothing exists above it
                int val = temp[x][y];
                temp[x][y] = temp[x-1][y]; // Move the blank position one step in the upward direction
                temp[x-1][y]  =val;
            }

            int error = check(temp,target);
            dmin = l+error;

            if(d>dmin){
                d = dmin;
                copy(r,temp);
            }

            // Check in the downward direction
            copy(temp,initial);
            if(x!=size-1){ // Cause if  y is last row then nothing exists below it
                int val = temp[x][y];
                temp[x][y] = temp[x+1][y]; // Move the blank position one step in the downward direction
                temp[x+1][y]  =val;
            }

            error = check(temp,target);
            dmin = l+error;

            if(d>dmin){
                d = dmin;
                copy(r,temp);
            }

            // check in right direction
            copy(temp,initial);
            if(y!=size-1){ // Cause if  y is last column then nothing exists to the right of it
                int val = temp[x][y];
                temp[x][y] = temp[x][y+1]; // Move the blank position one step in the right direction
                temp[x][y+1]  =val;
            }

            error = check(temp,target);
            dmin = l+error;

            if(d>dmin){
                d = dmin;
                copy(r,temp);
            }

            // Check in left direction

            copy(temp,initial);
            if(y!=0){ // Cause if  y is first column then nothing exists on left of it
                int val = temp[x][y];
                temp[x][y] = temp[x][y-1]; // Move the blank position one step in the left direction
                temp[x][y-1]  =val;
            }

            error = check(temp,target);
            dmin = l+error;

            if(d>dmin){
                d = dmin;
                copy(r,temp);
            }

            System.out.println("Intermediate matrix at step "+l+" with minimum cost "+d+" :");
            for (int i = 0; i < size; i++) {
                for (int j = 0; j <size; j++) {
                    System.out.print(r[i][j]+" ");
                    temp[i][j] = 0;
                }
                System.out.println();
            }
            copy(initial,r);
        }
    }
    public static void main(String[] args)
    {
        int[][]initial_matrix = {{1,2,3,4},{5,6,0,8},{9,10,7,11},{13,14,15,12}};

        int[][]target_matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,0}};
        solve(target_matrix,initial_matrix);

    }
}
