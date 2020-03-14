#include <iostream>
using namespace std;

int main() {

    int n;
    cin >> n;
    int dp[200];
    // dp calculation
    dp[0]=1; dp[1]=1; dp[2]=5; dp[3]=11;
    for(int i=4;i<200;i++){
        dp[i] = dp[i-1] + 5*dp[i-2] + dp[i-3] - dp[i-4];
    }

    for(int i=0;i<n;i++){
        int k;
        cin >> k;
        cout << dp[k] << endl;
    }

    return 0;
}