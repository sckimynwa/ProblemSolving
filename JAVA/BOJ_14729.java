import java.util.*;
public class BOJ_14729 {

    static double[] arr;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        arr = new double[7];
        PriorityQueue<Double> queue = new PriorityQueue<>();

        for(int i=0;i<n;i++){
            double k = input.nextDouble();
            queue.add(k);
        }

        for(int i=0;i<7;i++){
            System.out.printf("%.3f\n", queue.poll());
        }
    }

    public static boolean minVal(double k) {
        return true;
    }
}
