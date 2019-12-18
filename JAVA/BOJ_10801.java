import java.util.*;
public class BOJ_10801 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cnt1 = 0;
        int cnt2 = 0;
        int[] arr1 = new int[10];
        int[] arr2 = new int[10];
        for(int i=0;i<10;i++){arr1[i] = input.nextInt();}
        for(int i=0;i<10;i++){arr2[i] = input.nextInt();}

        for(int i=0;i<10;i++){
            if(arr1[i]>arr2[i]) cnt1++;
            else if(arr1[i]<arr2[i])cnt2++;
        }
        if(cnt1>cnt2) System.out.println("A");
        else if(cnt1<cnt2) System.out.println("B");
        else System.out.println("D");
    }
}
