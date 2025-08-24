from collections import deque

di = [0, 1, 0, -1]
dj = [1, 0, -1, 0]


def find_start():
    for i in range(N):
        for j in range(M):
            if farm[i][j] == 1 and visited[i][j] == 0:
                return i, j
    return -1, -1


def bfs(si, sj):
    global visited
    q = deque()
    q.append((si, sj))
    visited[si][sj] = 1

    while q:
        ti, tj = q.popleft()

        for d in range(4):
            ni = ti + di[d]
            nj = tj + dj[d]

            if (0 <= ni < N) and (0 <= nj < M) and (visited[ni][nj] == 0) and (farm[ni][nj] == 1):
                q.append((ni, nj))
                visited[ni][nj] = 1


T = int(input())

for test_case in range(1, T+1):
    M, N, K = map(int, input().split())

    farm = [[0]*M for _ in range(N)]
    visited = [[0]*M for _ in range(N)]

    for _ in range(K):
        x, y = map(int, input().split())
        farm[y][x] = 1

    cnt_worm = 0
    while True:
        si, sj = find_start()

        if si == -1:
            break

        bfs(si, sj)
        cnt_worm += 1

    print(cnt_worm)