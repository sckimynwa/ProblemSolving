#include <iostream>
using namespace std;

int main() {
	int a3, a2, a1, b3, b2, b1;
	cin >> a3 >> a2 >> a1 >> b3 >> b2 >> b1;
	int tota = a3*3 + a2*2 + a1;
	int totb = b3*3 + b2*2 + b1;
	if(tota == totb) cout << "T" << endl;
	else if(tota > totb) cout << "A" << endl;
	else cout << "B" << endl;
}
