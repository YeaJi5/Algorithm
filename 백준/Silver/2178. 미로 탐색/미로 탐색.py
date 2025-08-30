from collections import deque

di = [0, 1, 0, -1]
dj = [1, 0, -1, 0]


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

            if (0 <= ni < N) and (0 <= nj < M) and (maze[ni][nj] != 0) and (visited[ni][nj]==0):
                q.append((ni, nj))
                visited[ni][nj] = visited[ti][tj] + 1


N, M = map(int, input().split())
maze = [list(map(int, input())) for _ in range(N)]

visited = [[0]*M for _ in range(N)]

bfs(0, 0)

print(visited[N-1][M-1])