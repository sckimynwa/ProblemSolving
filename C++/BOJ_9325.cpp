#include <iostream>
using namespace std;

int main() {

    int n;
    cin >> n;
    for (int i=0;i<n;i++){
        int option, carVal;
        cin >> carVal >> option;
        for(int j=0;j<option;j++){
            int num, val;
            cin >> num >> val;
            carVal += (num * val);
        }
        cout << carVal << '\n';
    }

    return 0;
}