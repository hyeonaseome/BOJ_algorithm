#include <bits/stdc++.h>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int N;
  cin >> N;

  priority_queue<unsigned int, vector<unsigned int>, greater<>> pq;

  unsigned int x;
  for (int i = 0; i < N; i++) {
    cin >> x;

    if (x == 0) {
      if (pq.empty()) {
        cout << "0\n";
      }
      else {
        cout << pq.top() << endl;
        pq.pop();
      }
    }
    else {
      pq.push(x);
    }
  }

  return 0;
}