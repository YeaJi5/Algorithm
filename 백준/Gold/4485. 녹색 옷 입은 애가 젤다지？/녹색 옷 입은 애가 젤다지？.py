from heapq import heappop, heappush

di = [1, 0, -1, 0]
dj = [0, 1, 0, -1]


def dijkstra(i, j, N):
    cost = [[float('inf')]*N for _ in range(N)]
    pq = [(arr[i][j], i, j)]
    cost[i][j] = arr[i][j]

    while pq:
        next_cost, si, sj = heappop(pq)

        if next_cost > cost[si][sj]:
            continue

        for d in range(4):
            ni = si + di[d]
            nj = sj + dj[d]

            if (0 <= ni < N and 0 <= nj < N):
                new_cost = next_cost + arr[ni][nj]

                if new_cost >= cost[ni][nj]:
                    continue

                cost[ni][nj] = new_cost
                heappush(pq, (new_cost, ni, nj))

    return cost[N-1][N-1]


N = int(input())
num = 1
while N != 0:
    arr = [list(map(int, input().split())) for _ in range(N)]

    print(f'Problem {num}: {dijkstra(0, 0, N)}')

    num += 1
    N = int(input())