#include <iostream>
using namespace std;

int main() {
    
    int n;
    cin >> n;
    for(int i=0;i<n;i++){
        long a, b;
        cin >> a >> b;

        long c = a;
        for(long j=a+1;j<=b;j++){
            c = c ^ j;
        }
        cout << c << endl;
    }
    return 0;
}
