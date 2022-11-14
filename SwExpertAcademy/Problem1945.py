T = int(input())

number_list = [2, 3, 5, 7, 11]
answer = []

for test_case in range(1, T + 1):
    N = int(input())

    for i in number_list:
        exp = 0
        while ((N%i) == 0):
            N = N // i
            exp += 1
        answer.append(exp)
        exp = 0

    print('#'+str(test_case), ' '.join(map(str, answer)))
    answer.clear()