import java.util.*;

public class BOJ_1350 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // input features
        int n = input.nextInt();
        long[] arr = new long[n];
        for(int i=0;i<n;i++){ arr[i] = input.nextInt();}
        long size = input.nextInt();
        long tot = 0;

        // calculating total size
        for(int i=0;i<n;i++){
            tot += getSize(arr[i], size);
        }
        System.out.println(tot);
    }

    public static long getSize(long k, long size) {
        if(k == 0) return 0;
        long ret = 0;
        if(k % size != 0) ret += size;
        ret += (k/size) * size;
        return ret;
    }

}
