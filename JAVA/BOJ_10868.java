import java.util.*;
import java.math.*;
public class BOJ_10868 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int m = input.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)arr[i] = input.nextInt();

        MinSegTree segTree = new MinSegTree(arr, n);

        for(int i=0;i<m;i++){
            int a = input.nextInt();
            int b = input.nextInt();
            System.out.println(segTree.query(a-1, b-1, 1, 0, n-1));
        }


    }
}

class MinSegTree {
    long segArr[];

    MinSegTree(int[] arr, int arrSize) {
        this.segArr = new long[arrSize * 4];
        Arrays.fill(segArr, Integer.MAX_VALUE);
        init(arr, 0, arrSize-1, 1);
    }

    long init(int arr[], int left, int right, int node) {
        if (left == right) return segArr[node] = arr[left]; // leaf node case;
        int mid = (left+right)/2;
        return segArr[node] = Math.min(init(arr, left, mid, node*2), init(arr, mid+1, right, node*2+1));
    }

    long query(int sIdx, int eIdx, int node, int nodeLeft, int nodeRight) {
        if (sIdx > nodeRight || eIdx < nodeLeft) return Integer.MAX_VALUE;
        if (sIdx <= nodeLeft && eIdx >= nodeRight) return segArr[node];
        int mid = (nodeLeft + nodeRight) / 2;
        return Math.min(query(sIdx, eIdx, node*2, nodeLeft, mid), query(sIdx, eIdx, node*2 +1, mid+1, nodeRight));
    }
}
