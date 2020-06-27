import java.util.*;

public class BOJ_11658 {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        FenwickTree fenwick = new FenwickTree(n);
        int[][] matrix = new int[n+1][n+1];

        // initialize fecwick tree
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                matrix[i][j] = input.nextInt();
                fenwick.update(i, j, matrix[i][j]);
            }
        }

        // process
        for(int i=0;i<m;i++){
            int w = input.nextInt();
            if (w == 1) {
                // sum
                int x1 = input.nextInt();
                int y1 = input.nextInt();
                int x2 = input.nextInt();
                int y2 = input.nextInt();

                int sum = fenwick.sum(x2, y2) - fenwick.sum(x2, y1-1)
                        - fenwick.sum(x1-1, y2) + fenwick.sum(x1-1, y1-1);
                System.out.println(sum);

            } else {
                // update
                int x = input.nextInt();
                int y = input.nextInt();
                int val = input.nextInt();
                fenwick.update(x, y, val - matrix[x][y]);
                matrix[x][y] = val;
            }
        }
    }
    static class FenwickTree {
        int[][] tree;
        int n;
        FenwickTree(int n) {
            this.n = n;
            this.tree = new int[n+1][n+1];
        }

        // calculate psum
        public int sum(int posx, int posy) {
            int retVal = 0;
            int y = posy;
            while(y > 0) {
                int x = posx;
                while(x > 0) {
                    retVal += this.tree[x][y];
                    x -= (x & -x);
                }
                y -= (y & -y);
            }
            return retVal;
        }

        // update
        public void update(int posx, int posy, int val) {
            int x = posx;
            while(x <= this.n) {
                int y = posy;
                while(y <= this.n) {
                    this.tree[x][y] += val;
                    y += (y & -y);
                }
                x += (x & -x);
            }
        }
    }
}

