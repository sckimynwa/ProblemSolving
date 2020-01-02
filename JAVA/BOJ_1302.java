import java.util.*;
public class BOJ_1302 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();

        Map<String, Integer> map = new HashMap();
        for(int i=0;i<n;i++){
            String str = input.nextLine().trim();
            if(map.get(str) != null) {
                int k = map.get(str);
                map.replace(str, k+1);
            } else {
                map.put(str, 1);
            }
        }

        int max = -1;
        for(String key : map.keySet()) {
            int val = map.get(key);
            if(val > max) {
                max = val;
            }
        }

        ArrayList<String> list = new ArrayList<>();

        for(String key: map.keySet()) {
            int val = map.get(key);
            if(val == max) {
                list.add(key);
            }
        }

        Collections.sort(list);
        System.out.println(list.get(0));
    }
}
