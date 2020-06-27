import java.util.*;
import java.io.*;

public class BOJ_6549 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tok;

        while(true) {
            tok = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(tok.nextToken());
            if (n == 0) break;

            long arr[] = new long[n];
            for(int i=0;i<n;i++) arr[i] = Integer.parseInt(tok.nextToken());
            SegmentTree segTree =  new SegmentTree(n, arr);
            long ans = segTree.findMax(0, n-1);
            bw.write(String.valueOf(ans) + "\n");
        }

        bw.flush();
        bw.close();
    }

    static class SegmentTree {
        int n;
        int[] tree;
        long[] arr;
        SegmentTree(int n, long[] arr) {
            this.n = n;
            this.tree = new int[n*4];
            this.arr = arr;
            this.init(0, n-1, 1);
        }

        public int init(int left, int right, int pos) {
            if(left == right) {
                // store min height index
                return tree[pos] = left;
            }
            int mid = (left + right) / 2;
            int leftMinIndex = init(left, mid, pos * 2);
            int rightMinIndex = init(mid + 1, right, pos * 2 + 1);
            if (arr[leftMinIndex] > arr[rightMinIndex]) return tree[pos] = rightMinIndex;
            return tree[pos] = leftMinIndex;
        }

        public int query(int left, int right, int pos, int posLeft, int posRight) {
            if(left > posRight || right < posLeft) return Integer.MAX_VALUE;
            if(left <= posLeft && posRight <= right) return tree[pos];
            int mid = (posLeft + posRight) / 2;
            int leftMinIdx = query(left, right, pos * 2, posLeft, mid);
            int rightMinIdx = query(left, right, pos * 2 + 1, mid + 1, posRight);

            if (leftMinIdx == Integer.MAX_VALUE) return rightMinIdx;
            else if (rightMinIdx == Integer.MAX_VALUE) return leftMinIdx;
            else if(arr[rightMinIdx] < arr[leftMinIdx]) return rightMinIdx;
            return leftMinIdx;
        }

        public long findMax(int left, int right) {
            int idx = query(left, right, 1, 0, n-1);
            long size = (right - left + 1) * arr[idx];

            if(idx > left) {
                long tempSize = findMax(left, idx - 1);
                size = Math.max(size, tempSize);
            }
            if(idx < right) {
                long tempSize = findMax(idx + 1, right);
                size = Math.max(size, tempSize);
            }
            return size;
        }
    }
}