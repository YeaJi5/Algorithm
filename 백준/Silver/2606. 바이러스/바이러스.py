from collections import deque


def bfs(n):
    q = deque()
    q.append(n)
    visited[n] = 1

    while q:
        t = q.popleft()
        for w in adj_lst[t]:
            if visited[w] == 0:
                q.append(w)
                visited[w] = 1


def cnt_worm():
    global visited
    cnt = 0
    for v in visited[2:]:
        if v == 1:
            cnt += 1

    return cnt


N = int(input())
V = int(input())

adj_lst = [[] for _ in range(N+1)]
visited = [0] * (N+1)

for _ in range(V):
    v1, v2 = map(int, input().split())
    adj_lst[v1].append(v2)
    adj_lst[v2].append(v1)

bfs(1)
print(cnt_worm())