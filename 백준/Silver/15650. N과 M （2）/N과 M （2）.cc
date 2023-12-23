#include <bits/stdc++.h>
using namespace std;

int N, M;
int numbers[9];

void comb(int cnt, int start) {
  if (cnt == M) {
    for (int i = 0; i < M; i++) {
      cout << numbers[i] << " ";
    }
    cout << "\n";
    return;
  }

  for (int i = start; i <= N; i++) {
    numbers[cnt] = i;

    comb(cnt + 1, i + 1);
  }
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  cin >> N >> M;
  comb(0, 1);

  return 0;
}