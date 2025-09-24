from collections import deque


def snake(i, j):
    q = deque()
    q.append((i, j))
    game_sec = 0
    temp_dir = 0

    for sec, dir in move_list:
        while game_sec < int(sec):
            game_sec += 1
            ni = i + direction[temp_dir][0]
            nj = j + direction[temp_dir][1]

            i, j = ni, nj

            if (0 <= ni < N and 0 <= nj < N):
                if (ni, nj) in q:           # 자신의 몸과 부딪힌 경우
                    return game_sec
                elif arr[ni][nj] == 1:      # 해당 칸에 사과가 있는 경우 - 머리만 이동해서 몸 길이를 늘림
                    q.append((ni, nj))
                    arr[ni][nj] = 0
                else:                       # 그냥 지나가는 길
                    q.append((ni, nj))
                    q.popleft()
            else:                           # 벽이랑 부딪힌 경우
                return game_sec

        # 오른쪽으로 90도 회전
        if dir == 'D':
            temp_dir = (temp_dir+1) % 4
        # 왼쪽으로 90도 회전
        else:
            temp_dir = (temp_dir-1) % 4

    while True:
        game_sec += 1
        ni = i + direction[temp_dir][0]
        nj = j + direction[temp_dir][1]

        i, j = ni, nj

        if (0 <= ni < N and 0 <= nj < N):
            if (ni, nj) in q:  # 자신의 몸과 부딪힌 경우
                return game_sec
            elif arr[ni][nj] == 1:  # 해당 칸에 사과가 있는 경우 - 머리만 이동해서 몸 길이를 늘림
                q.append((ni, nj))
                arr[ni][nj] = 0
            else:  # 그냥 지나가는 길
                q.append((ni, nj))
                q.popleft()
        else:  # 벽이랑 부딪힌 경우
            return game_sec


# 오른쪽부터 시계방향으로 0 1 2 3 ->
direction = [(0, 1), (1, 0), (0, -1), (-1, 0)]

# 배열의 크기를 받아서 빈 배열을 만들어줌
N = int(input())
arr = [[0]*N for _ in range(N)]

# 사과의 개수(k)를 받아서 사과를 위치시킴
K = int(input())
for _ in range(K):
    apple_x, apple_y = map(int, input().split())
    arr[apple_x-1][apple_y-1] = 1

# 뱀의 이동경로
move_list = []
L = int(input())
for _ in range(L):
    move = tuple(input().split())
    move_list.append(move)

print(snake(0, 0))