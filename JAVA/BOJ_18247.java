import java.util.*;
public class BOJ_18247 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

        for(int i=0;i<num;i++){
            int n = input.nextInt();
            int m = input.nextInt();
            if(m < 4 || n < 12) System.out.println(-1);
            else {
                System.out.println(m*11 + 4);
            }
        }
    }
}
