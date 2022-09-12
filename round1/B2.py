M = 10**9 + 7
T = int(input())

def solve(N, trees, Q, queries):
    x_square_sum = y_square_sum = 0
    x_sum = y_sum = 0
    for x, y in trees:
        x, y = x % M, y % M
        x_sum = (x_sum + x) % M
        y_sum = (y_sum + y) % M
        x_square_sum = (x_square_sum + x**2) % M
        y_square_sum = (y_square_sum + y**2) % M
    res = 0
    for x, y in queries:
        res = (res + x_square_sum - 2*x*x_sum + N*x**2) % M
        res = (res + y_square_sum - 2*y*y_sum + N*y**2) % M
    return res
        

for t in range(1, T + 1):
    N = int(input())
    trees = [tuple(map(int, input().split())) for _ in range(N)]
    Q = int(input())
    queries = [tuple(map(int, input().split())) for _ in range(Q)]
    print(f"Case #{t}: {solve(N, trees, Q, queries)}")