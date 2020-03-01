#include <iostream>
#include <list>
#include <vector>

using namespace std;

vector<int> josephus(int n, int k) {
   // initialize vector(survivor)
   list<int> survivors;
   vector<int> result;
   for(int i=0;i<n;i++) survivors.push_back(i+1);
   // kill process
   list<int>::iterator kill = survivors.begin();
   for(int i=0;i<k-1;i++) kill++;

   while(n>0) {
       
       // 해당되는 순서의 사람을 죽인다.
       result.push_back(*kill);
       kill = survivors.erase(kill);
       if(kill == survivors.end()) kill = survivors.begin();
       --n;
       // 다음 순서의 사람으로 넘어간다.
       for(int i=0;i<k-1;i++){
           kill++;
           if(kill == survivors.end()) kill = survivors.begin();
       }
   }
   return result;
}

int main() {
    
    int n, k;
    cin >> n >> k;
    vector<int> result = josephus(n, k);
    int size = result.size();
    cout << "<";
    for(int i=0;i<size;i++){
        if(i == size-1) cout << result[i];
        else cout << result[i] << ", ";
    }
    cout << ">" << endl;

    return 0;
}