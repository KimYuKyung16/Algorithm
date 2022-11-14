# 하나의 문자열로 만든 후에 0을 기준으로 나눈다
# 그 중에 111이 in으로 되어있는지 확인하고 있으면 +1

T = int(input())

for test_case in range(1, T + 1):
    N, K = map(int, input().split())
    input_word = ''
    count = 0

    for i in range(K):
        input_word += '1'

    board = []
    rotated_board = [[0] * N for _ in range(N)]

    for i in range(N):
        board_list = ''.join(list(map(str, input().split())))
        board.append(board_list)
        board_list = board_list.split('0')
        count += board_list.count(input_word)

    # 퍼즐 90도 회전
    for i in range(N):
        for j in range(N):
            rotated_board[j][N-i-1] = board[i][j]

    for i in range(N):
        rotated_board_list = ''.join(rotated_board[i])
        rotated_board_list = rotated_board_list.split('0')
        count += rotated_board_list.count(input_word)

    print('#{} {}'.format(test_case, count))