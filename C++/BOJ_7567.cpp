#include <iostream>
#include <string>
using namespace std;

int main() {
    
    string str;
    cin >> str;
    
    int n = str.length();
    int len = 0;
    char buf = ' ';

    for(int i=0;i<n;i++) {
        char in = str.at(i);
        if(i==0) {
            buf = in;
            len += 5;
            if(i==n-1) len += 5; // case where n = 1;
        } else {
            if(in == buf) {
                len += 5;
                if(i==n-1) len+= 5;
            } else {
                buf = in;
                len += 10;
                if(i==n-1) len += 5;
            }
        }

    }
    cout << len << endl;

    return 0;
}
