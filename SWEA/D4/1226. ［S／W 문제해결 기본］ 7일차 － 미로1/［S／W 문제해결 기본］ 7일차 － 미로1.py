from collections import deque

di = [0, 1, 0, -1]
dj = [1, 0, -1, 0]


def find_start():
    for i in range(N):
        for j in range(N):
            if maze[i][j] == 2:
                return i, j


def bfs(si, sj):
    q = deque()
    q.append((si, sj))
    visited[si][sj] = 1

    while q:
        ti, tj = q.popleft()

        if maze[ti][tj] == 3:
            return 1

        for d in range(4):
            ni = ti + di[d]
            nj = tj + dj[d]

            if (0 <= ni < N and 0 <= nj < N):
                if (visited[ni][nj] == 0 and maze[ni][nj] != 1):
                    visited[ni][nj] = visited[ti][tj] + 1
                    q.append((ni, nj))

    return 0


T = 10

for test_case in range(1, T+1):
    tc = int(input())
    N = 16

    maze = [list(map(int, input())) for _ in range(N)]
    visited = [[0]*N for _ in range(N)]

    si, sj = find_start()

    print(f'#{test_case} {bfs(si, sj)}')