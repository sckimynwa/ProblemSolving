#include <iostream>
#include <string>
using namespace std;

int main() {
    string str;
    int len;
    cin >> len >> str;

    int cnt = 0;
    int bonus = 0;
    for(int i=0;i<len;i++){
        if(str[i] == 'O') {
            cnt += (i+1);
            cnt += bonus;
            bonus++;
        } else {
            bonus = 0;
        }
    }

    cout << cnt << endl;
    return 0;
}