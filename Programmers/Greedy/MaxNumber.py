# 앞에서부터 작은 수 빼기

def solution(number, k):
    answer = ''
    count = 0
    
    while count != k:
        for i in range(0, len(number)):
            if number[i] < number[i+1]:
                number = number.replace(number[i], '')
                count += 1
                break
    print(number)
    
    
    return answer