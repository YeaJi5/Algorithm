from collections import deque

di = [0, 1, 0, -1]
dj = [1, 0, -1, 0]

# 외부 공기 찾기
def find_outside_air():
    air = [[0]*M for _ in range(N)]
    q = deque()
    q.append((0, 0))
    air[0][0] = 1  # (0,0)은 항상 외부 공기

    while q:
        ti, tj = q.popleft()
        for d in range(4):
            ni, nj = ti + di[d], tj + dj[d]

            if 0 <= ni < N and 0 <= nj < M:
                if cheese[ni][nj] == 0 and air[ni][nj] == 0:
                    air[ni][nj] = 1
                    q.append((ni, nj))
    return air

# 이번 턴에 녹을 치즈 찾기
def find_melt(air):
    melt = []
    for i in range(N):
        for j in range(M):
            if cheese[i][j] == 1:  # 치즈일 때
                for d in range(4):
                    ni, nj = i + di[d], j + dj[d]

                    if 0 <= ni < N and 0 <= nj < M:
                        if air[ni][nj] == 1:  # 외부 공기와 접촉
                            melt.append((i, j))
                            break
    return melt


def cur_cheese():
    cnt = 0
    for i in range(N):
        for j in range(M):
            if cheese[i][j] == 1:
                cnt += 1
    return cnt


def melting():
    time = 0
    last_cheese = 0

    while True:
        # 현재 치즈 개수
        current_cheese = cur_cheese()

        if current_cheese == 0:  # 다 녹음
            return time, last_cheese
        
        # 치즈를 녹이기 전의 치즈의 개수를 저장해둠
        last_cheese = current_cheese

        # 외부 공기 찾기
        air = find_outside_air()

        # 녹을 치즈 찾기
        to_melt = find_melt(air)

        # 치즈 녹이기
        for i, j in to_melt:
            cheese[i][j] = 0

        time += 1


N, M = map(int, input().split())
cheese = [list(map(int, input().split())) for _ in range(N)]

time, last_cheese = melting()
print(time)
print(last_cheese)
