#include <iostream>
using namespace std;

int postOrder[100001];
int inOrder[100001];
int findRoot[100001];
int n;

void calc(int start, int end, int start2, int end2) {
    if (start > end) return;
    int root = postOrder[end2];
    cout << root << " ";
    int pos = findRoot[root];
    calc(start, pos - 1, start2, start2 + (pos - 1 - start));
    calc(pos + 1, end, start2 + pos - start, end2 - 1);
    return;
}

int main() {

    cin >> n;
    for(int i=0;i<n;i++){
        cin >> inOrder[i];
        findRoot[inOrder[i]] = i;
    }
    for(int i=0;i<n;i++) cin >> postOrder[i];
    calc(0, n-1, 0, n-1);
    return 0;
}