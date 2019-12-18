#include <iostream>
using namespace std;

int main() {
	int n;
	cin >> n;
	if(n%2 == 1) cout << 0 << endl;
	else {
		n /= 2;
		if(n%2 == 1) cout << 1 << endl;
		else cout << 2 << endl;
	}
}
