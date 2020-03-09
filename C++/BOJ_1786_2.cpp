#include <iostream>
#include <string>
#include <cstdio>
#include <vector>

using namespace std;

// get prefix & suffic arr
vector<int> getPi(string str) {
    int len = (int)str.size(), j=0;
    vector<int> pi(len, 0);
    for(int i=1; i<len;i++){
        while(j>0 && pi[i] != pi[j]) j = pi[j-1];
        if(pi[i] == pi[j]) pi[i] = ++j;
    }
    return pi;
}

// kmp algorithm
vector<int> kmp(string s, string p) {
    vector<int> ans;
    auto pi = getPi(p);
    int n = (int)s.size(), m = (int)p.size(), j=0;
    for(int i=0;i<n;i++){
        while(j>0 && s[i] != p[i]) j = pi[j-1];
        if(s[i] == p[i]) {
            if(j == m-1) {
                ans.push_back(i-m+1);
                j = pi[j];
            } else {
                j++;
            }
        }
    }
    return ans;
}

int main() {
    string s, p;
    getline(cin, s);
    getline(cin, p);

    auto matched = kmp(s, p);
    printf("%d\n", (int)matched.size());
    for(auto i: matched)
        printf("%d", i+1);
        
    return 0;
}