#include <iostream>
#include <string>
using namespace std;

int n, m;

void backTracking(int len, int prev, string retStr) {
    if (len == m) {
        cout << retStr + "\n";
        return;
    }
    for(int i=prev;i<=n;i++){
        string temp = retStr + to_string(i) + " ";
        backTracking(len+1, i, temp);
    }
}

int main() {

    cin >> n >> m;
    backTracking(0, 1, "");
    return 0;
}