def solution(people, limit):
    count = 0
    
    while len(people) != 0:
        stack = []
        for i in range(len(people)):
            if len(stack) == 0:
                stack.append(people[i])
                continue

            if len(stack) == 1:
                if (stack[0] + people[i]) <= limit:
                    stack.append(people[i])
                    max = stack[0] + stack[1]

            if len(stack) == 2:
                if (stack[0] + people[i]) <= limit and (stack[0] + people[i]) > max:
                    stack.pop()
                    stack.append(people[i])
                    max = stack[0] + stack[1]
                    
        if len(stack) == 2:
            people.remove(stack[0])
            people.remove(stack[1])
            count += 1
        else:
            people.remove(stack[0])
            count += 1
    
    return count