import java.util.*;
import java.math.*;

public class BOJ_11049 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n+1];
        int[][] mat = new int[n][2];
        int[][] dp = new int[n][n];

        for(int i=0;i<n;i++){
            mat[i][0] = input.nextInt();
            mat[i][1] = input.nextInt();
        }
        for(int i=0;i<n;i++){ arr[i] = mat[i][0];}
        arr[n] = mat[n-1][1];

        // dp process
        for(int size = 0;size<n;size++){
           for(int i=0;i<n-size;i++){
               int j = i+size;
               if(i==j) {
                   dp[i][j] = 0;
                   continue;
               }
               dp[i][j] = Integer.MAX_VALUE;
               for(int k=i;k<j;k++){
                   dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + arr[i]*arr[k]*arr[j+1]);
               }
           }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(dp[i][j]+" ");
            }System.out.println();
        }

        System.out.println(dp[0][n-1]);
    }
}
