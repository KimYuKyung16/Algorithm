T = int(input())

# N: 배열 크기, M: 파리채 크기

for test_case in range(1, T + 1):
    N, M = map(int, input().split())
    array = []
    sum_result = 0
    sum_list = []

    for i in range(N):
        input_list = list(map(int, input().split()))
        array.append(input_list)

    for i in range(N-M+1):
        for j in range(N-M+1):
            for x in range(M):
                sum_result += sum(list(map(int, array[i+x][j:j+M])))
            sum_list.append(sum_result)
            sum_result = 0
    print('#{} {}'.format(test_case, max(sum_list)))






