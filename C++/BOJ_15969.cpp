#include <iostream>
using namespace std;

int main() {
    int n, k;
    cin >> n;
    int max = -1; int min = 1001;

    for(int i=0;i<n;i++){
       cin >> k;
       if(k>max) max = k;
       if(k<min) min = k;
    }

    cout << max-min << endl;
    return 0;
}