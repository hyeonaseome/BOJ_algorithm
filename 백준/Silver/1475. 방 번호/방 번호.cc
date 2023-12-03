#include <bits/stdc++.h>
using namespace std;

int main()
{
  ios::sync_with_stdio(0);
  cin.tie(0);

  int N;
  int result = 0;
  int arr[10]={0,};

  cin >> N;
  
  while (N > 0) {
    int mod = N % 10;
    arr[mod]++;
    if (mod == 6 || mod == 9) {
      result = max((arr[6] + arr[9] + 1) / 2, result);
    } else {
      result = max(arr[mod], result);
    }
    N /= 10;
  }

  cout << result;
  return 0;
}