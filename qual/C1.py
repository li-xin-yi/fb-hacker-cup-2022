T = int(input())


def solve(n, first):
    start = '.' if first[0] == '-' else '-'
    res = [start*i + first[0] for i in range(1, n)]
    return '\n'.join(res)


for t in range(T):
    n = int(input())
    first = input()
    print(f'Case #{t+1}:\n{solve(n, first)}')
