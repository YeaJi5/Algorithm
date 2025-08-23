def preorder(n):
    if n != 0:
        n = ord(n)-64
        print(tree[n][0], end='')
        preorder(tree[n][1])
        preorder(tree[n][2])


def inorder(n):
    if n != 0:
        n = ord(n) - 64
        inorder(tree[n][1])
        print(tree[n][0], end='')
        inorder(tree[n][2])


def postorder(n):
    if n != 0:
        n = ord(n) - 64
        postorder(tree[n][1])
        postorder(tree[n][2])
        print(tree[n][0], end='')


N = int(input())

tree = [[0]*3 for _ in range(N+1)]

for _ in range(N):
    temp = list(input().split())
    num = ord(temp[0])-64
    for i in range(3):
        if temp[i] != '.':
            tree[num][i] = temp[i]

preorder('A')
print()
inorder('A')
print()
postorder('A')