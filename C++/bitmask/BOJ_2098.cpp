#include <stdio.h>
#include <string.h>
#include <algorithm>
using namespace std;

const static int INF = 99999999;

int n;
int map[16][16];
int memo[16][1<<16]; // bitmask

int tsp(int cur, int visited) {
    int& ret = memo[cur][visited];
    if(ret!=-1) return ret;

    // visited all cities
    if(visited == (1<<n)-1) {
        if(map[cur][0] != 0) return map[cur][0];
        else return INF;
    }

    ret = INF;
    for(int i=0;i<n;i++){
        if(map[cur][i] && !(visited & (1 << i))) {
            int visit = visited | (1 << i);
            ret = min(ret, tsp(i, visit) + map[cur][i]);
        }
    }
    return ret;
}

int main() {

    scanf("%d", &n);
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            scanf("%d", &map[i][j]);
        }
    }

    memset(memo, -1, sizeof(memo));
    printf("%d", tsp(0, 1));

    return 0;
}