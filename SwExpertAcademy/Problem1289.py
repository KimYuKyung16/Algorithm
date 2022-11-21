T = int(input())

for test_case in range(1, T + 1):
    original_memory = list(map(int, input()))
    default_memory = [0] * len(original_memory)
    count = 0

    for i in range(len(original_memory)):
        if default_memory[i] == original_memory[i]:
            continue
        else:
            for j in range(i, len(default_memory)):
                default_memory[j] = original_memory[i]
            count += 1

    print("#{} {}".format(test_case, count))