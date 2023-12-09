/**
 * [큐] 18258. 큐2
 * https://www.acmicpc.net/problem/18258
 */
#include <bits/stdc++.h>
using namespace std;

const int MX = 2000005;
int dat[MX];
int head = 0, tail = 0;

int size() { return tail - head; }
int empty() { return size() ? 0 : 1; }

void push(int x) { dat[tail++] = x; }

int pop() {
  if (empty()) {
    return -1;
  } else {
    return dat[head++];
  }
}

int front() {
  if (empty()) {
    return -1;
  } else {
    return dat[head];
  }
}

int back() {
  if (empty()) {
    return -1;
  } else {
    return dat[tail - 1];
  }
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int N;
  cin >> N;

  for (int i = 0; i < N; i++) {
    string com;
    cin >> com;

    if (com == "push") {
      int num;
      cin >> num;
      push(num);
    } else if (com == "pop") {
      cout << pop() << "\n";
    } else if (com == "size") {
      cout << size() << "\n";
    } else if (com == "empty") {
      cout << empty() << "\n";
    } else if (com == "front") {
      cout << front() << "\n";
    } else if (com == "back") {
      cout << back() << "\n";
    }
  }

  return 0;
}