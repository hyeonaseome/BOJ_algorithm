#include <bits/stdc++.h>
using namespace std;

// 소수를 찾아주는 함수
std::vector<int> findPrimes(int N) {
    std::vector<int> primes;  // 소수를 저장할 배열
    if (N < 2) return primes; // 2 보다 작은 소수 배열은 없음

    std::vector<bool> isPrime(N, true);

    // 0과 1은 소수가 아니므로 false로 설정
    isPrime[0] = isPrime[1] = false;

    // 에라토스테네스의 체 알고리즘 적용
    for (int i = 2; i <= N; ++i) {
        if (isPrime[i]) {
            primes.push_back(i);  // i는 소수

            for (int j = i * 2; j <= N; j += i) {
                isPrime[j] = false;
            }
        }
    }

    return primes;
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int N;  // N: 자연수
  cin >> N;

  int result = 0; // 가능한 경우의 수

  // pimes는 이미 정렬된 배열 형태
  std::vector<int> primes = findPrimes(N + 1);

  int len = primes.size();

  for (int start = 0; start < len ; start++) {
    int sum = primes[start];
    if (sum == N) {
      result++;
    } 
    for (int end = start + 1; end < len; end++) {
      sum += primes[end];
      if (sum == N) {
        result++;
      } else if (sum > N) {
        break;
      }
    }
  }

  cout << result;

  return 0;
}