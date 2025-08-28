stack = []

def push(num):
    stack.append(num)


def my_pop():
    if is_empty():
        print(-1)
    else:
        print(stack.pop())


def is_empty():
    if len(stack) > 0:
        return 0
    else:
        return 1


def size():
    print(len(stack))


def top():
    if stack:
        print(stack[-1])
    else:
        print(-1)


N = int(input())
for _ in range(N):
    m = list(input().split())

    sm = m[0]

    if sm == 'push':
        push(m[1])
    elif sm == 'pop':
        my_pop()
    elif sm == 'size':
        size()
    elif sm == 'empty':
        print(is_empty())
    elif sm == 'top':
        top()