import java.util.*;
import java.io.*;
import java.math.*;

public class BOJ_2357 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        long[] arr = new long[n];
        for(int i=0;i<n;i++){
            arr[i] =
            arr[i] = Long.parseLong(br.readLine().trim());
        }

        MinSegTree minTree = new MinSegTree(arr, n);
        MaxSegTree maxTree = new MaxSegTree(arr, n);

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<m;i++){
            token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            long min = minTree.query(a-1, b-1, 1, 0, n-1);
            long max = maxTree.query(a-1, b-1, 1, 0, n-1);
            sb.append(min).append(" ");
            sb.append(max).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

class MinSegTree {
    long[] segArr;
    int size;

    MinSegTree(long[] arr, int size) {
        segArr = new long[size*4];
        this.size = size;
        Arrays.fill(segArr, Long.MAX_VALUE);
        init(arr, 0, size-1, 1);
    }

    public long init(long[] arr, int left, int right, int node) {
        if(left == right) return segArr[node] = arr[left];
        int mid = (left + right)/2;
        return segArr[node] = Math.min(init(arr, left, mid, node*2), init(arr, mid+1, right, node*2+1));
    }

    public long query(int start, int end, int node, int nodeLeft, int nodeRight) {
        if(start > nodeRight || end < nodeLeft) return Long.MAX_VALUE;
        if(start <= nodeLeft && end >= nodeRight) return segArr[node];
        int mid = (nodeLeft + nodeRight) /2;
        return Math.min(query(start, end, node*2, nodeLeft, mid), query(start, end, node*2+1, mid+1, nodeRight));
    }
}

class MaxSegTree {
    long[] segArr;
    int size;

    MaxSegTree(long[] arr, int size) {
        segArr = new long[size*4];
        this.size = size;
        Arrays.fill(segArr, Long.MIN_VALUE);
        init(arr,0, size-1, 1);
    }

    public long init(long[] arr, int left, int right, int node) {
        if(left == right) return segArr[node] = arr[left];
        int mid = (left + right)/2;
        return segArr[node] = Math.max(init(arr, left, mid, node*2), init(arr, mid+1, right, node*2+1));
    }

    public long query(int start, int end, int node, int nodeLeft, int nodeRight) {
        if(start > nodeRight || end < nodeLeft) return Long.MIN_VALUE;
        if(start <= nodeLeft && end >= nodeRight) return segArr[node];
        int mid = (nodeLeft + nodeRight) /2;
        return segArr[node] = Math.max(query(start, end, node*2, nodeLeft, mid), query(start, end, node*2+1, mid+1, nodeRight));
    }
}
