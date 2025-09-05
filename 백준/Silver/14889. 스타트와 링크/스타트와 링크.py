import itertools


def sum_power(t1, t2):
    # 여기서 전체에서 2개를 고르는 조합을 다시 해줘야 함
    sum_start = 0
    sum_link = 0

    for comb in itertools.combinations(t1, 2):
        i, j = comb
        sum_start += arr[i][j]
        sum_start += arr[j][i]

    for comb in itertools.combinations(t2, 2):
        i, j = comb
        sum_link += arr[i][j]
        sum_link += arr[j][i]

    return abs(sum_start - sum_link)


def div_team():
    global min_diff

    for comb in itertools.combinations(range(N), N//2):
        visited = [0] * N
        team_start = []
        team_link = []

        for i in comb:
            visited[i] = 1

        for i in range(N):
            if visited[i] == 1:
                team_start.append(i)
            else:
                team_link.append(i)

        diff = sum_power(team_start, team_link)

        min_diff = min(min_diff, diff)

    return min_diff


N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]

min_diff = float('inf')

print(div_team())