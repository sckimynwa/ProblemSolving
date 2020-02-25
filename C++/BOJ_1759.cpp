#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
using namespace std;

bool check_words(string str) {
    int len = str.length();
    int c = 0; int v = 0;
    for(int i=0;i<len;i++){
        if(str[i] == 'a' || str[i] == 'e' || str[i] == 'i' || str[i] == 'o' || str[i] =='u') v++;
        else c++;
        if(c >= 2 && v >=1) return true;
    }
    return false;
}

void print_available_kind(const vector<char> &char_list, string str, int l, int c, int index) {
    string s(1, char_list[index]);
    str += s;

    if(str.length() == l) {
        if(check_words(str)) cout << str << endl;
        return;
    }

    for(int i=index+1; i<c;i++){
        print_available_kind(char_list, str, l, c, i);
    }
}

int main() {

    int l, c;
    cin >> l >> c;
    
    vector<char> char_list(c);
    for(int i=0;i<c;i++) cin >> char_list[i];
    sort(char_list.begin(), char_list.end());

    for(int i=0;i<c-l+1;i++){
        string s = "";
        print_available_kind(char_list, s, l, c, i);
    }

    return 0;
}