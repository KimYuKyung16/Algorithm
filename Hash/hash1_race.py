def solution(participant, completion):
    participant.sort()
    completion.sort()
    
    for i in range(len(completion)):
        if participant[i] != completion[i]:
            answer = participant[i]
            break      
    
    if answer == '':
        answer = participant[-1]
    
    return answer

'''
정확성  테스트
테스트 1 〉	통과 (0.00ms, 10.2MB)
테스트 2 〉	통과 (0.01ms, 10.2MB)
테스트 3 〉	통과 (0.29ms, 10.4MB)
테스트 4 〉	통과 (0.46ms, 10.4MB)
테스트 5 〉	통과 (0.41ms, 10.4MB)
효율성  테스트
테스트 1 〉	통과 (39.93ms, 18.1MB)
테스트 2 〉	통과 (54.68ms, 22.2MB)
테스트 3 〉	통과 (80.13ms, 24.7MB)
테스트 4 〉	통과 (82.11ms, 26.2MB)
테스트 5 〉	통과 (76.74ms, 26.3MB)
채점 결과
정확성: 50.0
효율성: 50.0
합계: 100.0 / 100.0
'''