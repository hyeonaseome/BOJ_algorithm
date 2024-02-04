#include <bits/stdc++.h>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int N;
  cin >> N;  // 상근이가 가지고 있는 숫자 카드의 개수

  set<int> s;

  for (int i = 0; i < N; i++) {
    int num;
    cin >> num;
    s.insert(num);
  }

  int M;
  cin >> M;

  for (int i = 0; i < M; i++) {
    int num;
    cin >> num;
    int result = s.find(num) != s.end() ? 1 : 0;
    cout << result << " ";
  }

  return 0;
}