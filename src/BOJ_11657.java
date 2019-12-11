import java.util.*;
import java.io.*;

public class BOJ_11657 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        int[] d = new int[n];
        int[][] map = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                map[i][j] = 10000000;
            }
        }

        // Make Adjacency Map
        for(int i=0;i<m;i++){
            token = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(token.nextToken()) - 1;
            int dest = Integer.parseInt(token.nextToken()) - 1;
            int dis = Integer.parseInt(token.nextToken());
            map[start][dest] = dis;
        }

        // bellman ford
        // 1. initial setting
        for(int i=0;i<n;i++) d[i] = Integer.MAX_VALUE;
        d[0] = 0;

        // 2. relax
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(d[i] + map[i][j] < d[j]) d[j] = d[i] + map[i][j];
            }
        }

        // 3. find neg cycle
        if(negCycle(d, map, n)){
            bw.write(String.valueOf(-1));
        } else {
            for(int i=1;i<n;i++){
                if(d[i] == 10000000) bw.write(String.valueOf(-1)+"\n");
                else bw.write(String.valueOf(d[i])+"\n");
            }
        }

        bw.flush();
        bw.close();
    }

    public static boolean negCycle(int[] d, int[][] map, int n) {
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(d[i] + map[i][j] < d[j]) return true;
            }
        }
        return false;
    }
}