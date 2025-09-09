def calc(oper_p):
    result = num_list[0]
    op = 0

    for idx in range(1, N):
        if oper_p[op] == '+':
            result = result + num_list[idx]
        elif oper_p[op] == '-':
            result = result - num_list[idx]
        elif oper_p[op] == '*':
            result = result * num_list[idx]
        elif oper_p[op] == '/':
            result = int(result / num_list[idx])
        op += 1
    return result


def recur(cnt):
    global oper_v, path, min_v, max_v

    if cnt == N-1:
        v = calc(path)
        min_v = min(min_v, v)
        max_v = max(max_v, v)
        return

    for i in range(N-1):
        if oper_v[i]:
            continue
        oper_v[i] = 1
        path.append(operators[i])
        recur(cnt+1)
        path.pop()
        oper_v[i] = 0


def num_to_oper():
    operators = []
    for i in range(4):
        if oper_cnt[i] != 0:
            for idx in range(oper_cnt[i]):
                operators.append(oper[i])
    return operators


# 수의 개수
N = int(input())
num_list = list(map(int, input().split()))
oper = ['+', '-', '*', '/']
oper_cnt = list(map(int, input().split()))

operators = num_to_oper()

min_v = 9999999999999999999999
max_v = -9999999999999999999999
oper_v = [0]*(N-1)
path = []

recur(0)

print(max_v)
print(min_v)