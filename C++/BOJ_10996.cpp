#include <iostream>
#include <string>
using namespace std;

int main() {

    int n;
    cin >> n;
    
    for(int i=0;i<2*n;i++){
        string str = "";
        if(i%2 == 0) {
            for(int j=0;j<n;j++){
                if(j%2 == 0) str += "*";
                else str+= " ";
            }
        } else {
            for(int j=0;j<n;j++){
                if(j%2 == 0) str += " ";
                else str+= "*";
            }
        }
        cout << str << endl;
    }

    return 0;
}