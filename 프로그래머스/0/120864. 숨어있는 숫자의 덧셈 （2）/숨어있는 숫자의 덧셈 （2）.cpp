#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

bool isDigit(char s) {
    if ('0' <= s && s <= '9') {
        return true;
    }
    return false;
}

int solution(string my_string) {
    int answer = 0;
    
    int temp = 0;
    for (auto s : my_string) {
        if (isDigit(s)) {
            temp = temp * 10 + s - '0';
        } else {
            answer += temp;
            temp = 0;
        }
    }
    answer += temp;
      
    return answer;
}