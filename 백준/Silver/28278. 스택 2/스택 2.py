def is_empty():
    global stack
    global top
    if top >= 0:
        return False
    else:
        return True


def push(n):
    global stack
    global top
    top += 1
    stack[top] = n



def my_pop():
    global stack
    global top

    if is_empty():      # 스택이 비어있음
        return -1
    else:
        top -= 1
        return stack[top+1]


def stack_num(num):
    global stack
    global top
    global ans

    n = num[0]

    if len(num) == 2:
        push(num[1])
    elif n == 2:
        ans.append(my_pop())
    elif n == 3:
        ans.append(top+1)
    elif n == 4:
        if top == -1:
            ans.append(1)
        else:
            ans.append(0)
    elif n == 5:
        if top >= 0:
            ans.append(stack[top])
        else:
            ans.append(-1)


N = int(input())

stack = [0] * N
ans = []
top = -1

for _ in range(N):
    num = list(map(int, input().split()))
    stack_num(num)

print("\n".join(map(str, ans)))