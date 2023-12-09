#include <bits/stdc++.h>
using namespace std;

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n;
  cin >> n;

  stack<int> stk;
  string answer = "";

  int input_num = 1;
  for (int i = 0; i < n; i++) {
    int num;
    cin >> num;

    while (answer.compare("NO") != 0 && input_num <= n + 1) {
      if (stk.empty()) {
        stk.push(input_num++);
        answer += "+\n";
      } else {
        if (stk.top() < num) {
          stk.push(input_num++);
          answer += "+\n";
        } else if (stk.top() == num) {
          stk.pop();
          answer += "-\n";
          break;
        } else {
          answer = "NO";
          break;
        }
      }
    }
  }

  cout << answer << "\n";
  return 0;
}