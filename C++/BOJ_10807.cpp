#include <iostream>
using namespace std;

int main() {
    int n, arr[201], find;
    cin >> n;
    fill_n(arr, 201, 0);

    for(int i=0;i<n;i++){
        int val;
        cin >> val;
        arr[val+100] ++;
    }
    cin >> find;

    cout << arr[find+100];
    return 0;
}