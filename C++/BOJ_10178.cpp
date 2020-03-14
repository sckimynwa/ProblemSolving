#include <iostream>
#include <cstdio>
using namespace std;

int main() {
    int n;
    cin >> n;
    for(int i=0;i<n;i++){
        int tot, num;
        cin >> tot >> num;
        int child = (int)(tot/num);
        int dad = (int)(tot % num);
        printf("You get %d piece(s) and your dad gets %d piece(s). \n", child, dad);
    }
    return 0;
}