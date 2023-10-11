from collections import deque

def getBoard():
  for i in range(n):
    board.append(list(input()))

def getCoord():
  ry, rx, by, bx = 0, 0, 0, 0
  for y in range(n):
    for x in range(m):
      if board[y][x] == 'R':
        ry, rx = y, x
      elif board[y][x] == 'B':
        by, bx = y, x
      elif board[y][x] == 'O':
        global oy, ox
        oy, ox = y, x
  queue.append((ry, rx, by, bx, 1))

def move(cy, cx, dy, dx):
  count = 0
  while board[cy + dy][cx + dx] != '#' and board[cy][cx] != 'O':
    cy += dy
    cx += dx
    count += 1
  return cy, cx, count

def bfs(oy, ox):
  while len(queue) != 0:
    ry, rx, by, bx, count = queue.popleft()
    if count > 10:
      print(-1)
      return
    for i in range(4):
      dy, dx = direction[i]
      nry, nrx, rcount = move(ry, rx, dy, dx)
      nby, nbx, bcount = move(by, bx, dy, dx)
      if nby == oy and nbx == ox: # 파란공이 구멍에 들어가서 실패했을 경우
        continue
      else: 
        if nry == oy and nrx == ox:
          print(count)
          return
        if nry == nby and nbx == nrx:
          if rcount > bcount:
            nry -= dy
            nrx -= dx
          else:
            nby -= dy
            nbx -= dx
        queue.append((nry, nrx, nby, nbx, count+1))
  print(-1)

direction = [(-1, 0), (0, 1), (1, 0), (0,-1)] # 위, 오, 아래, 왼
board = []
n, m = map(int, input().split())
queue = deque()

oy, ox = 0, 0

getBoard()
getCoord()
bfs(oy, ox)
