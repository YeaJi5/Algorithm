from heapq import heappop, heappush

di = [0, 1, 0, -1]
dj = [1, 0, -1, 0]


def dijkstra(si, sj):
    cnts = [[float('inf')]*M for _ in range(N)]
    cnts[si][sj] = 0
    pq = [(0, si, sj)]

    while pq:
        cnt, i, j = heappop(pq)

        if cnt > cnts[i][j]:
            continue

        for d in range(4):
            ni = i + di[d]
            nj = j + dj[d]

            if (0 <= ni < N) and (0 <= nj < M):
                new_cnt = cnt + maze[ni][nj]

                if new_cnt >= cnts[ni][nj]:
                    continue

                cnts[ni][nj] = new_cnt
                heappush(pq, (new_cnt, ni, nj))

    return cnts[N-1][M-1]


M, N = map(int, input().split())
maze = [list(map(int, input())) for _ in range(N)]

result = dijkstra(0, 0)

print(result)