#include <iostream>
#include <cstring>
#include <string>
using namespace std;

int main()
{
    int N;
    cin >> N;

    string s;
    for(int i = 0; i < 2*N-1; i++) s.append("*");
    string::iterator fo = s.begin();
    string::iterator ba = s.end();

    cout << s << endl;
    for(int i = 0; i < N-1; i++) {
        s.erase(fo+i, fo+i+1);
        s.insert(i, " ");
        s.erase(ba-i-1, ba-i);
        cout << s  << endl;
    }
    for(int i = N-1; i > 0; i--) {
        s.erase(fo+i-1, fo+i);
        s.insert(i-1, "*");
        s.append("*");
        cout << s << endl;
    }

    return 0;
}