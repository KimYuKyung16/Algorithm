T = int(input())

for test_case in range(1, T + 1):
    N = int(input())
    result = [[1]]

    for i in range(2, 2+N-1):
        num_list = []
        for j in range(i):
            if j == 0 or j == (i-1):
                num_list.append(1)
            else:
                num_list.append(result[-1][j-1] + result[-1][j])
        result.append(num_list)

    print('#' + str(test_case))
    for i in range(len(result)):
        print(' '.join(map(str, result[i])))
