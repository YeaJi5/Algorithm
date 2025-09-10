from collections import deque

di = [-1, 0, 1, 0]
dj = [0, -1, 0, 1]


def find_start():
    for i in range(N):
        for j in range(N):
            if arr[i][j] == 9:
                return i, j


# 현재 위치가 i, j 일때 가까운 물고기들의 후보군을 구함
# size가 들어가는 이유는 자신보다 큰 물고기는 후보군이 될 수 없기 때문
def find_fish(i, j, size):
    q = deque()
    visited = [[-1] * N for _ in range(N)]

    q.append((i, j))
    visited[i][j] = 0

    fish = []

    while q:
        ti, tj = q.popleft()
        for d in range(4):
            ni = ti + di[d]
            nj = tj + dj[d]

            if (0 <= ni < N) and (0 <= nj < N) and (visited[ni][nj] == -1):
                # 상어가 지나갈 수 있는 칸
                if arr[ni][nj] <= size:
                    visited[ni][nj] = visited[ti][tj] + 1
                    q.append((ni, nj))

                    # 상어가 먹을 수 있는 크기의 물고기
                    if 0 < arr[ni][nj] < size:
                        # 방문 배열의 값이 해당 위치에서 이동한 거리
                        # 이 순서로 저장하는 이유는 물고기 우선순위 때문에!
                        fish.append((visited[ni][nj], ni, nj))
    return fish


def move_shark(i, j, size):
    global move_cnt, eat_cnt

    while True:
        fish = find_fish(i, j, size)

        if not fish:
            return

        fish.sort()

        dist, ni, nj = fish[0]
        
        # 상어의 위치를 물고기의 위치로 옮겨줌
        i, j = ni, nj
        
        # 원래 자리에서 이동한 만큼의 거리를 더해줌
        move_cnt += dist

        arr[ni][nj] = 0
        eat_cnt += 1
        if eat_cnt == size:
            size += 1
            eat_cnt = 0


# 입력
N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]

i, j = find_start()
arr[i][j] = 0  # 시작 위치 비워줌
size = 2
move_cnt = eat_cnt = 0

move_shark(i, j, size)

print(move_cnt)