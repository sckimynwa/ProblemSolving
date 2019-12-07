import java.util.*;

public class BOJ_15649 {

    static boolean[] flag;
    static int n, m;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        m = input.nextInt();
        flag = new boolean[n];

        for(int i=0;i<n;i++){
            dfs(i, 0, "");
        }
    }

    public static void dfs(int num, int cnt, String str) {
        flag[num] = true;
        cnt++;
        str += String.valueOf(num+1) + " ";

        if(cnt == m) {
            System.out.println(str);
            flag[num] = false;
            return;
        }

        for(int i=0;i<n;i++){
            if(!flag[i]) {
                dfs(i, cnt, str);
            }
        }

        flag[num] = false;
    }
}
