#include <iostream>
#include <climits>
using namespace std;

int main() {

    int n, m;
    cin >> n >> m;
    
    long arr[n];
    for(int i=0;i<n;i++){
        cin >> arr[i];
    }

    for(int i=0;i<m;i++){
        long from, to;
        long max = -1;
        long min = LONG_MAX;
        cin >> from >> to;
        for(int j=from-1; j<to;j++){
            if(max < arr[j]) max = arr[j];
            if(min > arr[j]) min = arr[j];
        }
        cout << min << " " << max << endl;
    }

    return 0;
}
