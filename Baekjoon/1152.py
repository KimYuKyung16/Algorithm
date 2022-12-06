s = input().strip()

if s == '': # 문자열이 공백만 있을 경우를 생각
  print(0)
else:
  print(len(s.split(' '))) 