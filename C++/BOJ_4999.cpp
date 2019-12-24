#include <iostream>
#include <string>
using namespace std;

int main() {
    
    string pat, doc;
    cin >>  pat >>  doc;

    if(pat.length() >= doc.length())
        cout << "go" << endl;
    else
        cout << "no" << endl;
    
    return 0;
}
