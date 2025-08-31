def dfs(depth):
    global result

    if depth == M:      # M개를 뽑았으면 출력
        print(' '.join(map(str, result)))
        return

    for i in range(N):
        if not visited[i]:
            # 방문체크
            visited[i] = 1
            result.append(arr[i])

            dfs(depth+1)

            # 원상복귀
            result.pop()
            visited[i] = 0


N, M = map(int, input().split())
arr = list(range(1, N+1))
visited = [0]*(N+1)
result = []

dfs(0)