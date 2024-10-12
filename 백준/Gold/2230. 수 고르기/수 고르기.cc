#include <bits/stdc++.h>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int N, M;  // N: N개의 정수 배열, M: M 차이 이상이 나야함
  cin >> N >> M;

  int array[100000];
  for (int i = 0; i < N; i++) {
    cin >> array[i];
  }

  int MIN = 2000000001;

  sort(array, array+N); // 수열 정렬

  for (int start = 0; start < N; start++) {
    for (int end = start; end < N; end++) {
      if (array[end] - array[start] >= M ) {
        MIN = min(MIN, array[end] - array[start]);
        break;
      }
    }
  }

  cout << MIN;

  return 0;
}