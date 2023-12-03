#include <bits/stdc++.h>
using namespace std;

int main()
{
  ios::sync_with_stdio(0);
  cin.tie(0);


  int test_case;
  cin >> test_case;

  for (int tc = 0; tc < test_case; tc++) {
    string str;
    cin >> str;

    list<char> L;
    list<char>::iterator t = L.begin();
    for (int i = 0; i < str.length(); i++) {
      if (str[i] == '<') {
        if (t != L.begin()) t--;
      }
      else if (str[i] == '>')
      {
        if (t != L.end()) t++;
      }
      else if (str[i] == '-')
      {
        if (t != L.begin()) {
          t--;
          t = L.erase(t);
        }
      }
      else
      { // alphabet
        L.insert(t, str[i]);
      }

    }
    for(list<char>::iterator it = L.begin(); it != L.end(); it++)
      cout << *it;
    cout << "\n";
  }
  
  return 0;
}