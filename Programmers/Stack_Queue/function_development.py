def solution(progresses, speeds):
    answer = []   
    
    while progresses[0] < 100:
        result = 0
        
        if progresses[0] == 0:
            break
            
        for i in range(len(progresses)):
            if progresses[i] != 0:
                progresses[i] += speeds[i]   
            else:
                break

        while progresses[0] >= 100:       
            progresses.pop(0)
            speeds.pop(0)
            progresses.append(0)
            speeds.append(0)
            result += 1
        
        if result > 0:
            answer.append(result)        
                        
    return answer

'''
정확성  테스트
테스트 1 〉	통과 (0.02ms, 10.3MB)
테스트 2 〉	통과 (0.77ms, 10.2MB)
테스트 3 〉	통과 (0.71ms, 10.2MB)
테스트 4 〉	통과 (0.24ms, 10.2MB)
테스트 5 〉	통과 (0.02ms, 10.2MB)
테스트 6 〉	통과 (0.05ms, 10.2MB)
테스트 7 〉	통과 (0.96ms, 10.2MB)
테스트 8 〉	통과 (0.12ms, 10.3MB)
테스트 9 〉	통과 (0.74ms, 10.2MB)
테스트 10 〉	통과 (0.38ms, 10.2MB)
테스트 11 〉	통과 (0.02ms, 10.2MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
'''
