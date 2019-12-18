import java.util.*;

public class BOJ_1309 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[][] dp = new int[n][3];
        for(int j=0;j<3;j++){ dp[0][j] = 1;}

        // 0 = left, 1 = right, 2 = none
        for(int i=1;i<n;i++){
            dp[i][0] = (dp[i-1][1] + dp[i-1][2]) % 9901;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % 9901;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % 9901;
        }

        System.out.println((dp[n-1][0] + dp[n-1][1] + dp[n-1][2]) % 9901);
    }
}
