import sys
sys.stdin = open("input.txt", "r", encoding='UTF8')

T = 10

for test_case in range(1, T + 1):
    N = input()
    find_string = input()
    sentence = input()

    print("#{} {}".format(test_case, sentence.count(find_string)))