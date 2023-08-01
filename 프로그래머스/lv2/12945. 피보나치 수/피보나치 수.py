def solution(n):
    answer=0
    mem=[0 for i in range(100000+1)]
    mem[1]=1
    for i in range(2, 100000+1):
        mem[i]=mem[i-2]%1234567 + mem[i-1]%1234567

    answer=mem[n] % 1234567

    return answer
