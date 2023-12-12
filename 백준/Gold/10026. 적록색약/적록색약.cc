#include <bits/stdc++.h>
using namespace std;

int N;
char board[101][101];
bool isVisit[101][101];

int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};

void dfs(int x, int y, char ch, bool isRG) {
  for (int d = 0; d < 4; d++) {
    int nx = x + dx[d];
    int ny = y + dy[d];

    if (!(0 <= nx && nx < N && 0 <= ny && ny < N)) continue;
    if (isVisit[nx][ny]) continue;

    if (board[nx][ny] == ch) {
      isVisit[nx][ny] = true;
      dfs(nx, ny, ch, isRG);
    }
    if (isRG) {
      if ((ch == 'R' && board[nx][ny] == 'G') ||
          (ch == 'G' && board[nx][ny] == 'R')) {
        isVisit[nx][ny] = true;
        dfs(nx, ny, ch, isRG);
      }
    }
  }
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  cin >> N;

  for (int i = 0; i < N; i++) {
    for (int j = 0; j < N; j++) {
      cin >> board[i][j];
    }
  }

  int cnt1 = 0;
  for (int i = 0; i < N; i++) {
    for (int j = 0; j < N; j++) {
      if (!isVisit[i][j]) {
        isVisit[i][j] = true;
        dfs(i, j, board[i][j], false);
        cnt1++;
      }
    }
  }

  for (int i = 0; i < N; i++) {
    fill(isVisit[i], isVisit[i] + N, false);
  }

  int cnt2 = 0;
  for (int i = 0; i < N; i++) {
    for (int j = 0; j < N; j++) {
      if (!isVisit[i][j]) {
        isVisit[i][j] = true;
        dfs(i, j, board[i][j], true);
        cnt2++;
      }
    }
  }

  cout << cnt1 << " " << cnt2;

  return 0;
}