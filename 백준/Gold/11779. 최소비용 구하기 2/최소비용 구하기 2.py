from heapq import heappop, heappush


def dijkstra(start):
    pq = [(0, start)]
    dists = [float('inf')]*(N+1)
    prev = [None] * (N+1)
    dists[start] = 0

    while pq:
        dist, node = heappop(pq)

        if dist > dists[node]:
            continue

        for next_dist, next_node in graph[node]:
            new_dist = dist + next_dist

            if new_dist >= dists[next_node]:
                continue

            # 거리가 새롭게 갱신되는 경우
            dists[next_node] = new_dist
            prev[next_node] = node
            heappush(pq, (new_dist, next_node))

    return dists, prev


def get_path(prev, end):
    path = []
    while end != None:
        path.append(end)
        end = prev[end]
    path.reverse()
    return path


N = int(input())
M = int(input())

graph = [[] for _ in range(N+1)]
for _ in range(M):
    s, e, w = map(int, input().split())
    graph[s].append((w, e))

S, E = map(int, input().split())

dists, prev = dijkstra(S)

path = get_path(prev, E)

print(dists[E])
print(len(path))
print(*path)