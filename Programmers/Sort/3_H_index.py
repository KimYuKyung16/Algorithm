def solution(citations):
    h_index = 0
    citations.sort() 
    
    if citations[-1] == 0: #모든 값이 0일 때
        h_index = 0
    else:
        for i in range(len(citations)): #확인용 숫자값
            for j in range(len(citations)): #인덱스
                if citations[j]>=i: 
                    break                   
            if len(citations[j:]) >= i: #i값보다 큰 값이 i개 이상일 때
                h_index = i
                
        if len(citations) <= citations[0]: #전체 길이가 리스트 첫번째 값보다 작거나 같을 때
            h_index = len(citations);
            
    return h_index