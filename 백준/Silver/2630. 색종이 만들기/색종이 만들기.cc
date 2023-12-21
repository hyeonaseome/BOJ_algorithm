#include <bits/stdc++.h>
using namespace std;

int board[129][129];
int countArr[2];

bool isSame(int start_x, int start_y, int range) {
  int originNum = board[start_x][start_y];
  for (int i = start_x; i < start_x + range; i++) {
    for (int j = start_y; j < start_y + range; j++) {
      if (board[i][j] != originNum) {
        return false;
      }
    }
  }
  return true;
}

int dx[4] = {0, 0, 1, 1};
int dy[4] = {0, 1, 0, 1};

void recur(int start_x, int start_y, int range) {
  if (isSame(start_x, start_y, range)) {
    countArr[board[start_x][start_y]]++;
  } else {
    int new_range = range / 2;
    for (int i = 0; i < 4; i++) {
      recur(start_x + new_range * dx[i], start_y + new_range * dy[i],
            new_range);
    }
  }
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int N;
  cin >> N;

  for (int i = 0; i < N; i++) {
    for (int j = 0; j < N; j++) {
      cin >> board[i][j];
    }
  }

  recur(0, 0, N);

  for (int i = 0; i < 2; i++) {
    cout << countArr[i] << "\n";
  }
  return 0;
}