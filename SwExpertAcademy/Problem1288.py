T = int(input())
number_list = set()

for test_case in range(1, T + 1):
    N = int(input())
    count = 0
    cal_number = 0
    while True:
        if (len(number_list) == 10):
            print('#'+str(test_case), str(cal_number))
            number_list.clear()
            break
        else:
            cal_number = str((count+1) * N)
            cal_number_list = list(cal_number)
            number_list.update(cal_number_list)
            count += 1