T = int(input())

for test_case in range(1, T + 1):
    word = input()
    num = len(word) // 2

    result = 1

    for i in range(num):
        if (word[i] == word[-1-i]):
            continue
        else:
            result = 0
            break
    print('#{} {}'.format(test_case, result))