def solution(number, k):
    count = 0
    number_list = []
    i = 1
    
    number_list.append(number[0])
    
    while True:
        if (len(number_list) == len(number) - k)  and count == k:
            break
            
        if i == (len(number)-1) and number_list[-1] > number[i] and count == k-1:
            break
            
        if number_list[-1] < number[i]:
            while len(number_list) != 0 and number_list[-1] < number[i] and count != k :
                number_list.pop()
                count += 1
                
        number_list.append(number[i])
        i += 1
        
    answer = ''.join(number_list)
    return answer