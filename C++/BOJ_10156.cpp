#include <stdio.h>

int main() {
    
    int cookie, n, money;
    scanf("%d %d %d", &cookie, &n, &money);

    int total = cookie*n;
    if(total > money) {
        printf("%d", total-money);
    } else {
        printf("%d", 0);
    }
    return 0;
}
