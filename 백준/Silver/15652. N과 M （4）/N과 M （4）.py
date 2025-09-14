def perm(lev, num):
    if lev == M :
        print(*path)
        return

    for i in range(num, N+1):
        path.append(i)
        perm(lev+1, i)
        path.pop()


N, M = map(int, input().split())
path = []

perm(0, 1)