T = int(input())

value_list = ['P', 'Q', 'R', 'S', 'W']

for test_case in range(1, T + 1):
    input_list = list(map(int, input().split()))
    water_dic = {}

    for i in range(len(value_list)):
        water_dic[value_list[i]] = input_list[i]

    # A회사 수도요금 계산
    A_price = water_dic['W'] * water_dic['P']

    # B회사 수도요금 계산
    if (water_dic['W'] <= water_dic['R']):
        B_price = water_dic['Q']
    else:
        B_price = water_dic['Q']
        B_price += (water_dic['W'] - water_dic['R']) * water_dic['S']

    if (A_price >= B_price):
        print('#'+str(test_case), str(B_price))
    else:
        print('#' + str(test_case), str(A_price))