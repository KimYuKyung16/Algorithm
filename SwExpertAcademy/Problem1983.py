import sys
sys.stdin = open("input.txt", "r")

T = int(input())
grade = ['A+', 'A0', 'A-', 'B+', 'B0', 'B-', 'C+', 'C0', 'C-', 'D0']

for test_case in range(1, T + 1):
    N, K = map(int, input().split())
    student = []
    ratio = N / 10

    for i in range(N):
        middle, final, homework = map(int, input().split())

        middle = 35 * (middle/100)
        final = 45 * (final/100)
        homework = 20 * (homework/100)
        sum = middle + final + homework

        student.append((i+1, sum))
        student_order = sorted(student, key=lambda x:x[1], reverse=True)

    for i in range(N):
        if student_order[i][0] == K:
            index = i+1
            break

    for i in range(0, 10):
        if index > (ratio * i) and index <= (ratio * (i+1)):
            print('#{} {}'.format(test_case, grade[i]))