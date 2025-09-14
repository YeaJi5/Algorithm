def perm(lev, num):
    if lev == M:
        print(*path)
        return

    for idx in range(num, N):
        path.append(num_list[idx])
        perm(lev+1, idx+1)
        path.pop()


N, M = map(int, input().split())
num_list = list(map(int, input().split()))
num_list.sort()
path = []

perm(0, 0)