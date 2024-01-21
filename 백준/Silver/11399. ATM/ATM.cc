#include <bits/stdc++.h>
using namespace std;

int P[10001];
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int N;
  cin >> N;
  for (int i = 0; i < N; i++) {
    cin >> P[i];
  }
  sort(P, P + N);

  int ans = 0;
  for (int i = 0; i < N; i++) {
    ans += P[i] * (N - i);
  }
  cout << ans;

  return 0;
}