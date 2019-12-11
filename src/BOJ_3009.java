import java.util.*;
public class BOJ_3009 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x1 = input.nextInt(); int y1 = input.nextInt();
        int x2 = input.nextInt(); int y2 = input.nextInt();
        int x3 = input.nextInt(); int y3 = input.nextInt();

        System.out.println(compare(x1, x2, x3)+" "+compare(y1, y2, y3));

    }
    public static int compare(int a, int b, int c) {
        if(a==b) return c;
        if (b==c) return a;
        return b;
    }
}
