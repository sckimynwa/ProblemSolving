import java.util.*;

public class BOJ_10870 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] fibo = new int[n+1];
        if(n>=1) fibo[1] = 1;
        if(n<=1) {
            System.out.println(fibo[n]);
        } else {
            for(int i=2;i<=n;i++){
                fibo[i] = fibo[i-1] + fibo[i-2];
            }
            System.out.println(fibo[n]);
        }
    }
}
