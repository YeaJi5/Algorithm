from collections import deque


def bfs(n):
    q = deque()
    q.append(n)
    visited[n] = 1

    while q:
        t = q.popleft()

        for w in tree[t]:
            if visited[w] == 0:
                visited[w] = t
                q.append(w)


N = int(input())

tree = [[] for _ in range(N+1)]

for _ in range(N-1):
    v1, v2 = map(int, input().split())
    tree[v1].append(v2)
    tree[v2].append(v1)

visited = [0] * (N+1)

bfs(1)

for i in range(2, N+1):
    print(visited[i])