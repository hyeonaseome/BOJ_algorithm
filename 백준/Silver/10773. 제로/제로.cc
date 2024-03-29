#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    int K; // 정수
    cin >> K;

    stack<int> S;

    for (int i = 0; i < K; i++) {
        int num;
        cin >> num;
        if (num == 0) {
            S.pop();
        }
        else
        {
            S.push(num);
        }
    }

    int sum = 0;
    while(!S.empty()) {
        sum += S.top();
        S.pop();
    }
    cout << sum;

    return 0;
}