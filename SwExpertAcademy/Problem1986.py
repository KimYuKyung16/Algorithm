T = int(input())

for test_case in range(1, T + 1):
    N = int(input())
    count = 1
    sum = 0

    for i in range(1, N+1):
        if (count%2 == 1):
            sum += i
        else:
            sum -= i
        count += 1

    print('#' + str(test_case), str(sum))