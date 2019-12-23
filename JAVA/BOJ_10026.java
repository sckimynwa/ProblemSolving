import java.io.*;
public class BOJ_10026 {

    static int n;
    static char[][] arr1, arr2;
    static int cnt1, cnt2;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // input settings
        n = Integer.parseInt(br.readLine().trim());
        arr1 = new char[n][n]; arr2 = new char[n][n];
        cnt1 = 0; cnt2 = 0;
        for(int i=0;i<n;i++){
            String str = br.readLine().trim();
            for(int j=0;j<n;j++){
                arr1[i][j] = str.charAt(j);
                arr2[i][j] = str.charAt(j);
                if(str.charAt(j) == 'G') arr2[i][j] = 'R';
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr1[i][j] != 'X') {
                    cnt1++;
                    dfs1(i, j, arr1[i][j]);
                }
                if(arr2[i][j] != 'X') {
                    cnt2++;
                    dfs2(i, j, arr2[i][j]);
                }
            }
        }

        bw.write(cnt1+" "+cnt2);
        bw.flush();
        bw.close();
    }

    public static void dfs1(int x, int y, char color) {
        if(arr1[x][y] == 'X') return;

        arr1[x][y] = 'X';
        for(int i=0;i<4;i++){
            if(isValid(x+dx[i], y+dy[i]) && arr1[x+dx[i]][y+dy[i]] == color) {
                dfs1(x+dx[i], y+dy[i], color);
            }
        }
    }

    public static void dfs2(int x, int y, char color) {
        if(arr2[x][y] == 'X') return;

        arr2[x][y] = 'X';
        for(int i=0;i<4;i++){
            if(isValid(x+dx[i], y+dy[i]) && arr2[x+dx[i]][y+dy[i]] == color) {
                dfs2(x+dx[i], y+dy[i], color);
            }
        }
    }

    public static void print() {
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(arr2[i][j]);
            }System.out.println();
        }
        System.out.println();
        System.out.println("------------------------");
    }

    public static boolean isValid(int x, int y) {
        if(x>=0 && x<n && y>=0 && y<n) return true;
        return false;
    }
}
