def solution(n):
    answer = 0
    startNum = 0
    sumResult = 0
    
    while startNum <= n:
        startNum += 1
        sumResult = 0
        for i in range(startNum, n+1):
            sumResult += i
            
            if sumResult > n:
                break
            elif sumResult == n:
                answer += 1
                break
            else:
                continue
            
    return answer
    

'''
정확성  테스트
테스트 1 〉	통과 (0.01ms, 10.2MB)
테스트 2 〉	통과 (0.58ms, 10.1MB)
테스트 3 〉	통과 (0.26ms, 10.2MB)
테스트 4 〉	통과 (0.54ms, 10.1MB)
테스트 5 〉	통과 (0.08ms, 10MB)
테스트 6 〉	통과 (0.02ms, 10.1MB)
테스트 7 〉	통과 (0.23ms, 10.2MB)
테스트 8 〉	통과 (0.13ms, 10.1MB)
테스트 9 〉	통과 (0.03ms, 10.1MB)
테스트 10 〉	통과 (0.45ms, 10.1MB)
테스트 11 〉	통과 (0.47ms, 10.1MB)
테스트 12 〉	통과 (0.28ms, 10.2MB)
테스트 13 〉	통과 (0.29ms, 10.1MB)
테스트 14 〉	통과 (0.29ms, 10.3MB)
테스트 15 〉	통과 (0.00ms, 10.1MB)
테스트 16 〉	통과 (0.00ms, 10.1MB)
테스트 17 〉	통과 (0.03ms, 10.2MB)
테스트 18 〉	통과 (0.00ms, 10.1MB)
효율성  테스트
테스트 1 〉	통과 (5.47ms, 10.1MB)
테스트 2 〉	통과 (3.63ms, 10.2MB)
테스트 3 〉	통과 (4.00ms, 10.1MB)
테스트 4 〉	통과 (4.02ms, 10.2MB)
테스트 5 〉	통과 (4.76ms, 10MB)
테스트 6 〉	통과 (4.66ms, 10.1MB)
채점 결과
정확성: 75.0
효율성: 25.0
합계: 100.0 / 100.0
'''