#include <bits/stdc++.h>
using namespace std;

bool compare(string str1, string str2) {
  if (str1.length() != str2.length()) {
    return str1.length() < str2.length();
  }
  return str1 < str2;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int N;

  cin >> N;  // 1 ≤ N ≤ 20,000

  // 문자열의 길이는 최대 50

  vector<string> vec(N);
  for (int i = 0; i < N; i++) {
    cin >> vec[i];
  }

  sort(vec.begin(), vec.end(), compare);
  vec.erase(unique(vec.begin(), vec.end()), vec.end());

  for (auto i : vec) {
    cout << i << "\n";
  }

  return 0;
}