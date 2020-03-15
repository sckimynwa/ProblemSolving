#include <iostream>
#include <string>
using namespace std;

int n, m;

void backTracking(int len, string retStr) {
    if (len == m) {
        cout << retStr + "\n";
        return;
    }
    for(int i=1;i<=n;i++){
        string temp = retStr + to_string(i) + " ";
        backTracking(len+1, temp);
    }
}

int main() {

    cin >> n >> m;
    backTracking(0, "");
    return 0;
}