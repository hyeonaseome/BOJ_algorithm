#include <bits/stdc++.h>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int N;
  cin >> N;

  queue<int> que;
  for (int i = 1; i <= N; i++) {
    que.push(i);
  }


  while (que.size() > 1) {
    que.pop();
    int front = que.front();
    que.pop();
    que.push(front);
  }

  cout << que.front();
  return 0;
}