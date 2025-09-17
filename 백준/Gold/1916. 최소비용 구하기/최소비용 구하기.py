from heapq import heappush, heappop


def dijkstra(start_node):
    costs = [float('inf')]*(N+1)
    pq = [(0, start_node)]
    costs[start_node] = 0

    while pq:
        cost, node = heappop(pq)

        if cost > costs[node]:
            continue

        for next_cost, next_node in graph[node]:
            new_cost = cost + next_cost

            if new_cost >= costs[next_node]:
                continue

            costs[next_node] = new_cost
            heappush(pq, (new_cost, next_node))

    return costs[E]


N = int(input())
M = int(input())

graph = [[] for _ in range(N+1)]

for _ in range(M):
    s, e, c = map(int, input().split())
    graph[s].append((c, e))

S, E = map(int, input().split())

print(dijkstra(S))