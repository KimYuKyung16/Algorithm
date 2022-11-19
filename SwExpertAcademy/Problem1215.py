import copy

T = 10

for test_case in range(1, T + 1):
    L = int(input())

    board = []
    rotated_board = [[0]*8 for _ in range(8)]
    word_list = []
    count = 0

    for i in range(8):
        board.append(list(input()))

    # board 90도 회전
    for i in range(8):
        for j in range(8):
            rotated_board[j][8-i-1] = board[i][j]

    for i in range(len(board)):
        for j in range(len(board[i])):
            if (j+L < 9):
                word1 = board[i][j:j+L]
                word2 = rotated_board[i][j:j+L]
                word_list.append(word1)
                word_list.append(word2)
            else:
                break

    word_list_copy = copy.deepcopy(word_list)

    for i in range(len(word_list_copy)):
        word_list_copy[i].reverse()

    for i in range(len(word_list)):
        default_word = word_list[i]
        reversed_word = word_list_copy[i]
        if default_word == reversed_word:
            count += 1

    print("#{} {}".format(test_case, count))

