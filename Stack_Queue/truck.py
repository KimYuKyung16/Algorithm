def solution(bridge_length, weight, truck_weights):
    time = 0
    going_truck = []
    truck_bridge_length = []
    
    while 1:
        time += 1
        if len(truck_weights) != 0:
            if (sum(going_truck) + truck_weights[0]) <= weight: 
                going_truck.append(truck_weights.pop(0)) 
                truck_bridge_length.append(0) 
            
        for i in range(len(truck_bridge_length)): 
            truck_bridge_length[i] += 1
                
        if truck_bridge_length[0] == bridge_length: 
            going_truck.pop(0)
            truck_bridge_length.pop(0)          
                                     
        if len(going_truck) == 0 and len(truck_weights) == 0:
            time += 1
            break;
        
    return time

'''
정확성  테스트
테스트 1 〉	통과 (1.40ms, 10.1MB)
테스트 2 〉	통과 (22.44ms, 10MB)
테스트 3 〉	통과 (0.05ms, 10MB)
테스트 4 〉	통과 (53.13ms, 10MB)
테스트 5 〉	통과 (409.33ms, 10MB)
테스트 6 〉	통과 (151.06ms, 10.1MB)
테스트 7 〉	통과 (1.33ms, 10.2MB)
테스트 8 〉	통과 (0.26ms, 10.1MB)
테스트 9 〉	통과 (6.03ms, 10MB)
테스트 10 〉	통과 (0.47ms, 10.1MB)
테스트 11 〉	통과 (0.02ms, 10MB)
테스트 12 〉	통과 (0.56ms, 10.1MB)
테스트 13 〉	통과 (1.92ms, 10.2MB)
테스트 14 〉	통과 (0.05ms, 10MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
'''
