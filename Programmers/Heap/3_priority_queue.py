import heapq

def solution(operations):
    answer = []
    heap_num = []
    
    for i in range(len(operations)):
        if operations[i].count('I')==1:
            heapq.heappush(heap_num,int(operations[i][2:]))
        else:
            if operations[i].count('-1') == 1: #최솟값 삭제
                if len(heap_num) == 0:
                    print(heap_num)
                    continue
                heapq.heappop(heap_num)
            else: #최댓값 삭제
                if len(heap_num) == 0:
                    continue
                heap_num.pop(heap_num.index(max(heap_num)))
    
    if len(heap_num) == 0:
        answer = [0,0]
    else:
        answer = [max(heap_num),heap_num[0]]
        
    return answer

'''
정확성  테스트
테스트 1 〉	통과 (0.03ms, 10.4MB)
테스트 2 〉	통과 (0.04ms, 10.4MB)
테스트 3 〉	통과 (0.04ms, 10.5MB)
테스트 4 〉	통과 (0.01ms, 10.2MB)
테스트 5 〉	통과 (0.03ms, 10.5MB)
테스트 6 〉	통과 (0.03ms, 10.4MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
'''