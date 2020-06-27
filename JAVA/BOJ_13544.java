import java.util.*;
import java.io.*;

public class BOJ_13544 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tok = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tok.nextToken());
        int[] arr = new int[n];

        tok = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) arr[i] = Integer.parseInt(tok.nextToken());
        MergeSortTree mst = new MergeSortTree(n, arr);

        tok = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(tok.nextToken());
        int ans = 0;
        for(int i=0;i<m;i++) {
            tok = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(tok.nextToken()) ^ ans;
            int end = Integer.parseInt(tok.nextToken()) ^ ans;
            int k = Integer.parseInt(tok.nextToken()) ^ ans;
            ans = mst.getGreater(start-1, end-1, 1, 0, n-1, k);
            bw.write(ans  + "\n");
        }
        bw.flush();
        bw.close();
    }
}

class MergeSortTree {
    int n;
    int[] arr;
    ArrayList<Integer>[] tree;

    MergeSortTree(int n, int[] arr) {
        this.n = n;
        this.arr = arr;
        this.tree = new ArrayList[n * 4];
        this.init(0, n-1, 1);
    }

    public ArrayList<Integer> init(int left, int right, int pos) {
        // in the case of the leaf node
        if (left == right) {
            tree[pos] = new ArrayList<>();
            tree[pos].add(arr[left]);
            return tree[pos];
        }
        int mid = (left + right) / 2;
        ArrayList<Integer> leftArr = init(left, mid, pos * 2);
        ArrayList<Integer> rightArr = init(mid+1, right, pos * 2 + 1);
        return tree[pos] = merge(leftArr, rightArr);
    }

    public int getGreater(int left, int right, int pos, int posLeft, int posRight, int val) {
        if (right < posLeft || posRight < left) return 0;
        if (left <= posLeft && posRight <= right) return tree[pos].size() - upper_bound(tree[pos], val);
        int mid = (posLeft + posRight) / 2;
        return getGreater(left, right, pos * 2, posLeft, mid, val)
                + getGreater(left, right, pos * 2 + 1, mid+1, posRight, val);
    }

    public static int upper_bound(ArrayList<Integer> arrayList, int val) {
        int len = arrayList.size();
        int left = 0, right = len-1, mid = 0;
        while(left < right) {
            if (arrayList.get(mid) <= val) left = mid + 1;
            else right = mid;
            mid = (left + right) / 2;
            if (mid == right) {
                if (arrayList.get(mid) <= val) return len;
                else return right;
            }
        }
        if(arrayList.get(left) > val) return 0;
        else return left + 1;
    }

    public ArrayList<Integer> merge(ArrayList<Integer> leftArr, ArrayList<Integer> rightArr) {
        ArrayList<Integer> returnArr = new ArrayList<>();
        int i=0, j=0, leftLen = leftArr.size(), rightLen = rightArr.size();
        while(i < leftLen && j < rightLen) {
            if (leftArr.get(i) <= rightArr.get(j)) {
                returnArr.add(leftArr.get(i));
                i++;
            } else {
                returnArr.add(rightArr.get(j));
                j++;
            }
        }
        while(i < leftLen) {
            returnArr.add(leftArr.get(i));
            i++;
        }
        while(j < rightLen) {
            returnArr.add(rightArr.get(j));
            j++;
        }
        return returnArr;
    }
}
