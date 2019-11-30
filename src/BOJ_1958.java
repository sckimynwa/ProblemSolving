import java.io.*;
import java.util.*;

public class BOJ_1958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str1 = br.readLine().trim();
        String str2 = br.readLine().trim();
        String str3 = br.readLine().trim();

        int retval = LCS_Int3(str1, str2, str3);
        bw.write(String.valueOf(retval));
        bw.flush();
        bw.close();
    }

    public static int LCS_Int3(String str1, String str2, String str3) {
        int len1 = str1.length();
        int len2 = str2.length();
        int len3 = str3.length();
        int[][][] dp;

        dp = LCS_Arr3(str1, str2, str3);

        return dp[len1][len2][len3];
    }

    public static int[][][] LCS_Arr3(String str1, String str2, String str3) {
        int len1 = str1.length();
        int len2 = str2.length();
        int len3 = str3.length();
        int[][][] dp = new int[len1+1][len2+1][len3+1];

        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                for(int k=1;k<=len3;k++){
                    if(str1.charAt(i-1) == str2.charAt(j-1) && str2.charAt(j-1) == str3.charAt(k-1))
                        dp[i][j][k] = dp[i-1][j-1][k-1] + 1;
                    else
                        dp[i][j][k] = Math.max(dp[i-1][j][k], Math.max(dp[i][j-1][k], dp[i][j][k-1]));
                }
            }
        }

        return dp;
    }
}
