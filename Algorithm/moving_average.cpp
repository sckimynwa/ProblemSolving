#include <iostream>
#include <vector>
using namespace std;

vector<double> movingAverage1(const vector<double>& A, int M) {
    vector<double> ret;
    int N = A.size();
    // can't be average
    if(N < M) return ret; 

    int temp = A[0] + A[1];
    for(int i=2;i<N;i++) {
        temp += A[i];
        ret.push_back(temp / 3);
        temp -= A[i-2];
    }
    return ret;
}

int main() {
    vector<double> A;
    A.push_back(1.0);
    A.push_back(2.0);
    A.push_back(3.0);

}