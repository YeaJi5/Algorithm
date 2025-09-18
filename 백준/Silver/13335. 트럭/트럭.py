from collections import deque

n, w, L = map(int, input().split())
trucks = list(map(int, input().split()))

bridge = deque([0] * w)  # 다리 상태 (길이 w)
time = 0
current_weight = 0

while trucks or current_weight > 0:
    time += 1
    # 1. 다리 맨 앞 칸 pop (트럭이 나감)
    # bridge.popleft가 맨 앞에 있는 트럭의 무게 -> 없으면 0
    current_weight -= bridge.popleft()

    # 2. 다음 트럭 올릴 수 있으면 push
    if trucks and current_weight + trucks[0] <= L:
        t = trucks.pop(0)
        bridge.append(t)
        current_weight += t
    else:
        bridge.append(0)

print(time)