from heapq import heappop, heappush


def dijkstra(start, end):
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

    return dists[end]


N, E = map(int, input().split())

graph = [[] for _ in range(N+1)]

for _ in range(E):
    s, e, w = map(int, input().split())
    graph[s].append((w, e))
    graph[e].append((w, s))

v1, v2 = map(int, input().split())

result1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N)
result2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N)

result = min(result1, result2)

if result == float('inf'):
    result = -1

print(result)