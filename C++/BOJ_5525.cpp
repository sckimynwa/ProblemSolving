#include <iostream>
#include <string>
#include <cstdio>
#include <vector>

using namespace std;

vector<int> getPi(string str) {
   int len = (int)str.size(), j=0;
   vector<int> pi(len, 0);
   for(int i=1; i<len; i++){
       while(j>0 && str[i] != str[j]) j = pi[j-1];
       if(str[i] == str[j]) pi[i] = ++j;
   }
   return pi;
}

int kmp(string s, string p) {
    int cnt = 0;
    vector<int> pi = getPi(p);
    int n = (int)s.size(), m = (int)p.size(), j=0;
    for(int i=0;i<n;i++){
        while(j>0 && s[i] != p[j]) j = pi[j-1];
        if(s[i] == p[j]) {
            if(j == m-1) {
                cnt++;
                j = pi[j];
            } else {
                j++;
            }
        }
    }
    return cnt;
}

string convert(int n) {
    string retStr = "";
    for(int i=0;i<n;i++) retStr += "IO";
    retStr += "I";
    return retStr;
}

int main() {
    int n, m;
    cin >> n >> m;
    string s;
    cin >> s;

    string p = convert(n);
    int ans = kmp(s, p);
    cout << ans << endl;

    return 0;
}