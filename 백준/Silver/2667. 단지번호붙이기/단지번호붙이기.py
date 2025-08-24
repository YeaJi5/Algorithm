from collections import deque

di = [0, 1, 0, -1]
dj = [1, 0, -1, 0]


def find_start():
    for i in range(N):
        for j in range(N):
            if arr[i][j] == 1 and visited[i][j] == 0:
                return i, j
    return -1, -1


def bfs(si, sj):
    q = deque()
    cnt_h = 1
    q.append((si, sj))
    visited[si][sj] = 1

    while q:
        ti, tj = q.popleft()

        for d in range(4):
            ni = ti + di[d]
            nj = tj + dj[d]

            if (0 <= ni < N) and (0 <= nj < N) and (visited[ni][nj] == 0) and (arr[ni][nj]) == 1:
                q.append((ni, nj))
                visited[ni][nj] = 1
                cnt_h += 1

    return cnt_h


N = int(input())
arr = [list(map(int, input())) for _ in range(N)]

visited = [[0] * N for _ in range(N)]

house = []
cnt = 0

while True:
    si, sj = find_start()

    if si == -1:
        break

    house.append(bfs(si, sj))

    cnt += 1

print(cnt)
print('\n'.join(map(str, sorted(house))))