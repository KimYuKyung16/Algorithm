import sys
sys.stdin = open('sample_input.txt', 'r')

T = int(input())

direction_list = {'up':[-1,0], 'left':[0,-1], 'right':[0,1]}

for test_case in range(1, T + 1):
    M, N = map(int, input().split()) # M: row, column, N: robot
    robot_list = []
    count = 0

    for i in range(N):
        x, y = map(int, input().split())
        robot_list.append([x-1, y-1])

        board = [[0] * M for _ in range(M)]

    print(robot_list)

    for i in range(N):
        x = robot_list[i][0]
        y = robot_list[i][1]
        board[x][y] = 1

    print(board)

    board_string = []
    board_set = set(board_string)

    for i in range(len(board)):
        for j in range(len(board)):
            for k in range(len(board)):
                board_string.append(''.join(map(str, board[k])))
            if board_set == 2:
                break

            if board[i][j] == 1 and board[i][j + 1] == 1:  # right
                count += 1
                direction = 'right';

                for i in range(len(robot_list)):
                    if robot_list[i][1] == len(board):
                        continue
                    else:
                        robot_list[i][0] += direction_list[direction][0]
                        robot_list[i][1] += direction_list[direction][1]

                board = [[0] * M for _ in range(M)]
                for i in range(N):
                    x = robot_list[i][0]
                    y = robot_list[i][1]
                    board[x][y] = 1
            else:
                count += 1
                direction = 'up'
                for i in range(len(robot_list)):
                    if robot_list[i][0] == 0:
                        continue
                    else:
                        robot_list[i][0] += direction_list[direction][0]
                        robot_list[i][1] += direction_list[direction][1]

                board = [[0] * M for _ in range(M)]
                for i in range(N):
                    x = robot_list[i][0]
                    y = robot_list[i][1]
                    board[x][y] = 1

                print(board)

    print("#{} {}".format(test_case, count))






