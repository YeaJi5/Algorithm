# 조합

def perm(start, cnt):
    if cnt == M:
        print(*path)
        return

    for i in range(start, N):
        path.append(num_list[i])
        perm(i+1, cnt+1)
        path.pop()



N, M = map(int, input().split())

path = []
visited = [0]*(N+1)
num_list = list(range(1, N+1))

perm(0, 0)
