import java.util.*;
public class BOJ_2475 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int num = 0;
        for(int i=0;i<5;i++){
            int k = input.nextInt();
            num += k*k;
        }
        System.out.println(num%10);
    }
}
