
#include <bits/stdc++.h>
using namespace std;
int n;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  cin >> n;

  vector<long long> list;
  string str;

  for (int i = 0; i < n; i++) {
    cin >> str;
    // 10^12까지 가능 (long long (int) 범위)
    // 1,000,000,000,000
    reverse(str.begin(), str.end());  // 문자열 뒤바꾸기
    list.push_back(atoll(str.c_str()));
    // atoll(): string to long long
    // atol(): string to long
    }
  sort(list.begin(), list.end());
  for (long long i : list) {
    cout << i << "\n";
  }

  return 0;
}