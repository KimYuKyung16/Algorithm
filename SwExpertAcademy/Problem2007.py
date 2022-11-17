T = int(input())

for test_case in range(1, T + 1):
    input_string = input()

    split_list = input_string.split(input_string[0])
    split_set = set(split_list)

    word_count = {}
    while len(split_set) != 1:
        joined_word = input_string[0].join(split_set)
        word_count[joined_word] = input_string.count(joined_word)

        split_set.pop()

    word_count = sorted(word_count.items(), key=lambda x:x[0], reverse=True)
    word_count.sort(key=lambda x:x[1], reverse=True)

    print('#{} {}'.format(test_case, len(word_count[0][0])))







