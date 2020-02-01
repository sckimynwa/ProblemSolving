#include <stdio.h>
#include <string.h>
using namespace std;

int main() {

    int n, x;
    scanf("%d", &n);

    int set = 0; // bitmask for representing set.
    char op[10] = {};

    for(int i=0;i<n;i++){
        scanf("%s", op);

        if(!strcmp(op, "add")) {
            scanf("%d", &x);
            set |= (1 << (x-1));
        }
        else if(!strcmp(op, "remove")) {
            scanf("%d", &x);
            set &= ~(1 << (x-1));
        }
        else if(!strcmp(op, "check")) {
            scanf("%d", &x);
            int comp = (1 << (x-1));
            if((set & comp) == comp) {
                printf("%d\n", 1);
            } else {
                printf("%d\n", 0);
            }
        }
        else if(!strcmp(op, "toggle")) {
            scanf("%d", &x);
            set ^= (1 << (x-1));
        }
        else if(!strcmp(op, "all")) {
            set = (1 << 20) - 1;
        }
        else if(!strcmp(op, "empty")) {
            set = 0;
        }
    }

    return 0;
}