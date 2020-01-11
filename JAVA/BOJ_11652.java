import java.util.*;
public class BOJ_11652 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();

        for(int i=0;i<n;i++){
            long k = input.nextLong();
            if(map.get(k) == null) {
                map.put(k, 1);
            } else {
                int value = map.get(k);
                map.replace(k, value+1);
            }
        }

        long maxKey = Long.MIN_VALUE; int max = -1;
        for(long key: map.keySet()) {
            if(map.get(key) > max) {
                maxKey = key;
                max = map.get(key);
            } else if (map.get(key) == max) {
                if( maxKey > key) {
                    maxKey = key;
                }
            }
        }
        System.out.println(maxKey);
    }
}
