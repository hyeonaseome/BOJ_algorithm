#include <bits/stdc++.h>
using namespace std;

int board[2188][2188];
int countArr[3];

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

int dx[9] = {0, 0, 0, 1, 1, 1, 2, 2, 2};
int dy[9] = {0, 1, 2, 0, 1, 2, 0, 1, 2};

void recur(int start_x, int start_y, int range) {
  if (isSame(start_x, start_y, range)) {
    countArr[board[start_x][start_y] + 1]++;
  } else {
    int new_range = range / 3;
    for (int i = 0; i < 9; i++) {
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

  for (int i = 0; i < 3; i++) {
    cout << countArr[i] << "\n";
  }
  return 0;
}