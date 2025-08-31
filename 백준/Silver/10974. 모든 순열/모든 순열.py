from itertools import permutations

N = int(input())
arr = list(range(1, N+1))

for p in sorted(permutations(arr)):
    print(' '.join(map(str, p)))
