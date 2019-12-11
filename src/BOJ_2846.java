import java.util.*;

public class BOJ_2846 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){ arr[i] = input.nextInt(); }

        int max = 0;
        int start = 0;
        for(int i=1;i<n;i++){
            if(arr[start] < arr[i] && arr[i-1] < arr[i]) {
                if(max < arr[i] - arr[start]) max = arr[i] - arr[start];
            } else {
                start = i;
            }
        }
        System.out.println(max);
    }
}

// 12 20 1 3 4 4 11 1