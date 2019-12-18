#include<iostream>
using namespace std;

int main() {
	int n;
	cin >> n;

	int cnt = 0;
	for(int i=1;i<=500;i++){
		for(int j=i;j<=500;j++){
			if(i!=j) {
				if((j*j) - (i*i) == n) cnt++;
			}
		}
	}

	cout << cnt << endl;
}
