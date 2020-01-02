#include <stdio.h>
using namespace std;

int main() {
    int n;
    scanf("%d", &n);
    
    // input
    int arr[n][n];
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            scanf("%d", &arr[i][j]);
        }
    }

    // calculate
    int k = n;
    while(k > 1) {
        k /= 2;
        for(int i=0;i<k;i++){
            for(int j=0;j<k;j++){
                
            }
        }
    }

    return 0;
}
