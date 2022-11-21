import sys
import itertools
import time

start = time.time()

sys.stdin = open("input.txt", "r")

T = int(input())

for test_case in range(1, T + 1):
    N, L = map(int, input().split()) # N: 재료의 수, L: 제한 칼로리
    ing_dic = {}
    ing = []
    combi = []
    combi2 = []
    taste_list = []

    for i in range(N):
        taste, cal = map(int, input().split()) #맛, 칼로리
        ing_dic[cal] = taste
        ing.append(cal)

    for i in range(1,N+1):
        combi.extend(list(itertools.combinations(ing, i)))

    for i in range(len(combi)):
        if sum(combi[i]) <= L:
            combi2.append(combi[i])

    combi.clear()

    for i in range(len(combi2)):
        sum = 0
        for j in range(len(combi2[i])):
            sum += ing_dic[combi2[i][j]]
        taste_list.append(sum)

    print("#{} {}".format(test_case, max(taste_list)))
