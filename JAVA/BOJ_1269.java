import java.util.*;
public class BOJ_1269 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n1 = input.nextInt();
        int n2 = input.nextInt();

        HashMap<Integer, Boolean> mapA = new HashMap<>();
        HashMap<Integer, Boolean> mapB = new HashMap<>();
        for(int i=0;i<n1;i++){ mapA.put(input.nextInt(), true); }
        for(int i=0;i<n2;i++){ mapB.put(input.nextInt(), true); }

        ArrayList<Integer> AminB = new ArrayList<>();
        ArrayList<Integer> BminA = new ArrayList<>();

        for(int aKey: mapA.keySet()) {
            if(mapB.get(aKey) == null) {
                AminB.add(aKey);
            }
        }

        for(int bKey: mapB.keySet()) {
            if(mapA.get(bKey) == null) {
                BminA.add(bKey);
            }
        }

        System.out.println(AminB.size()+BminA.size());
    }
}
