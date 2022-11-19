T = 10

for test_case in range(1, T + 1):
    dump_count = int(input())
    boxes = list(map(int, input().split()))

    for i in range(dump_count):
        boxes.sort(reverse=True)
        if (boxes[0] == boxes[-1]) or (boxes[0] - boxes[-1]) == 1:
            break
        else:
            boxes[0] = boxes[0]-1
            boxes[-1] = boxes[-1]+1

    boxes.sort(reverse=True)
    print("#{} {}".format(test_case, boxes[0] - boxes[-1]))