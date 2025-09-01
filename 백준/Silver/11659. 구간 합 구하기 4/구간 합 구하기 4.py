N, M = map(int, input().split())
num_list = list(map(int, input().split()))

# 미리 배열의 누적합을 구해놓음
prefix = [0] * (N+1)
for i in range(1, N+1):
    prefix[i] = prefix[i-1] + num_list[i-1]

# 누적합의 v2인덱스의 값에서 v1-1 인덱스의 값을 빼주면
#  v1~v2 인덱스까지의 누적합이 됨
for _ in range(M):
    v1, v2 = map(int, input().split())
    print(prefix[v2] - prefix[v1-1])