import java.util.*;
import java.io.*;
public class BOJ_2776 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(token.nextToken());

        for(int i=0;i<n;i++){
            HashMap<Integer, Boolean> map = new HashMap<>();
            token = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(token.nextToken());

            token = new StringTokenizer(br.readLine());
            for(int j=0;j<n1;j++){
                map.put(Integer.parseInt(token.nextToken()), true);
            }

            token = new StringTokenizer(br.readLine());
            int n2 = Integer.parseInt(token.nextToken());

            token = new StringTokenizer(br.readLine());
            for(int j=0;j<n2;j++){
                int m = Integer.parseInt(token.nextToken());
                if(map.get(m) == null) System.out.println(0);
                else System.out.println(1);
            }
        }
    }
}
