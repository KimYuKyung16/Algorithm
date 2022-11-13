T = int(input())

for test_case in range(1, T + 1):
    N = input()
    arr = list(map(int, input().split()))

    dic = {}

    for i in arr:
        if (dic.get(i) == None):
            dic[i] = 1
        else:
            dic[i] += 1

    dic = dict(sorted(dic.items(), key=lambda x:x[1], reverse=True))
    max_nums = []
    for k , v in zip(dic.keys(), dic.values()):
        if (v == max(dic.values())):
            max_nums.append(k)

    print("#" + str(test_case), str(max(max_nums)))