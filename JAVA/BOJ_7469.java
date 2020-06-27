import java.util.*;
import java.io.*;

public class BOJ_7469 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tok = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(tok.nextToken());
        int m = Integer.parseInt(tok.nextToken());

        int[] arr = new int[n];
        tok = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) arr[i] = Integer.parseInt(tok.nextToken());

        for(int i=0;i<m;i++){
            tok = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(tok.nextToken());
            int end = Integer.parseInt(tok.nextToken());
            int k = Integer.parseInt(tok.nextToken());

        }



        bw.flush();
        bw.close();
    }
}
