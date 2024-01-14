#include <bits/stdc++.h>
using namespace std;

pair<int, int> dp[41];

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int T;
  cin >> T;

  dp[0].first = 1;
  dp[1].second = 1;

  for (int i = 2; i <= 40; i++) {
    dp[i].first = dp[i - 1].first + dp[i - 2].first;
    dp[i].second = dp[i - 1].second + dp[i - 2].second;
  }

  for (int t = 0; t < T; t++) {
    int num;
    cin >> num;
    cout << dp[num].first << " " << dp[num].second << "\n";
  }

  return 0;
}