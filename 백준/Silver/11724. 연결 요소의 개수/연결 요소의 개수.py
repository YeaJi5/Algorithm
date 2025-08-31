def dfs(v):
    for w in adj_list[v]:
        if visited[w] == 0:
            visited[w] = 1
            dfs(w)


N, M = map(int, input().split())
adj_list = [[] for _ in range(N+1)]

for _ in range(M):
    v1, v2 = map(int, input().split())
    adj_list[v1].append(v2)
    adj_list[v2].append(v1)

visited = [0]*(N+1)

cnt = 0
for i in range(1, N+1):
    if visited[i] == 0:
        dfs(i)
        cnt += 1

print(cnt)