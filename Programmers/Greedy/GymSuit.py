def solution(n, lost, reserve):
    answer = 0
    answer = n - len(lost)
    
    for i in range(len(lost)):
        if lost[i] in reserve:
            lost[i] = -2
            index = reserve.index(lost[i])
            reserve.remove(reserve[index])
            answer += 1
            
    lost.sort()
    reserve.sort()
    
    for i in range(len(lost)):
        for j in range(len(reserve)):
            if reserve[j] + 1 == lost[i] or reserve[j] - 1 == lost[i]:
                reserve[j] = -1
                answer += 1
                break
    
    return answer