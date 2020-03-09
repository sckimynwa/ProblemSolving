#include <iostream>
#include <string>
#include <vector>

using namespace std;

vector<int> getPi(string str) {
    int len = (int)str.size(), j=0;
    vector<int> pi(len, 0);
    for(int i=1;i<len;i++){
        while(j>0 && str[i] != str[j]) j = pi[j-1];
        if(str[i] == str[j]) pi[i] = ++j;
    }
    return pi;
}

int kmp(string s, string p) {
    int cnt = 0;
    vector<int>pi = getPi(p);
    int n = (int)s.size(), m = (int)p.size(), j=0;
    for(int i=0;i<n;i++){
        while(j>0 && s[i] != p[j]) j = pi[j-1];
        if(s[i] == p[j]) {
            if(j == m-1) {
                cnt ++;
                j = pi[j];
            } else {
                j++;
            }
        }
    }
    return cnt;
}

int main() {
    string str;
    getline(cin, str);

    int len = (int)str.size();
    int ans = 0;
    for(int i=1; i<=len;i++){
        bool flag = false; // 해당 길이에서 2개 이상나오는 부분 문자열이 없으면 그 전 길이가 최대임
        // i = length of the substring
        for(int j=0;j<len-i+1;j++){
            string subStr = str.substr(j, i);
            int cnt = kmp(str, subStr);
            if(cnt > 1) {
                ans = i;
                flag = true;
                break;
            }
        }
        if(!flag) break;
    }

    cout << ans << endl;

    return 0;
}