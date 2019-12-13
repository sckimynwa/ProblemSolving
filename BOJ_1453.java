import java.util.*;

public class BOJ_1453 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        HashMap<Integer, Boolean> map = new HashMap();

        int ans = 0;
        for(int i=0;i<n;i++){
            int k = input.nextInt();
            if(map.get(k) != null) ans++;
            else map.put(k, true);
        }
        System.out.println(ans);
    }
}
