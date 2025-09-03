from collections import deque

di = [0, 1, 1, 1, 0, -1, -1, -1]
dj = [1, 1, 0, -1, -1, -1, 0, 1]


def find_start():
    for i in range(H):
        for j in range(W):
            if arr[i][j] == 1 and visited[i][j] == 0:
                return i, j
    return -1, -1


def bfs(si, sj):
    q = deque()
    q.append((si, sj))
    visited[si][sj] = 1

    while q:
        ti, tj = q.popleft()

        for d in range(8):
            ni = ti + di[d]
            nj = tj + dj[d]

            if (0 <= ni < H) and (0 <= nj < W):
                if visited[ni][nj] == 0 and arr[ni][nj] == 1:
                    q.append((ni, nj))
                    visited[ni][nj] = 1


while True:
    W, H = map(int, input().split())
    if W == 0 and H == 0:
        break
    arr = [list(map(int, input().split())) for _ in range(H)]

    visited = [[0]*W for _ in range(H)]

    cnt = 0
    while True:
        si, sj = find_start()

        if si == -1:
            break
        else:
            bfs(si, sj)
            cnt += 1

    print(cnt)