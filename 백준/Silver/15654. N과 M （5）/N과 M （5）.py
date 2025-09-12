def perm(cnt):
    global path

    if cnt == M:
        print(*path)
        return

    for i in range(N):
        if visited[i]:
            continue
        visited[i] = 1
        path.append(num[i])
        perm(cnt+1)
        path.pop()
        visited[i] = 0


N, M = map(int, input().split())
num = list(map(int, input().split()))
num.sort()

path = []
visited = [0]*N

perm(0)