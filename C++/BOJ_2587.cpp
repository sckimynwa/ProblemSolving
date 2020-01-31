#include <stdio.h>
#include <algorithm>

using namespace std;
int main() {

    int foo[5];
    int sum = 0;
    for(int i=0;i<5;i++){
        scanf("%d", &foo[i]);
        sum += foo[i];
    }
    
    sort(foo,foo+ 5);
    
    int avg = sum/5;
    printf("%d\n%d\n", avg, foo[2]);

    return 0;
}
