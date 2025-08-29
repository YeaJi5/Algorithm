def find_delete_node(d):
    if d != -1:
        find_delete_node(tree[d][0])
        find_delete_node(tree[d][1])
        delete_node(d)


def delete_node(d):
    parent = tree[d][2]
    if parent != -1:
        if tree[parent][0] == d:
            tree[parent][0] = -1
        elif tree[parent][1] == d:
            tree[parent][1] = -1
    tree[d][0] = -9
    tree[d][1] = -9
    tree[d][2] = -9


def find_leaf(tree):
    cnt = 0
    for i in range(N):
        if (tree[i][0] == -1) and (tree[i][1] == -1):
            cnt += 1
    return cnt


N = int(input())
temp = list(map(int, input().split()))
D = int(input())
tree = [[-1] * 3 for _ in range(N)]

for i in range(N):
    if temp[i] != -1:
        tree[i][2] = temp[i]
        if tree[temp[i]][0] == -1:
            tree[temp[i]][0] = i
        else:
            tree[temp[i]][1] = i


find_delete_node(D)
print(find_leaf(tree))