import sys
sys.stdin = open("input.txt", "r")

T = 10

for test_case in range(1, T + 1):
    N = input()
    n1, n2 = map(int, input().split())
    result = 1

    for i in range(n2):
        result *= n1

    print("#{} {}".format(test_case, result))



