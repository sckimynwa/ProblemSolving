#include <iostream>
#include <fstream>
#include <string>

using namespace std;

int main() {
	
	int n, m;
	cin >> n >> m;
	
	int bucket[n];
	for(int i=0;i<n;i++){
		bucket[i] = 0;
	}

	for(int i=0;i<m;i++){
		int from, to, no;
		cin >> from >> to >> no;
		for(int j=from-1;j<to;j++){
			bucket[j] = no;
		}
	
	}

	for(int i=0;i<n;i++){
		cout << bucket[i] << " ";
	}
	
	return 0;
}
