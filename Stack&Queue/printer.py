def solution(priorities, location):
    answer = 0
    index_order = list(map(str, range(len(priorities))))
      
    for num in range(len(priorities)):
        while max(priorities[num:len(priorities)]) != priorities[num]:   
            if priorities[num] < max(priorities[num:len(priorities)]): 
                priorities.append(priorities.pop(num))
                index_order.append(index_order.pop(num))
                
    answer = (index_order.index(str(location)))+1
    
    return answer

'''
정확성  테스트
테스트 1 〉	통과 (0.13ms, 10.2MB)
테스트 2 〉	통과 (1.44ms, 10.2MB)
테스트 3 〉	통과 (0.87ms, 10.2MB)
테스트 4 〉	통과 (0.19ms, 10.3MB)
테스트 5 〉	통과 (0.01ms, 10.2MB)
테스트 6 〉	통과 (0.16ms, 10.3MB)
테스트 7 〉	통과 (0.27ms, 10.2MB)
테스트 8 〉	통과 (0.91ms, 10.2MB)
테스트 9 〉	통과 (0.03ms, 10.4MB)
테스트 10 〉	통과 (0.17ms, 10.2MB)
테스트 11 〉	통과 (0.68ms, 10.3MB)
테스트 12 〉	통과 (0.22ms, 10.3MB)
테스트 13 〉	통과 (0.66ms, 10.3MB)
테스트 14 〉	통과 (0.01ms, 10.2MB)
테스트 15 〉	통과 (0.10ms, 10.4MB)
테스트 16 〉	통과 (0.07ms, 10.3MB)
테스트 17 〉	통과 (1.32ms, 10.3MB)
테스트 18 〉	통과 (0.02ms, 10.2MB)
테스트 19 〉	통과 (0.96ms, 10.2MB)
테스트 20 〉	통과 (0.46ms, 10.2MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
'''