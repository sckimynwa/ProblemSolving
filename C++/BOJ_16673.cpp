#include <stdio.h>

int main() {
    
    int c, k, p;
    scanf("%d%d%d", &c, &k, &p);
    
    long long int sum = 0;
    for(int i=1;i<=c;i++){
        sum += k*i + p*i*i;
    }

    printf("%lld", sum);
    return 0;
}
