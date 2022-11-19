T = int(input())

for test_case in range(1, T + 1):
    N = int(input())
    farm = []
    money = 0

    for i in range(N):
        farm.append(input())

    default_x = N // 2

    for i in range(default_x + 1):
        money_list = []

        if i == default_x:
            money += sum(list(map(int, farm[i][default_x-i:default_x+i+1])))
        else:
            money += sum(list(map(int, farm[i][default_x-i:default_x+i+1])))
            money += sum(list(map(int, farm[-1 - i][default_x-i:default_x+i+1])))


    print("#{} {}".format(test_case, money))