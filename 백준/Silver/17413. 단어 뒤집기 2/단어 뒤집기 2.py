word_list = list(input())

# print(word_list)


stack = []
result = []
N = len(word_list)

flag = 0

for ch in word_list:
    if ch == '<':
        flag = 1
    elif ch == '>':
        flag = 0

    if ch == '<' or ch == ' ':
        while stack:
            result.append(stack.pop())
        result.append(ch)
    elif ch == '>':
        result.append(ch)
    elif flag == 1:
        result.append(ch)
    elif flag == 0:
        stack.append(ch)

while stack:
    result.append(stack.pop())

print(''.join(result))