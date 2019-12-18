import java.util.*;

public class BOJ_2588 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n1 = input.nextInt();
        int n2 = input.nextInt();

        int tmp = n2;
        for(int i=0;i<3;i++){
            int mod = n2%10;
            System.out.println(n1 * mod);
            n2 /= 10;
        }
        System.out.println(tmp*n1);
    }
}
