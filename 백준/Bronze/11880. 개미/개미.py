import sys
input = sys.stdin.readline

t= int(input())

for _ in range(t):
    a, b, c = map(int, input().split())

    aa = a*a + (b+c)*(b+c)
    bb = b*b + (a+c)*(a+c) 
    cc = c*c + (a+b)*(a+b)
    
    print(min(aa, bb, cc))