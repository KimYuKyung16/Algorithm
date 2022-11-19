T = 10

for test_case in range(1, T + 1):
    N = input()
    array = []
    rotated_array = [[0] * 100 for _ in range(100)]
    sum_array = []
    sum1 = 0 # 대각선1
    sum2 = 0 # 대각선2

    for i in range(100): # 원래 배열
        num_list = list(map(int, input().split()))
        array.append(num_list)

    for i in range(100): # 90도 회전한 배열
        for j in range(100):
            rotated_array[j][100-i-1] = array[i][j]

    for i in range(100): # 대각선 합
        sum1 += array[i][i]
        sum2 += rotated_array[i][j]

    sum_array.append(sum1)
    sum_array.append(sum2)

    for i in array: # 행 합
        sum_array.append(sum(i))

    for j in rotated_array: # 열 합
        sum_array.append(sum(j))

    print("#{} {}".format(test_case, max(sum_array)))



