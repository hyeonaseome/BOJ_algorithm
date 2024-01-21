#include <bits/stdc++.h>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int T = 0;
  cin >> T;
  for (int t = 0; t < T; t++) {
    int N = 0;
    cin >> N;

    long long int ans = 0;
    int prices[N];
    fill_n(prices, N, 0);

    for (int i = 0; i < N; i++) {
      cin >> prices[i];
    }

    long long int result = 0;
    int maxIdx = N - 1;
    for (int i = N - 2; i >= 0; i--) {
      if (prices[maxIdx] > prices[i]) {
        ans += prices[maxIdx] - prices[i];
      } else {
        maxIdx = i;
      }
    }

    cout << ans << "\n";
  }

  return 0;
}