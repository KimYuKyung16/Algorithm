def solution(s):
    max_num = max(map(int, s.split(' ')))
    min_num = min(map(int, s.split(' ')))
    
    return "{} {}".format(min_num, max_num)