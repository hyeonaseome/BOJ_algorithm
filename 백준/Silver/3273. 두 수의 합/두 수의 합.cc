#include <bits/stdc++.h>
using namespace std;

int main()
{
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n, x;
  int result = 0;

  cin >> n;
  int arr[n];
  bool isExist[2000001] = {false, };

  for (int i = 0; i < n; i++){
    int num;
    cin >> num;
    arr[i] = num;
  }

  cin >> x;

  for (auto num : arr){
    if ((x - num) > 0 && isExist[x - num]) result++;
    isExist[num] = true;
  }

  cout << result;
  return 0;
}