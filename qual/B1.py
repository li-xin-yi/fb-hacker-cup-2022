T = int(input())

def solve(n, m, grid):
    if n > 1 and m > 1:
        return "Possible" + '\n' + '\n'.join(['^'*m]*n)
    for i in range(n):
        for j in range(m):
            if grid[i][j] == '^':
                return "Impossible"
    return "Possible" + '\n' + '\n'.join(grid)


for t in range(T):
    n, m = map(int, input().split())
    grid = [input() for _ in range(n)]
    res = solve(n, m, grid)
    print(f"Case #{t+1}: {res}")
