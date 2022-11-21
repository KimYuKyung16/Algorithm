import sys
sys.stdin = open("input.txt", "r")

T = 10

for test_case in range(1, T + 1):
    N = int(input())
    count = 0

    board = []
    rotated_board = [[0] * N for _ in range(N)]
    for i in range(N):
        array = list(map(int, input().split()))
        board.append(array)

    for i in range(N):
        for j in range(N):
            rotated_board[j][N-i-1] = board[i][j]

    for i in range(100):
        for j in range(rotated_board[i].count(0)):
            rotated_board[i].remove(0)

    for i in range(100):
        for j in range(len(rotated_board[i])-1):
            if rotated_board[i][j] == 1:
                continue
            else:
                if rotated_board[i][j+1] == 1:
                    count += 1
                else:
                    continue

    print("#{} {}".format(test_case, count))

