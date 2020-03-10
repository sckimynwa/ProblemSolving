#include <iostream>
#include <vector>
using namespace std;

int main() {
    int n;
    cin >> n;
    int max = -1;
    for(int i=0;i<n;i++){
        int k;
        cin >> k;
        if(k > max) max = k;
    }
    cout << max << endl;
    return 0;
}