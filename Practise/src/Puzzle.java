public class Puzzle {
    public static boolean check(int[][] temp, int[][] target) {
        for (int i = 0; i < target.length; i++) {
            for (int j = 0; j < target.length; j++) {
                if (temp[i][j] != target[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int error(int[][] temp, int[][] target) {
        int m = 0;
        for (int i = 0; i < target.length; i++) {
            for (int j = 0; j < target.length; j++) {
                if (temp[i][j] != target[i][j]) {
                    m += 1;
                }
            }
        }
        return m;
    }

    public static void copy(int[][] source, int[][] target) {
        for (int i = 0; i < target.length; i++) {
            for (int j = 0; j < target.length; j++) {
                target[i][j] = source[i][j];
            }
        }
    }

    public static void solve(int[][] source, int[][] destination) {
        int l = 0;

        int[][] temp = new int[source.length][source.length];
        int x = 0;
        int y = 0;
        int[][] r = new int[source.length][source.length];

        while (!check(source, destination)) {
            int err = Integer.MAX_VALUE;
            l++;
            for (int i = 0; i < source.length; i++) {
                for (int j = 0; j < source.length; j++) {
                    if (source[i][j] == 0) {
                        x = i;
                        y = j;
                    }
                }
            }

            // Move up
            copy(source, temp);
            if (x != 0) {
                int t = temp[x][y];
                temp[x][y] = temp[x - 1][y];
                temp[x - 1][y] = t;
            }

            int error = error(temp, destination) + l;
            if (error < err) {
                copy(temp, r);
                err = error;
            }

            // Check down
            copy(source, temp);
            if (x != source.length - 1) {
                int t = temp[x][y];
                temp[x][y] = temp[x + 1][y];
                temp[x + 1][y] = t;
            }

            error = error(temp, destination) + l;
            if (error < err) {
                copy(temp, r);
                err = error;
            }
            //left
            copy(source, temp);
            if (y != 0) {
                int t = temp[x][y];
                temp[x][y] = temp[x][y - 1];
                temp[x][y - 1] = t;
            }

            error = error(temp, destination) + l;
            if (error < err) {
                copy(temp, r);
                err = error;
            }
            // Check right

            copy(source, temp);
            if (y != source.length - 1) {
                int t = temp[x][y];
                temp[x][y] = temp[x][y + 1];
                temp[x][y + 1] = t;
            }

            error = error(temp, destination) + l;
            if (error < err) {
                copy(temp, r);
                err = error;
            }

            for (int i = 0; i <source.length; i++) {
                for (int j = 0; j < source.length; j++) {
                    System.out.print(r[i][j]+" ");
                    temp[i][j] = 0;
                }
                System.out.println();
            }
            System.out.println(err);
            copy(r,source);


        }
    }

    public static void main(String[] args) {
        int[][]initial_matrix = {{1,2,3,4},{5,6,0,8},{9,10,7,11},{13,14,15,12}};

        int[][]target_matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,0}};
        solve(initial_matrix,target_matrix);
    }
}
