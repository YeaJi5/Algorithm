from heapq import heappop, heappush


def dijkstra(start):
    pq = [(0, start)]
    dists = [float('inf')]*(N+1)
    dists[start] = 0

    while pq:
        dist, node = heappop(pq)

        if dist > dists[node]:
            continue

        for next_dist, next_node in graph[node]:
            new_dist = next_dist + dist

            if new_dist >= dists[next_node]:
                continue

            dists[next_node] = new_dist
            heappush(pq, (new_dist, next_node))

    return dists


N, M, K, X = map(int, input().split())

graph = [[] for _ in range(N+1)]

for _ in range(M):
    s, e = map(int, input().split())
    graph[s].append((1, e))

result = dijkstra(X)

flag = 1
for i in range(1, N+1):
    if result[i] == K:
        print(i)
        flag = 0

if flag:
    print(-1)