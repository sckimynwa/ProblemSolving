#include <iostream>
#include <cmath>
using namespace std;

int main() {
    double n, k;
    while(true){
        cin >> n >> k;
        if(cin.eof()) break;
        double result = n/k;    
        cout << round(result * 100) / 100 << endl;
    }
    return 0;
}
