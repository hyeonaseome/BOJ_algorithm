T = int(input(""))

for t in range(1, T+1):
    R, S = input().split()
    
    answer = ""
    for s in S:
        answer += s * int(R)
    print(answer)