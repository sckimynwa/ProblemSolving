#include <iostream>
#include <fstream>
#include <string>

using namespace std;

// declare
int game(char p1, char p2);

int main() {
	int n;
	cin >> n;
	
	for(int i=0;i<n;i++){
		int m;
		cin >> m;

		int cnt1 = 0; 
		int cnt2 = 0;
		for(int j=0;j<m;j++){
			char c1, c2;
			cin >> c1 >> c2;
			int result = game(c1, c2);
			if(result == 1) cnt1++;
			else if(result == 2) cnt2++;
		}

		if(cnt1 > cnt2) cout << "Player 1" << endl;
		else if(cnt1 < cnt2) cout << "Player 2" << endl;
		else cout << "TIE" << endl;
	}
}

int game(char p1, char p2) {
	if(p1 == 'R') {
		if(p2 == 'R') return 0;
		else if(p2 == 'S') return 1;
		else return 2;
	}
	else if(p1 == 'S') {
		if(p2 == 'R') return 2;
		else if(p2 == 'S') return 0;
		else return 1;
	}
	else {
		if(p2 == 'R') return 1;
		else if(p2 == 'S') return 2;
		else return 0;
	}
	return 0;
}
