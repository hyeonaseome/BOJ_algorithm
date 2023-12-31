#include <bits/stdc++.h>
using namespace std;

int N, minN, maxN;
int opers[4];
int input[100];

void perm(int cnt, int ans) {
  if (cnt == N - 1) {
    maxN = max(ans, maxN);
    minN = min(ans, minN);
    return;
  }

  if (opers[0] > 0) {
    opers[0]--;
    perm(cnt + 1, ans + input[cnt + 1]);
    opers[0]++;
  }
  if (opers[1] > 0) {
    opers[1]--;
    perm(cnt + 1, ans - input[cnt + 1]);
    opers[1]++;
  }
  if (opers[2] > 0) {
    opers[2]--;
    perm(cnt + 1, ans * input[cnt + 1]);
    opers[2]++;
  }

  if (opers[3] > 0) {
    opers[3]--;
    if (ans > 0) {
      perm(cnt + 1, ans / input[cnt + 1]);
    } else {
      perm(cnt + 1, (-1) * ((-1 * ans) / input[cnt + 1]));
    }
    opers[3]++;
  }
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  cin >> N;
  minN = 1000000000;
  maxN = -1000000000;

  for (int i = 0; i < N; i++) {
    cin >> input[i];
  }

  for (int i = 0; i < 4; i++) {
    cin >> opers[i];
  }

  perm(0, input[0]);

  cout << maxN << "\n" << minN;

  return 0;
}