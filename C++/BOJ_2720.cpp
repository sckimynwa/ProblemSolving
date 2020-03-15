#include <iostream>
using namespace std;

int main() {

    int n;
    cin >> n;
    for(int i=0;i<n;i++){
        int money;
        cin >> money;
        int q=0, d=0, n=0, p=0;
        
        q = (int)(money/25);
        money -= q * 25;
        d = (int)(money/10);
        money -= d * 10;
        n = (int)(money/5);
        money -= n * 5;
        p = money;

        cout << q << " " << d << " " << n << " " << p << '\n';
    }

    return 0;
}