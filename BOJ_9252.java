import java.util.*;
import java.math.*;

public class BOJ_9252 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str1 = input.nextLine();
        String str2 = input.nextLine();

        int n  = str1.length();
        int m = str2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<n+1;i++){ dp[i][0] = 0;}
        for(int j=0;j<m+1;j++){ dp[0][j] = 0;}

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] +1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        //print length
        System.out.println(dp[n][m]);

//        for(int j=0;j < m+1;j++){
//            if(j!=0) System.out.print(str2.charAt(j-1)+" ");
//            else System.out.print("X ");
//        } System.out.println();
//
//        for(int i=1;i < n+1; i++){
//            for(int j=0;j<m+1;j++){
//                if(j!=0) System.out.print(dp[i][j]+" ");
//                else System.out.print(str1.charAt(i-1)+" ");
//            }
//            System.out.println();
//        }

        int len = dp[n][m];
        String LCS = "";
        for(int i=n; i>0; i--) {
            for(int j=m; j>0; j--){
                if(dp[i][j] == len && dp[i][j-1] == len - 1 && dp[i-1][j] == len - 1 && dp[i-1][j-1] == len - 1) {
                    LCS = str2.charAt(j-1) + LCS;
                    len--;
                    break;
                }
            }
        }
        System.out.println(LCS);

    }

    public static boolean isValid(int x, int y, int n, int m) {
        if(x>=1 && y>=1 && x<=n && y<=m) return true;
        return false;
    }
}
// CAPCAK
// ACAYKP