import java.util.*;

public class BOJ_1012 {

    static int n, m;
    static int[][] arr;
    static int[] dx = { -1, 1, 0, 0};
    static int[] dy = { 0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        for(int q=0; q<num; q++){
            n = input.nextInt();
            m = input.nextInt();
            arr = new int[n][m];
            int cnt = input.nextInt();
            int ans = 0;

            for(int i=0; i<cnt; i++){
               int x = input.nextInt();
               int y = input.nextInt();
               arr[x][y] = 1;
            }

            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(arr[i][j] == 1) {
                        dfs(i, j);
                        ans++;
                    }
                }
            }
            System.out.println(ans);
        }
    }

    public static void dfs(int x, int y) {
        arr[x][y] = 2;
        for(int i=0;i<4;i++){
            if(isValid(x+dx[i], y+dy[i]) && arr[x+dx[i]][y+dy[i]] == 1) {
                dfs(x+dx[i], y+dy[i]);
            }
        }
    }

    public static boolean isValid(int x, int y) {
        if(x>=0 && x<n && y>=0 && y<m) return true;
        return false;
    }
}
