def find_parents(n):
    parents = []

    while n != 0:
        parents.append(n)

        n = nodes[n][2]

        if n == 0:
            return parents


def find_common(p1, p2):
    for p in p1:
        if p in p2:
            return p


T = int(input())

for test_case in range(1, T+1):
    N = int(input())

    nodes = [[0]*3 for _ in range(N+1)]

    for _ in range(N-1):
        p, c = map(int, input().split())
        if nodes[p][0] == 0:
            nodes[p][0] = c
        else:
            nodes[p][1] = c
        nodes[c][2] = p

    n1, n2 = map(int, input().split())

    p1 = find_parents(n1)
    p2 = find_parents(n2)

    print(find_common(p1, p2))