T = int(input())
 
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.  
for test_case in range(1, T + 1):
    N = int(input())
    arr = list(map(int, input().split()))
 
    money = 0
    max_num = arr[-1]
     
    for i in range(len(arr)):        
        if (arr[-1] <= max_num):
            money += (max_num - arr.pop())
        else:
            max_num = arr[-1]
            arr.pop()     
    print('#' + str(test_case), str(money))