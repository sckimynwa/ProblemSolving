import java.util.*;
public class BOJ_3058 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        while(true) {
            if(n==1){
                System.out.println(1);
                break;
            }
            if(n%2==0) { n/=2; }
            else {
                System.out.println(0);
                break;
            }
        }
    }
}
