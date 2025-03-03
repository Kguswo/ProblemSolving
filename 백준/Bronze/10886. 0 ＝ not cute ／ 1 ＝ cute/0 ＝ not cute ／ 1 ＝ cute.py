n = int(input())

cnt=0
for _ in range(n):
    if int(input()) == 0:
        cnt += 1
    else:
        cnt -= 1
    
if cnt > 0:
    print("Junhee is not cute!")
else:
    print("Junhee is cute!")