#include <iostream>
using namespace std;

int main() {
    int n;
    cin >> n;

    int cnt = 0;
    while (n>0) {
        if (n>5) {
            cnt++;
            n-=5;
        } else {
            cnt++;
            break;
        }
    }

    cout << cnt;
    return 0;
}