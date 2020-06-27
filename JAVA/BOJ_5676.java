import java.util.*;

public class BOJ_5676 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNextLine()) {
            int n = input.nextInt();
            int m = input.nextInt();
            MultFenwickTree fenwickTree = new MultFenwickTree(n+1);
            for(int i=1;i<=n;i++){
                fenwickTree.update(i, input.nextInt());
            }
            for(int i=0;i<m;i++){
                char command = input.next().charAt(0);
                if(command == 'C') {
                  int pos = input.nextInt();
                  int val = input.nextInt();
                } else {
                  int pos1 = input.nextInt();
                  int pos2 = input.nextInt();
                }
            }
        }
    }
}

class MultFenwickTree {
    private int n;
    private char tree[];

    MultFenwickTree(int n) {
        this.n = n;
        this.tree = new char[n];
        for(int i=0;i<n;i++) tree[i] = '+'; // default 1
    }

    public char mult(int pos) {
        char result = '0';
        return result;
    }

    public void update(int pos, int val) {
        while(pos <= n) {

            pos += (pos & -pos);
        }
    }
}