def recur(day, weight):
    global cnt

    if day == N:
        cnt += 1
        return

    if weight < 500:
        return

    for num in range(N):
        if visited[num]:
            continue

        visited[num] = 1
        recur(day+1, weight+kits[num]-K)
        visited[num] = 0



N, K = map(int, input().split())
kits = list(map(int, input().split()))

cnt = 0
visited = [0]*N

recur(0, 500)

print(cnt)