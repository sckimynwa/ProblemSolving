import java.util.*;
public class BOJ_1780 {

    static int[][] arr;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        arr = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){ arr[i][j] = input.nextInt();}
        }

        int ans = subMat(0, 0, n);
        System.out.println(ans);

    }

    public static int subMat(int x, int y, int size) {
        if(checkPaper(x, y, size)) {
            return 1;
        } else {
            int retVal = 0;
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    retVal +=  subMat(x+(size*i), y+(size*j), size/3);
                }
            }
            return retVal;
        }
    }

    public static boolean checkPaper(int x, int y, int size) {
        int val = arr[x][y];
        for(int i=x;i<x+size;i++){
            for(int j=y;j<y+size;j++){
                if(arr[i][j] != val) return false;
            }
        }
        return true;
    }
}
