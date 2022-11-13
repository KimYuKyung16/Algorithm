def solution(genres, plays):
    answer = []
    genres_set = set(genres)
    genres_list = dict()
    temp_list = []
    genres_sum_list = dict()
    
    for i in genres_set:
        for j in range(len(genres)):
            if genres[j] == i:
                temp_list.append([plays[j],j])  
        temp_list = sorted(temp_list, key=lambda x: (x[0], -x[1]), reverse=True)
        genres_list[i] = temp_list
        temp_list = []
        
    for i in genres_set:  
        genres_sum_list[i] = 0
        for j in range(len(genres)):
            if genres[j] == i:
                genres_sum_list[i] += plays[j]
                
    genres_sum_list = sorted(genres_sum_list.items(), key=lambda x:x[1], reverse=True)
    
    for i in range(len(genres_sum_list)):
        if len(genres_list[genres_sum_list[i][0]]) == 1:
            answer.append(genres_list[genres_sum_list[i][0]][0][1])
        else:
            for j in range(0, 2):
                answer.append(genres_list[genres_sum_list[i][0]][j][1])
    
    return answer

'''
정확성  테스트
테스트 1 〉	통과 (0.02ms, 10.4MB)
테스트 2 〉	통과 (0.02ms, 10.4MB)
테스트 3 〉	통과 (0.01ms, 10.3MB)
테스트 4 〉	통과 (0.01ms, 10.4MB)
테스트 5 〉	통과 (0.17ms, 10.3MB)
테스트 6 〉	통과 (0.14ms, 10.3MB)
테스트 7 〉	통과 (0.11ms, 10.3MB)
테스트 8 〉	통과 (0.05ms, 10.3MB)
테스트 9 〉	통과 (0.02ms, 10.4MB)
테스트 10 〉	통과 (0.22ms, 10.3MB)
테스트 11 〉	통과 (0.03ms, 10.3MB)
테스트 12 〉	통과 (0.06ms, 10.3MB)
테스트 13 〉	통과 (0.10ms, 10.4MB)
테스트 14 〉	통과 (0.11ms, 10.3MB)
테스트 15 〉	통과 (0.02ms, 10.3MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
'''
