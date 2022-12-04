def solution(s):
    answer = ''
    
    for i in s.split(' '):
        lowerstring = list(i.lower())
        lowerstring[0] = lowerstring[0].upper()
        
        answer += ''.join(lowerstring) + ' '
    
    return answer.strip()