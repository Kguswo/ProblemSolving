t = int(input())

for _ in range(t):
    command = input().split()
    res = float(command[0])
    
    for i in command[1:]:
        if i == '@':
            res *= 3
        elif i == '%':
            res += 5
        elif i == '#':
            res -= 7
    print(f"{res:.2f}")