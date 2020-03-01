#include <iostream>
#include <stack>
#include <string>
#include <cmath>
using namespace std;

int main() {
    
    stack<char> opStack;
    string str;
    getline(cin, str);

    int size = str.size();
    long long result = 0;
    int temp = 1;
    bool flag = false;

    for(int i=0;i<size;i++){
        char c = str.at(i);
        if(c == '(') {
            temp *= 2;
            opStack.push(c);
        } else if(c == '[') {
            temp *= 3;
            opStack.push(c);
        } else if(c == ')') {
            if(opStack.empty() || opStack.top() != '(') {
                flag = true;
                break;
            } else {
                if(str.at(i-1) == '(') result += temp;
                opStack.pop();
                temp /= 2;
            }
        } else if(c == ']') {
            if(opStack.empty() || opStack.top() != '[') {
                flag = true; 
                break;
            } else {
                if(str.at(i-1) == '[') result += temp;
                opStack.pop();
                temp /= 3;
            }
        }
    }
    if(flag || !opStack.empty()) cout << 0 << endl;
    else cout << result << endl;

    return 0;
}