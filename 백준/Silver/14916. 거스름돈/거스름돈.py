M = int(input())

result = 0

coin5 = M//5
coin2 = 0
result = -1

while coin5 >= 0:
    if (M-coin5*5)%2 == 0:
        coin2 = (M-coin5*5)//2
        result = coin5+coin2
        break
    else:
        coin5 -= 1

print(result)