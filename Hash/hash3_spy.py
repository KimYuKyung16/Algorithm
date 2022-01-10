def solution(clothes):
    answer = 0

    clothes = dict(clothes)
    kind_list = list(clothes.values())
    kind_set = set(kind_list)
    
    result = 1
    
    for i in kind_set:
        result *= kind_list.count(i)
    
    if len(kind_set) == 1:
        answer = len(clothes)
        
    elif len(kind_set) == len(clothes):
        for i in range(1,len(kind_set)):
            answer*=i
            
    else:
        answer = len(clothes) + result 
           
    return answer

'''
정확성  테스트
테스트 1 〉	실패 (0.04ms, 10.3MB)
테스트 2 〉	통과 (0.01ms, 10.3MB)
테스트 3 〉	실패 (0.01ms, 10.3MB)
테스트 4 〉	실패 (0.02ms, 10.2MB)
테스트 5 〉	실패 (0.01ms, 10.4MB)
테스트 6 〉	실패 (0.01ms, 10.2MB)
테스트 7 〉	실패 (0.02ms, 10.2MB)
테스트 8 〉	실패 (0.02ms, 10.3MB)
테스트 9 〉	실패 (0.01ms, 10.2MB)
테스트 10 〉	실패 (0.01ms, 10.3MB)
테스트 11 〉	실패 (0.01ms, 10.2MB)
테스트 12 〉	실패 (0.02ms, 10.2MB)
테스트 13 〉	실패 (0.02ms, 10.2MB)
테스트 14 〉	실패 (0.01ms, 10.3MB)
테스트 15 〉	통과 (0.01ms, 10.2MB)
테스트 16 〉	통과 (0.01ms, 10.3MB)
테스트 17 〉	통과 (0.02ms, 10.2MB)
테스트 18 〉	실패 (0.01ms, 10.3MB)
테스트 19 〉	실패 (0.01ms, 10.2MB)
테스트 20 〉	통과 (0.01ms, 10.2MB)
테스트 21 〉	통과 (0.01ms, 10.2MB)
테스트 22 〉	통과 (0.01ms, 10.2MB)
테스트 23 〉	실패 (0.01ms, 10.2MB)
테스트 24 〉	실패 (0.01ms, 10.3MB)
테스트 25 〉	실패 (0.01ms, 10.2MB)
테스트 26 〉	실패 (0.02ms, 10.2MB)
테스트 27 〉	통과 (0.01ms, 10.3MB)
테스트 28 〉	실패 (0.02ms, 10.3MB)
채점 결과
정확성: 28.6
합계: 28.6 / 100.0
'''