#include <bits/stdc++.h>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int N;  // N : 추천 문제 리스트에 있는 문제의 개수
  int probLevelArray[100002]; // 각 문제 번호의 나이도 저장
  map<int, set<int> > problemLevelSet; // 난이도에 따른 문제 번호 Set

  cin >> N;

  int P, L;

  for (int i = 0; i < N; i++) {
    cin >> P >> L; // P : 문제 번호, L: 난이도
    probLevelArray[P] = L;
    problemLevelSet[L].insert(P);
  }

  int M; // 명령문의 개수
  cin >> M;

  string op;
  for (int i = 0; i < M; i++) {
    cin >> op;
    if (op == "recommend") {
      int x;
      cin >> x;
      if (x == 1) {
        for (int j = 100; 0 <= j; j--) {
          if (problemLevelSet[j].empty()) continue;
          cout <<  *(problemLevelSet[j].rbegin()) << '\n';
          break;
        }
      } 
  else {
        for (int j = 0; j < 101; j++) {
          if (problemLevelSet[j].empty()) continue;
          cout << *problemLevelSet[j].begin() << '\n';
          break;
        }
      }
    } else if (op == "add") {
      cin >> P >> L;
      probLevelArray[P] = L;
      problemLevelSet[L].insert(P);
    } else if (op == "solved") {
      cin >> P;
      problemLevelSet[probLevelArray[P]].erase(P);
    }
  }

  return 0;
}