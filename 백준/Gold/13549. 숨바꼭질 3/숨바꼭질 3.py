from heapq import heappush, heappop


def dijkstra(start):
    time = [float('inf')]*100001
    time[start] = 0
    pq = [(0, start)]

    while pq:
        sec, location = heappop(pq)

        if sec > time[location]:
            continue

        for i in range(3):
            if i == 0:
                new_sec = sec+1
                new_location = location+1

                if 0 <= new_location <= 100000:
                    if new_sec >= time[new_location]:
                        continue

                    time[new_location] = new_sec
                    heappush(pq, (new_sec, new_location))
            elif i == 1:
                new_sec = sec + 1
                new_location = location - 1

                if 0 <= new_location <= 100000:
                    if new_sec >= time[new_location]:
                        continue

                    time[new_location] = new_sec
                    heappush(pq, (new_sec, new_location))
            else:
                new_sec = sec
                new_location = location*2
                if 0 <= new_location <= 100000:
                    if new_sec >= time[new_location]:
                        continue

                    time[new_location] = new_sec
                    heappush(pq, (new_sec, new_location))

    return time[K]


N, K = map(int, input().split())

print(dijkstra(N))