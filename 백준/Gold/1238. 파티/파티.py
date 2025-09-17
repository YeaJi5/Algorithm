from heapq import heappush, heappop


def dijkstra(start, graph):
    pq = [(0, start)]
    dists = [float('inf')]*(N+1)
    dists[start] = 0

    while pq:
        dist, node = heappop(pq)

        if dist > dists[node]:
            continue

        for next_dist, next_node in graph[node]:
            new_dist = dist + next_dist

            if new_dist >= dists[next_node]:
                continue

            dists[next_node] = new_dist
            heappush(pq, (new_dist, next_node))

    return dists


N, M, X = map(int, input().split())

graph = [[] for _ in range(N+1)]
graph_reverse = [[] for _ in range(N+1)]
for _ in range(M):
    s, e, t = map(int, input().split())
    graph[s].append((t, e))
    graph_reverse[e].append((t, s))

to_X = dijkstra(X, graph)
from_X = dijkstra(X, graph_reverse)

max_dist = 0
for i in range(1, N+1):
    if i != X:
        max_dist = max(max_dist, to_X[i]+from_X[i])

print(max_dist)