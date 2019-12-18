#include <iostream>
using namespace std;

int main() {
	int n, m, num;
	cin >> n >> m >> num;

	int x = num/m;
	int y = num % m;

	cout << x << " " << y << endl;
}
