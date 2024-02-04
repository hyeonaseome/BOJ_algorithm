#include <bits/stdc++.h>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int M, N;  // M: 조카의 수, N: 과자의 수
  cin >> M >> N;

  int array[1000000];
  for (int i = 0; i < N; i++) {
    cin >> array[i];
  }

  int result = 0;

  int start = 1;
  int end = 1000000000;

  while (start <= end) {
    int mid = (start + end) / 2;

    int count = 0;  // 길이가 mid인 과자의 개수
    for (int i = 0; i < N; i++) {
      count += array[i] / mid;
    }

    // 조카의 수랑 비교
    if (count >= M) {
      result = max(result, mid);
      start = mid + 1;
    } else {
      end = mid - 1;
    }
  }

  cout << result;

  return 0;
}