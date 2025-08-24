from collections import deque

di = [0, 1, 0, -1]
dj = [1, 0, -1, 0]


def find_start():
    for i in range(N):
        for j in range(N):
            if visited[i][j] == 0:
                return i, j
    return -1, -1


# 적록색맹 X
def bfs(si, sj):
    q = deque()
    q.append((si, sj))
    visited[si][sj] = 1

    while q:
        ti, tj = q.popleft()

        for d in range(4):
            ni = ti + di[d]
            nj = tj + dj[d]

            if (0 <= ni < N) and (0 <= nj < N) and (visited[ni][nj] == 0) and (arr[ni][nj] == arr[ti][tj]):
                q.append((ni, nj))
                visited[ni][nj] = 1


# 적록색맹
def bfs_c(si, sj):
    q = deque()
    q.append((si, sj))
    visited[si][sj] = 1

    while q:
        ti, tj = q.popleft()

        for d in range(4):
            ni = ti + di[d]
            nj = tj + dj[d]
            if (0 <= ni < N) and (0 <= nj < N) and (visited[ni][nj] == 0):
                if arr[ti][tj] == 'B' and arr[ni][nj] == 'B':
                    q.append((ni, nj))
                    visited[ni][nj] = 1
                elif arr[ti][tj] == 'G' or arr[ti][tj] == 'R':
                    if arr[ni][nj] == 'G' or arr[ni][nj] == 'R':
                        q.append((ni, nj))
                        visited[ni][nj] = 1


N = int(input())
arr = [list(input()) for _ in range(N)]
visited = [[0] * N for _ in range(N)]
area = 0

while True:
    si, sj = find_start()

    if si == -1:
        break

    bfs(si, sj)

    area += 1

visited = [[0] * N for _ in range(N)]
area_c = 0

while True:
    si, sj = find_start()

    if si == -1:
        break

    bfs_c(si, sj)

    area_c += 1

print(f'{area} {area_c}')