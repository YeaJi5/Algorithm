N = int(input())
switch = list(map(int, input().split()))
S = int(input())
for _ in range(S):
    gender, number = map(int, input().split())

    # 남학생인 경우
    if gender == 1:
        num = number
        while num <= N:
            switch[num-1] = (switch[num-1]+1) % 2
            num += number

    # 여학생인 경우
    else:
        number -= 1
        left = right = number

        while (left-1 >= 0) and (right+1 < N) and switch[left-1]==switch[right+1]:
            right += 1
            left -= 1

        for idx in range(left, right+1):
            switch[idx] = (switch[idx]+1) % 2

for i in range(N):
    print(switch[i], end=' ')
    if (i+1) % 20 == 0:
        print()