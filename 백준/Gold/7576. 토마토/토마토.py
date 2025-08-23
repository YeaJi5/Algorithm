from collections import deque

di = [0, 1, 0, -1]
dj = [1, 0, -1, 0]


# 시작점 찾기
def find_start(arr):
    l = []
    for i in range(N):
        for j in range(M):
            if arr[i][j] == 1:
                l.append((i, j))
    return l


# bfs
def bfs(start_list, arr):
    global cnt
    max_cnt = 0
    q = deque()
    # 모든 시작점을 큐에 넣어줌
    for si, sj in start_list:
        q.append((si, sj, cnt))

    # 큐에 원소가 없을 때까지 돌리기
    while q:
        ti, tj, cnt = q.popleft()
        flag = 0

        for d in range(4):

            ni = ti + di[d]
            nj = tj + dj[d]

            if (0 <= ni < N) and (0 <= nj < M) and (arr[ni][nj] == 0) :
                arr[ni][nj] = 1
                q.append((ni, nj, cnt+1))

        if max_cnt < cnt:
            max_cnt = cnt

    for row in arr:
        if 0 in row:
            return -1

    return max_cnt


M, N = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]

start_list = find_start(arr)
cnt = 0

print(bfs(start_list, arr))