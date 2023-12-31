
#include <bits/stdc++.h>
using namespace std;

int n, w, L;
int truckW[1000];

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  cin >> n >> w >> L;
  // n: 다리를 건너는 트럭의 수
  // w: 다리의 길이
  // L: 다리의 최대하중

  for (int i = 0; i < n; i++) {
    cin >> truckW[i];
  }

  queue<int> Q;
  int time = 0;
  int sum = 0;

  for (int i = 0; i < n; i++) {
    while (true) {
      // 다리 길이 확인
      if (Q.size() == w) {
        sum -= Q.front();
        Q.pop();
      }
      // 다리 최대 하중 확인
      if (sum + truckW[i] > L) {
        Q.push(0);  // 트럭이 없는 공간 추가
        time++;
      } else {
        break;
      }
    }
    Q.push(truckW[i]);
    sum += truckW[i];
    time++;
  }

  cout << (time + w);

  return 0;
}