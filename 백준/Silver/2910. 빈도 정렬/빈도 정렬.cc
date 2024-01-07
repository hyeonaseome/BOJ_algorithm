
#include <bits/stdc++.h>
using namespace std;

bool compare(pair<int, int> p1, pair<int, int> p2) {
  return p1.second > p2.second;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int N, C;  // 1 ≤ N ≤ 1,000, 1 ≤ C ≤ 1,000,000,000 (int)
  cin >> N >> C;

  vector<pair<int, int>> vec;

  for (int i = 0; i < N; i++) {
    int num;
    cin >> num;

    bool is_exist = false;
    for (unsigned j = 0; j < vec.size(); j++) {
      if (vec[j].first == num) {
        is_exist = true;
        vec[j].second++;
        break;
      }
    }
    if (!is_exist) {
      vec.push_back(make_pair(num, 1));
    }
  }

  stable_sort(vec.begin(), vec.end(), compare);
  // stable_sort() 인덱스를 저장후 인덱스 비교

  for (auto i : vec) {
    for (int cnt = 0; cnt < i.second; cnt++) {
      cout << i.first << " ";
    }
  }

  return 0;
}