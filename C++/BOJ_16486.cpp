#include <iostream>
using namespace std;

int main() {

    double d1, d2;
    cin >> d1 >> d2;

    double result = (2*d1) + (3.141592 * 2 * d2);
    printf("%.6f\n", result);

    return 0;
}