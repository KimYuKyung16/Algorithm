T = 10

for test_case in range(1, T + 1):
    answer = 0
    N = int(input()) # 건물의 개수
    arr = list(map(int, input().split())) # 건물의 높이
 
    for i in range(N):
        if (arr[i] == 0):
            continue
        else:
            current = arr[i]
            left1 = arr[i-1]
            left2 = arr[i-2]
            right1 = arr[i+1]
            right2 = arr[i+2]
            if ((current-left1) > 0 and (current-left2) > 0 and (current-right1) > 0 and (current-right2) > 0):
                arr2 = [(current-left1), (current-left2), (current-right1), (current-right2)]
                answer += min(arr2)
 
    print("#" + str(test_case), str(answer))