def solution(n):
    num0 = 0
    num1 = 1
    
    for i in range(2, n+1):
        sumResult = num0 + num1
        num0 = num1
        num1 = sumResult
                   
    return sumResult % 1234567