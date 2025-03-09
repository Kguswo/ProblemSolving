n = int(input())
coordinate = {"Q1": 0, "Q2": 0, "Q3": 0, "Q4": 0, "AXIS": 0}

for _ in range(n):
    x, y = map(int, input().split())
    if x == 0 or y == 0:
        coordinate["AXIS"] += 1
    else:
        if x > 0 and y > 0:
            coordinate["Q1"] += 1
        elif x < 0 and y > 0:
            coordinate["Q2"] += 1
        elif x < 0 and y < 0:
            coordinate["Q3"] += 1
        elif x > 0 and y < 0:
            coordinate["Q4"] += 1

for k in coordinate:
    print("{}: {}".format(k, coordinate[k]))
