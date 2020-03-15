#include <iostream>
#include <string>
using namespace std;

int n, m; 

// len: 현재까지의 길이 m이면 return 
// prev: 이전에 압력된 값, 그 값보다 큰 값부터 트래킹해야함
void backTracking(int len, int prev, string printVal) {
    if (len == m) {
        cout << printVal + '\n';
        return;
    }
    // 길이가 m이 되기 위해 남은 길이 (계산의 효율성을 위해)
    int left = m - len;
    for(int i=prev+1; i<=n-left+1; i++){
        string temp = printVal+to_string(i)+" ";
        backTracking(len+1, i, temp);
    }
}

int main() {

    cin >> n >> m;
    backTracking(0, 0, "");
    return 0;
}