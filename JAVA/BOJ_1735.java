import java.util.*;

public class BOJ_1735 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a1 = input.nextInt();
        int a2 = input.nextInt();
        int b1 = input.nextInt();
        int b2 = input.nextInt();

        int sum1 = a1*b2 + a2*b1;
        int sum2 = a2*b2;
        System.out.println(sum1/gcd(sum1, sum2)+" "+sum2/gcd(sum1, sum2));
    }
    public static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a%b);
    }
}
