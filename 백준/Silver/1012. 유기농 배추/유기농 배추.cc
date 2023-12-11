#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second

int M, N, K;
int board[51][51];

int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};

void bfs(int x, int y, int count);

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int T;
  cin >> T;

  for (int t = 0; t < T; t++) {
    cin >> M >> N >> K;
    fill(board[0], board[0] + N * M, 0);
    for (int k = 0; k < K; k++) {
      int x, y;
      cin >> y >> x;
      board[x][y] = -1;
    }

    int count = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (board[i][j] == -1) {
          bfs(i, j, ++count);
        }
      }
    }

    cout << count << "\n";
  }

  return 0;
}

void bfs(int x, int y, int count) {
  queue<pair<int, int> > Q;
  board[x][y] = count;

  Q.push(make_pair(x, y));

  while (!Q.empty()) {
    pair<int, int> cur = Q.front();
    Q.pop();

    for (int dir = 0; dir < 4; dir++) {
      int nx = cur.X + dx[dir];
      int ny = cur.Y + dy[dir];

      if (!(0 <= nx && nx < N && 0 <= ny && ny < M)) continue;

      if (board[nx][ny] == -1) {
        board[nx][ny] = count;
        Q.push(make_pair(nx, ny));
      }
    }
  }
}