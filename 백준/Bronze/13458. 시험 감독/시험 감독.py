n = int(input())
people = list(map(int, input().split()))
b, c = list(map(int, input().split()))
total = 0

for participant in people:
  count = 1
  participant -= b # 총감독

  if participant > 0:
    count += (participant // c)
    if participant % c > 0:
      count += 1

  total += count

print(total)