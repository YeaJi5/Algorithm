N, K = map(int, input().split())

coins = [0]*N

for i in range(N-1, -1, -1):
    coins[i] = int(input())

cnt_coins = 0
for c in coins:
    if K // c > 0:
        cnt_coins += K//c
        K -= ((K//c)*c)

print(cnt_coins)