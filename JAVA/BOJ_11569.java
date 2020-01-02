import java.util.*;
public class BOJ_11569 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) arr[i] = input.nextInt();

        SumSegTree segTree = new SumSegTree(arr, n);
        for(int i=0;i<m;i++){
            int a = input.nextInt();
            int b = input.nextInt();
            System.out.println(segTree.query(a-1, b-1, 1, 0, n-1));
        }
    }
}

class SumSegTree {
    int[] segArr;
    int size;

    SumSegTree(int[] arr, int size) {
        segArr = new int[size*4];
        this.size = size;
        init(arr, 0, size-1, 1);
    }

    public int init(int arr[], int left, int right, int node) {
        if (left == right) return segArr[node] = arr[left];
        int mid = (left+right)/2;
        return segArr[node] = init(arr, left, mid, node*2) + init(arr, mid+1, right, node*2+1);
    }

    public int query(int start, int end, int node, int nodeLeft, int nodeRight) {
        if (start > nodeRight || end < nodeLeft) return 0;
        if (start <= nodeLeft && end >= nodeRight) return segArr[node];
        int mid = (nodeLeft + nodeRight) / 2;
        return query(start, end, node*2, nodeLeft, mid) + query(start, end, node*2+1, mid+1, nodeRight);
    }
}
