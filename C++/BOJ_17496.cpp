#include <iostream>
using namespace std;

int main() {
    int n, t, c, p;
    cin >> n >> t >> c >> p;
    int cnt = (int)((n-1)/t);
    cout << cnt * c * p;
    return 0;
}