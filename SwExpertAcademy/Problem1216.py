import sys
sys.stdin = open("input.txt", "r")

T = 10

for test_case in range(1, T + 1):
    n = input()
    board = []
    rotated_board = [[0] * 100 for _ in range(100)]
    word_list = []

    # 기본
    for i in range(100):
        array = list(input())
        board.append(array)

    # 90도
    for i in range(100):
        for j in range(100):
            rotated_board[j][100-i-1] = board[i][j]

    for i in range(100):
        for j in range(100):
            for k in range(100):
                if j+k > 100:
                    continue
                word = board[i][j:j+k]

                if word == list(reversed(word)):
                    word_list.append(word)
                    break
                else:
                    continue

    for i in range(100):
        for j in range(100):
            for k in range(100):
                if j+k > 100:
                    continue
                word = rotated_board[i][j:j+k]

                if word == list(reversed(word)):
                    word_list.append(len(word))
                    break
                else:
                    continue

    # word_list.sort(reverse=True)
    print(word_list)

