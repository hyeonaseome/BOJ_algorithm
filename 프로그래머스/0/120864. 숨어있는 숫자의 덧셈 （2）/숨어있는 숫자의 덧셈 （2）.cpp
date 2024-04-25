#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

int solution(string my_string) {
    int answer = 0;
    
    int temp = 0;
    for (auto s : my_string) {
        if (isdigit(s)) {
            temp = temp * 10 + s - '0';
        } else {
            answer += temp;
            temp = 0;
        }
    }
    answer += temp;
      
    return answer;
}