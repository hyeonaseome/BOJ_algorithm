#include <bits/stdc++.h>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
    
  int nA, nB;
  cin >> nA >> nB;

  set<int> B;

  int setA[500010] = {0};

  for (int i = 0; i < nA; i++) {
    int num;
    cin >> setA[i];
  }

  for (int i = 0; i < nB; i++) {
    int num;
    cin >> num;
    B.insert(num);
  }

  vector<int> v;

  for (int i = 0; i < nA; i++) {
    int cur = setA[i];
    if (B.find(cur) == B.end()) {
      v.push_back(cur);
    }
  }

  cout << v.size() << "\n";

  if (v.size() != 0) {
    sort(v.begin(), v.end());

    for (int i = 0; i < v.size(); i++) {
      cout << v[i] << " ";
    }
  }

  return 0;
}