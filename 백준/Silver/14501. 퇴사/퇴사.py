def recur(day, sum_cost):
    global max_cost

    if day >= N:
        max_cost = max(sum_cost, max_cost)
        return

    if day+s[day][0] <= N:
        # 해당 일에 상담을 잡는 경우
        recur(day+s[day][0], sum_cost+s[day][1])

    # 해당 일에 상담을 잡지 않는 경우
    recur(day+1, sum_cost)


N = int(input())

s = [[0, 0] for _ in range(N)]

for i in range(N):
    day, cost = map(int, input().split())
    s[i][0] = day
    s[i][1] = cost

max_cost = 0

recur(0, 0)

print(max_cost)