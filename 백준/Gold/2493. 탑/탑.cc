
#include <bits/stdc++.h>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int N;
  cin >> N;

  stack<int> stk;
  int arr[N];
  fill_n(arr, N, 0);
  int ans[N];

  for (int i = 0; i < N; i++) {
    int num;
    cin >> num;
    arr[i] = num;
  }

  for (int i = 0; i < N; i++) {
    while (!stk.empty() && arr[i] > arr[stk.top()]) {
      stk.pop();
    }

    ans[i] = stk.empty() ? 0 : stk.top() + 1;
    stk.push(i);
  }

  for (auto num : ans) {
    cout << num << " ";
  }
  return 0;
}