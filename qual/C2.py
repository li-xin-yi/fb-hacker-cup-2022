T = int(input())


def solve(n, first):
    start = '.' if first[0] == '-' else '-'
    res = []
    for state in range(n-1):
        cur = [start] + [first[0]]*9
        for i in range(9):
            mask = 1 << i
            if state & mask:
                cur[i+1] = start
        res.append(''.join(cur))
    return '\n'.join(res)


for t in range(T):
    n = int(input())
    first = input()
    print(f'Case #{t+1}:\n{solve(n, first)}')
