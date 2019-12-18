#include <iostream>
#include <fstream>
using namespace std;

int main() {
	int n;
	cin >> n;

	int cnt = 1;
	int sec = 0;
	while(true) {
		if(n == 0) break;
		if(n < cnt) cnt = 1;
		n -= cnt;
		sec++;
		cnt++;
	}

	cout << sec << endl;
}
