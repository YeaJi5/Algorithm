from collections import deque

di = [0, 1, 0, -1]
dj = [1, 0, -1, 0]


def minus_h():
    h_arr = [[0]*M for _ in range(N)]
    for i in range(N):
        for j in range(M):
            cnt = 0

            for d in range(4):
                ni = i + di[d]
                nj = j + dj[d]

                if (0 <= ni < N) and (0 <= nj < M):
                    if (arr[i][j] != 0) and (arr[ni][nj] == 0):
                        cnt += 1

            h_arr[i][j] = cnt

    return h_arr


def melting():
    global arr
    melting_h = minus_h()

    for i in range(N):
        for j in range(M):
            arr[i][j] -= melting_h[i][j]

            if arr[i][j] < 0:
                arr[i][j] = 0


def find_start():
    for i in range(N):
        for j in range(M):
            if arr[i][j] != 0 and visited[i][j] == 0:
                return i, j
    return -1, -1


def bfs(i, j):
    global visited

    q = deque()
    q.append((i, j))
    visited[i][j] = 1

    while q:
        ti, tj = q.popleft()
        for d in range(4):
            ni = ti + di[d]
            nj = tj + dj[d]

            if (0 <= ni < N) and (0 <= nj < M):
                if (visited[ni][nj] == 0) and (arr[ni][nj] != 0):
                    q.append((ni, nj))
                    visited[ni][nj] = 1


def is_zero():
    for i in range(N):
        for j in range(M):
            if arr[i][j] != 0:
                return 0
    return 1


def check_year():
    global visited

    cnt_year = 0
    while not is_zero():
        cnt_year += 1
        melting()

        cnt = 0
        visited = [[0] * M for _ in range(N)]
        while True:
            si, sj = find_start()

            if si == -1:
                break

            bfs(si, sj)
            cnt += 1

            if cnt >= 2:
                return cnt_year

    return 0


N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]

visited = [[0] * M for _ in range(N)]

print(check_year())