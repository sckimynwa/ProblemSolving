import java.util.*;

public class BOJ_1931 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Conference[] conf = new Conference[n];

        for(int i=0;i<n;i++){
            int start = input.nextInt();
            int end = input.nextInt();
            conf[i] = new Conference(start, end);
        }

        Arrays.sort(conf);
        int ans = 0; int endTime = 0;
        for(int i=0;i<n;i++){
           if(conf[i].start >= endTime) {
               ans++;
               endTime = conf[i].end;
           }
        }
        System.out.println(ans);
    }
}

class Conference implements Comparable<Conference>{
    int start, end;
    Conference(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Conference o) {
        if(this.end < o.end) return -1;
        else if(this.end == o.end) {
            if(this.start < o.start) return -1;
            return 1;
        }
        return 1;
    }
}
