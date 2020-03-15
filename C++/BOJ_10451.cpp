#include <iostream>
#include <map>
using namespace std;

int main() {

    int n;
    cin >> n;
    for(int i=0;i<n;i++){
        int num;
        cin >> num;
        map<int, int> orderMap;

        // cnt는 모든 수열을 다 돌았는지를 확인하기 위한 값.
        // ans는 사이클의 개수 (출력해야 하는 값).
        int cnt = 0, ans = 1;

        bool orderArr[num + 1];
        fill_n(orderArr, num+1 , false);
        for(int i=1;i<=num;i++){
            int val;
            cin >> val;
            orderMap.insert(pair<int, int>(i, val));
        }

        // arr에 있는 첫번째 값으로 사이클 개수 구하기 시작
        int ptr = 1;
        while(true) {
            orderArr[ptr] = true;
            cnt++;

            if (cnt >= num) {
                break;
            }

            // update ptr
            ptr = orderMap.find(ptr)->second;
            if (orderArr[ptr]) {
                // 한바퀴 돌았을 경우
                ans++;
                for(int i=1;i<num+1;i++){
                    if (!orderArr[i]) {
                        ptr = i;
                        break;
                    }
                }
            }
        }

        cout << ans << endl;
    }

    return 0;
}