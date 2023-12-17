#include <bits/stdc++.h>
using namespace std;

int dx[8] = {-2, -2, -1, 1, 2, 2, 1, -1};
int dy[8] = {-1, 1, 2, 2, 1, -1, -2, -2};
int board[301][301];

queue<pair<int, int>> Q;
int N;
int main(void) {
  ios_base::sync_with_stdio(0);
  cin.tie(0);

  int T;
  cin >> T;
  for (int t = 0; t < T; t++) {
    cin >> N;

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        board[i][j] = -1;
      }
    }
    int x, y;
    cin >> x >> y;
    board[x][y] = 0;
    int target_x, target_y;
    cin >> target_x >> target_y;

    Q.push({x, y});

    while (!Q.empty()) {
      auto cur = Q.front();
      Q.pop();
      int curX, curY;
      curX = cur.first;
      curY = cur.second;

      for (int d = 0; d < 8; d++) {
        int nx = curX + dx[d];
        int ny = curY + dy[d];

        if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
        if (board[nx][ny] >= 0) continue;
        board[nx][ny] = board[curX][curY] + 1;
        Q.push({nx, ny});
      }
    }

    cout << board[target_x][target_y] << "\n";
  }
  return 0;
}