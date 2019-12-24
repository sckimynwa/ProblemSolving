#include <iostream>
#include <cmath>
using namespace std;

int main() {
    
    int a, b;
    cin >> a >> b;
    
    int ans1 = (-2*a + sqrt(4*a*a - 4*b) )/2;
    int ans2 = (-2*a - sqrt(4*a*a - 4*b) )/2;

    if(ans1 == ans2)
        cout << ans1 << endl;
    else if(ans1 > ans2) 
        cout << ans2 << " " << ans1 << endl;
    else
        cout << ans1 << " " << ans2 << endl;

    return 0;
}
