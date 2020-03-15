#include <iostream>
using namespace std;

int main() {

    long dp[101];
    dp[0]=0;dp[1]=1;dp[2]=1;dp[3]=1;dp[4]=2;
    for(int i=5;i<101;i++){
        dp[i] = dp[i-1] + dp[i-5];
    }

    int n;
    cin >> n;
    for(int i=0;i<n;i++){
        int k;
        cin >> k;
        cout << dp[k] << endl;

    }
    return 0;
}