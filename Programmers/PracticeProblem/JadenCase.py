def solution(s): 
    answer = ''
    
    s = list(s)
    
    for i in range(len(s)):
        if i == 0:
            answer += s[i].upper()
            continue
            
        if s[i] == ' ':
            answer += ' '
        else:
            if s[i-1] == ' ':
                answer += s[i].upper()
            else:
                answer += s[i].lower()
    
    return answer