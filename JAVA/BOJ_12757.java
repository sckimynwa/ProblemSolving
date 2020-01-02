import java.util.*;
public class BOJ_12757 {
    static Map<Integer, Integer> map;

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int k = input.nextInt();

        map = new HashMap<>();
        for(int i=0;i<n;i++){
            int key = input.nextInt();
            int value = input.nextInt();
            map.put(key, value);
        }

        for(int i=0;i<m;i++){
            int method = input.nextInt();
            if (method == 1) {
                int key = input.nextInt();
                int value = input.nextInt();
                map.put(key, value);
            } else if (method == 2) {
                int key = input.nextInt();
                int replaceVal = input.nextInt();
                int index = findKey(key, k);
                if(index >= 0) {
                    map.replace(index, replaceVal);
                }
            } else {
                int key = input.nextInt();
                int index = findKey(key, k);
                if(index == -1) {
                    System.out.println(-1);
                } else if(index == -2) {
                    System.out.println("?");
                } else {
                    System.out.println(map.get(index));
                }
            }
        }
    }

    public static int findKey(int key, int k) {
        for(int i=0;i<=k;i++){
            if(map.get(key+i) != null) {
                // k is not 0 and duplicate key exists case
                if(i!=0 && map.get(key-i) != null) {
                    return -2;
                }
                return key+i;
            } else if(map.get(key-i) != null) {
                return key-i;
            }
        }
        return -1;
    }
}
