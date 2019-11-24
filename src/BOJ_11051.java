import java.util.*;

public class BOJ_11051 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long[][] arr = new long[1001][1001];
        int n = input.nextInt();
        int k = input.nextInt();

        for(int i=0;i<1001;i++){
            arr[i][i] = 1;
            arr[0][i] = 1;
            arr[1][i] = i;
        }

        for(int j=3;j<1001;j++){
            for(int i=2;i<j;i++){
                arr[i][j] = (arr[i][j-1] + arr[i-1][j-1]) % 10007;
            }
        }

        System.out.println(arr[k][n]);
    }
}

