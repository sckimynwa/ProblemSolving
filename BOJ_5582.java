import java.util.*;

public class BOJ_5582 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str1 = input.nextLine().trim();
        String str2 = input.nextLine().trim();
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] dp = new int[len1][len2];

        int maxLen = 0;
        for(int i=0;i<len1;i++){
            for(int j=0;j<len2;j++){
                if(str1.charAt(i)==str2.charAt(j)){
                    if(i==0 || j==0) {
                        dp[i][j] = 1;
                    }else {
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }
                    if(maxLen < dp[i][j]) maxLen = dp[i][j];
                }
            }
        }
        System.out.println(maxLen);

    }
}
