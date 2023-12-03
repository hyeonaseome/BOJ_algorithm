#include <bits/stdc++.h>
using namespace std;

int main()
{
  ios::sync_with_stdio(0);
  cin.tie(0);

  int A, B, C;
  int result;
  int arr[10]={0,};

  cin >> A >> B >> C;
  result = A * B * C;
  
  while (result > 0) {
    arr[result % 10]++;
    result /= 10;
  }

  for (auto cnt: arr) {
    cout << cnt << "\n";
  }
  return 0;
}