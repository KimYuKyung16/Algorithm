def solution(priorities, location):
    answer = 0
    index_order = list(map(str, range(len(priorities))))
      
    for num in range(len(priorities)):
        while max(priorities[num:len(priorities)]) != priorities[num]:   
            for i in range(len(priorities)):
                if priorities[num] < max(priorities[num:len(priorities)]): 
                    priorities.append(priorities.pop(num))
                    index_order.append(index_order.pop(num))
                
    answer = (index_order.index(str(location)))+1
    
    return answer

'''
정확성  테스트
테스트 1 〉	통과 (0.12ms, 10.3MB)
테스트 2 〉	통과 (17.30ms, 10.4MB)
테스트 3 〉	통과 (8.71ms, 10.2MB)
테스트 4 〉	통과 (0.92ms, 10.3MB)
테스트 5 〉	통과 (0.01ms, 10.2MB)
테스트 6 〉	통과 (0.40ms, 10.4MB)
테스트 7 〉	통과 (1.60ms, 10.3MB)
테스트 8 〉	통과 (8.36ms, 10.2MB)
테스트 9 〉	통과 (0.08ms, 10.4MB)
테스트 10 〉	통과 (0.55ms, 10.2MB)
테스트 11 〉	통과 (3.39ms, 10.4MB)
테스트 12 〉	통과 (0.90ms, 10.3MB)
테스트 13 〉	통과 (3.71ms, 10.2MB)
테스트 14 〉	통과 (0.01ms, 10.3MB)
테스트 15 〉	통과 (0.49ms, 10.4MB)
테스트 16 〉	통과 (0.23ms, 10.2MB)
테스트 17 〉	통과 (8.67ms, 10.3MB)
테스트 18 〉	통과 (0.05ms, 10.3MB)
테스트 19 〉	통과 (8.45ms, 10.3MB)
테스트 20 〉	통과 (3.55ms, 10.2MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
'''