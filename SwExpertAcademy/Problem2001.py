T = int(input())
count = [0, 3, 6]

for test_case in range(1, T + 1):
    array = []
    result = 1
    for i in range(9):
        input_list = list(map(int, input().split()))
        array.append(input_list)

    # square
    for i in count:
        if (result == 0):
            break
        for j in count:
            square = set()
            for x in range(1, 4):
                square.update(array[i+(x-1)][j:j+3])
            if (len(square) != 9):
                result = 0
                break
            else:
                result = 1

    if result == 1:
        rotated_array = [[0] * 9 for _ in range(9)]
        # 90 rotate
        for i in range(9):
            for j in range(9):
                rotated_array[j][9-i-1] = array[i][j]

        # row & col
        for i in range(9):
            row = set(array[i][:9])
            col = set(rotated_array[i][:9])
            if (len(row) != 9 or len(col) != 9):
                result = 0
                break
            else:
                result = 1

    print('#{} {}'.format(test_case, result))