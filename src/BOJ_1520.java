import java.util.*;
import java.io.*;

public class BOJ_1520 {

    static int[][] arr, dp;
    static int n, m;
    static int[] dx = { 0, -1, 0, 1 };
    static int[] dy = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token = new StringTokenizer(br.readLine());
        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());
        arr = new int[n][m];
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            token = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(token.nextToken());
                dp[i][j] = -1;
            }
        }
        int start = arr[0][0];
        int ans = 0;
        bw.write(String.valueOf(dfs(0,0)));
        bw.flush();
        bw.close();
    }

    public static int dfs(int x, int y) {
        if(x==n-1 && y==m-1) return 1;
        if(dp[x][y] != -1) return dp[x][y];
        dp[x][y] = 0;
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(isValid(nx, ny) && arr[x][y] > arr[nx][ny]) {
                dp[x][y] += dfs(nx, ny);
            }
        }
        return dp[x][y];
    }

    public static boolean isValid(int i, int j) {
        if(i>=0 && i<n && j>=0 && j<m) return true;
        return false;
    }

}
