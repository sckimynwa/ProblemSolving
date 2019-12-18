import java.util.*;
import java.io.*;

public class BOJ_2667 {

    static int n, cnt;
    static int[][] arr;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static ArrayList<Integer> apartment;

    public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer token = new StringTokenizer(br.readLine().trim());

       n = Integer.parseInt(token.nextToken());
       arr = new int[n][n];
       for(int i=0;i<n;i++){
           String str = br.readLine().trim();
           for(int j=0;j<n;j++){
               arr[i][j] = str.charAt(j)-'0';
           }
       }

       apartment = new ArrayList<>();
       cnt = 0;

       for(int i=0;i<n;i++){
           for(int j=0;j<n;j++){
               if(arr[i][j] == 1) {
                   apartment.add(cnt, 0);
                   cnt++;
               }
               dfs(i, j);
           }
       }

       int len = apartment.size();
       Collections.sort(apartment);
       System.out.println(len);

       for(int i=0;i<len;i++){
           System.out.println(apartment.get(i));
       }
    }

    public static void printMap() {
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(arr[i][j]+" ");
            }System.out.println();
        }
    }

    public static boolean isValid(int x, int y) {
        if(x>=0 && x<n && y>=0 && y<n) return true;
        return false;
    }

    public static void dfs(int x, int y) {
        if(arr[x][y] == 0) return;
        if(arr[x][y] == 1) {
            arr[x][y] = cnt+1;
            int temp = apartment.get(cnt-1);
            apartment.set(cnt-1, temp+1);
        }
        for(int i=0;i<4;i++){
            if(isValid(x+dx[i], y+dy[i]) && arr[x+dx[i]][y+dy[i]] == 1) {
                dfs(x+dx[i], y+dy[i]);
            }
        }
    }

}
