from collections import deque


def dfs(v):
    global visited_dfs

    visited_dfs[v] = 1
    print(v, end=' ')
    for w in sorted(adj_lst[v]):
        if visited_dfs[w] == 0 :
            dfs(w)


def bfs(v):
    global visited_bfs

    q = deque()
    q.append(v)
    visited_bfs[v] = 1

    while q:
        t = q.popleft()
        print(t, end=' ')
        for w in sorted(adj_lst[t]):
            if visited_bfs[w] == 0:
                q.append(w)
                visited_bfs[w] = visited_bfs[t] + 1


N, M, V = map(int, input().split())

adj_lst = [[] for _ in range(N+1)]

for _ in range(M):
    v1, v2 = map(int, input().split())
    adj_lst[v1].append(v2)
    adj_lst[v2].append(v1)

visited_dfs = [0] * (N+1)
visited_bfs = [0] * (N+1)

dfs(V)
print()
bfs(V)