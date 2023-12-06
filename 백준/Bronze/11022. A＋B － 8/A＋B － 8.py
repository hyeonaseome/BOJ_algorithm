T = int(input(""))

for t in range(1, T+1):
    A, B = map(int, input().split())
    C = A + B
    
    print("Case #{0}: {1} + {2} = {3}".format(t, A, B, C))