#include <bits/stdc++.h>
using namespace std;

#define RIPE 1
#define UNRIPE 0

int H, N, M;
int board[101][101][101];
bool is_unripe_exist = false;
queue<tuple<int, int, int> > Q;

// 하, 우, 상, 좌
int dx[6] = {1, 0, -1, 0, 0, 0};
int dy[6] = {0, 1, 0, -1, 0, 0};
int dz[6] = {0, 0, 0, 0, 1, -1};

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  cin >> M >> N >> H;
  for (int k = 0; k < H; k++) {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        cin >> board[i][j][k];
        if (board[i][j][k] == RIPE) Q.push({i, j, k});
      }
    }
  }

  while (!Q.empty()) {
    int size = Q.size();
    while (size-- > 0) {
      tuple<int, int, int> cur = Q.front();
      Q.pop();

      int curX = get<0>(cur);
      int curY = get<1>(cur);
      int curZ = get<2>(cur);

      for (int d = 0; d < 6; d++) {
        int nx = curX + dx[d];
        int ny = curY + dy[d];
        int nz = curZ + dz[d];

        if (!(0 <= nx && nx < N && 0 <= ny && ny < M && 0 <= nz && nz < H))
          continue;

        if (board[nx][ny][nz] == UNRIPE) {
          board[nx][ny][nz] = board[curX][curY][curZ] + 1;
          Q.push({nx, ny, nz});
        }
      }
    }
  }

  int maxDay = 0;
  for (int i = 0; i < N; i++) {
    for (int j = 0; j < M; j++) {
      for (int k = 0; k < H; k++) {
        if (board[i][j][k] == UNRIPE) {
          cout << -1 << "\n";
          return 0;
        };
        maxDay = max(maxDay, board[i][j][k]);
      }
    }
  }
  cout << --maxDay << "\n";

  return 0;
}