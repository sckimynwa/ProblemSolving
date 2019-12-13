import java.util.*;

public class BOJ_1834 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long n = input.nextInt();
        long sum = 0;

        for(long i=1;i<n;i++){
            sum += n*i + i;
        }
        System.out.println(sum);
    }
}
