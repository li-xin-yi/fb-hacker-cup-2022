T = int(input())

def solve(n, m, grid):
    if n == 1 or m == 1:
        for i in range(n):
            for j in range(m):
                if grid[i][j] == '^':
                    return "Impossible"
        return "Possible" + '\n' + '\n'.join(grid)
        
    q = [(i, j) for i in range(n) for j in range(m) if grid[i][j] == '#']
    seen = set(q)
    nei = [[4]*m for _ in range(n)]
    for i in range(n):
        nei[i][0] -= 1
        nei[i][-1] -= 1
    for j in range(m):
        nei[0][j] -= 1
        nei[-1][j] -= 1

    for i, j in q:
        for x, y in [(i-1, j), (i+1, j), (i, j-1), (i, j+1)]:
            if 0 <= x < n and 0 <= y < m:
                nei[x][y] -= 1
                if nei[x][y] < 2 and (x, y) not in seen:
                    if grid[x][y] == '^':
                        return "Impossible"
                    seen.add((x, y))
                    q.append((x, y))
    grid = [list(row) for row in grid]
    for i in range(n):
        for j in range(m):
            if (i, j) not in seen:
                grid[i][j] = '^'
    grid = [''.join(row) for row in grid]
    return "Possible" + '\n' + '\n'.join(grid)


for t in range(T):
    n, m = map(int, input().split())
    grid = [input() for _ in range(n)]
    res = solve(n, m, grid)
    print(f"Case #{t+1}: {res}")
