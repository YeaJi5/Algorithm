from heapq import heappush, heappop


def dijkstra(start_node):
    pq = [(0, start_node)]
    dists = [float('inf')]*(V+1)
    dists[start_node] = 0

    while pq:
        dist, node = heappop(pq)

        if dist > dists[node]:
            continue

        for next_dist, next_node in graph[node]:
            new_dist = dist + next_dist

            if new_dist > dists[next_node]:
                continue

            dists[next_node] = new_dist
            heappush(pq, (new_dist, next_node))

    return dists


V, E = map(int, input().split())
K = int(input())
graph = [[] for _ in range(V+1)]

for _ in range(E):
    s, e, w = map(int, input().split())
    graph[s].append((w, e))

result = dijkstra(K)

for i in range(1, V+1):
    if result[i] == float('inf'):
        print('INF')
    else:
        print(result[i])