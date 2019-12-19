import java.util.*;

public class BOJ_2506 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)arr[i]= input.nextInt();

        int sum = 0;
        int cnt = 1;
        for(int i=0;i<n;i++) {
            if(arr[i] == 1) {
                sum += cnt;
                cnt++;
            } else {
                cnt = 1;
            }
        }

        System.out.println(sum);
    }
}
