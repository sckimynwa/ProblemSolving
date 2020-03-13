#include <iostream>
#include <math.h>
#include <algorithm>
using namespace std;

int main() {

    int n, k;
    cin >> n >> k;

    int dp[k+1], w[n], v[n];
    fill_n(dp, k+1, 0);
    fill_n(w, n, 0);
    fill_n(v, n, 0);
    for(int i=0;i<n;i++){
        cin >> w[i] >> v[i];
        for(int j=k; j>=1; j--) {
            if(j >= w[i]) {
                dp[j] = max(dp[j], dp[j-w[i]]+v[i]);
            }
        }
    }

    cout << dp[k] << endl;
    return 0;
}
