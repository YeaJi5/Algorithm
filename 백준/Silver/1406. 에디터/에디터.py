left = list(input())
right = []
N = int(input())
top = N  # 현재 커서가 위치한 인덱스

for _ in range(N):
    t = list(input().split())
    tx = t[0]

    if tx == 'L':
        if left:
            right.append(left.pop())
    elif tx == 'D':
        if right:
            left.append(right.pop())
    elif tx == 'B':
        if left:
            left.pop()
    elif tx == 'P':
        left.append(t[1])

result = ''.join(left)+''.join(reversed(right))

print(result)