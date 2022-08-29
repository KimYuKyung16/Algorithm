def solution(brown, yellow):  
  #width가 가로, height이 세로
  for height in range(1,yellow+1): #세로 길이 구하는 과정
    width = yellow/height #원래식 -> yellow = width * height : yellow의 가로 세로 구하기
    if width>=height and ((width*2)+(height*2)+4)==brown: #갈색 격자 수 = 가로와 세로에 2를 곱한 값에 4(모서리)를 더한 값
      return [width+2, height+2] #2는 모서리값