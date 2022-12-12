def solution(s):
    s = list(s)
    
    remove_list = []
    count = 0

    while len(s) != 0:
        if len(remove_list) == 0:
            remove_list.append(s.pop(0))
            count += 1
        else:
            count += 1
            if remove_list[-1] == s[0]:
                remove_list.pop()
                s.pop(0)
            else:
                remove_list.append(s.pop(0))
        
    if len(remove_list) == 0: return 1
    else: return 0
