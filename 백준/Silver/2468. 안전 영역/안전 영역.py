from collections import deque

di = [0, 1, 0, -1]
dj = [1, 0, -1, 0]


def find_start(arr, h):
    for i in range(N):
        for j in range(N):
            if (arr[i][j] > h) and (visited[i][j] == 0):
                return i, j
    return -1, -1


def bfs(si, sj):
    q = deque()
    q.append((si, sj))
    visited[si][sj] = 1

    while q:
        ti, tj = q.popleft()

        for d in range(4):
            ni = ti + di[d]
            nj = tj + dj[d]
            if (0 <= ni < N) and (0 <= nj < N) and (visited[ni][nj] == 0) and (arr[ni][nj] > h):
                visited[ni][nj] = 1
                q.append((ni, nj))


N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]

visited = [[0]*N for _ in range(N)]

# 배열 전체에서 가장 큰 값 찾기
max_v = 0
for i in range(N):
    max_row = max(arr[i])
    max_v = max(max_row, max_v)

# 모든 높이에 대해서 안전 지대를 구해야함
cnt_max = 0
for h in range(max_v+1):        # 높이 : 0부터 9까지
    visited = [[0] * N for _ in range(N)]

    si, sj = find_start(arr, h)

    cnt_area = 0
    while True:
        bfs(si, sj)

        next_start = find_start(arr, h)
        if si == -1:
            break
        else:
            si, sj = next_start

        cnt_area += 1

    if cnt_max < cnt_area:
        cnt_max = cnt_area

print(cnt_max)