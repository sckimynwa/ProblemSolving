#include<iostream>
#include<string>
using namespace std;

int main() {
    int n;
    cin >> n;
    for(int i=0;i<n;i++){
        int k;
        cin >> k;
        string retStr = "Pairs for " + to_string(k) + ":";
        for(int j=1;j<k/2 + 1;j++){
            if(j != k-j) {
                retStr += " "+to_string(j)+" "+to_string(k-j)+",";
            }
        }
        int len = retStr.length();
        if(len>12) {
            retStr = retStr.substr(0, len-1);
        }
        cout << retStr << endl;
    }

    return 0;
}
