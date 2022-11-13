import heapq

def solution(scoville, K):
    count = 0
    heapq.heapify(scoville)
    
    while 1:
        if scoville[0] < K:
            heapq.heappush(scoville, heapq.heappop(scoville) + (heapq.heappop(scoville) * 2))
            count+=1
            if len(scoville) == 1 and scoville[0] < K:
                return -1
        else:
            break
    
    return count

'''
정확성  테스트
테스트 1 〉	통과 (0.00ms, 10.2MB)
테스트 2 〉	통과 (0.00ms, 10.2MB)
테스트 3 〉	통과 (0.01ms, 10.2MB)
테스트 4 〉	통과 (0.01ms, 10.2MB)
테스트 5 〉	통과 (0.00ms, 10.2MB)
테스트 6 〉	통과 (0.45ms, 10.2MB)
테스트 7 〉	통과 (0.35ms, 10.2MB)
테스트 8 〉	통과 (0.05ms, 10.2MB)
테스트 9 〉	통과 (0.04ms, 10.2MB)
테스트 10 〉	통과 (0.29ms, 10.3MB)
테스트 11 〉	통과 (0.19ms, 10.2MB)
테스트 12 〉	통과 (0.70ms, 10.2MB)
테스트 13 〉	통과 (0.37ms, 10.2MB)
테스트 14 〉	통과 (0.01ms, 10.2MB)
테스트 15 〉	통과 (0.49ms, 10.2MB)
테스트 16 〉	통과 (0.00ms, 10.2MB)
효율성  테스트
테스트 1 〉	통과 (163.28ms, 16.2MB)
테스트 2 〉	통과 (557.68ms, 21.9MB)
테스트 3 〉	통과 (1974.69ms, 49.8MB)
테스트 4 〉	통과 (128.76ms, 15MB)
테스트 5 〉	통과 (1985.12ms, 51.9MB)
채점 결과
정확성: 76.2
효율성: 23.8
합계: 100.0 / 100.0
'''