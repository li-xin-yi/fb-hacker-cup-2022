def cross(o, a, b):
    return (a[0] - o[0]) * (b[1] - o[1]) - (a[1] - o[1]) * (b[0] - o[0])


def convex_hull(points):
    points.sort()
    lower = []
    for p in points:
        while len(lower) >= 2 and cross(lower[-2], lower[-1], p) <= 0:
            lower.pop()
        lower.append(p)

    upper = []
    for p in reversed(points):
        while len(upper) >= 2 and cross(upper[-2], upper[-1], p) <= 0:
            upper.pop()
        upper.append(p)
    return [points[0]] + lower[1:-1] + upper[1:-1] + [points[-1]]


def dist(a, b):
    return (a[0]-b[0])**2 + (a[1]-b[1])**2


def solve(N, K, D, points):
    hull = convex_hull(points)
    n = len(hull)

    dp = {i: float('inf') for i in range(n)}
    dp[0] = 0

    while dp:
        idx = min(dp.keys(), key=dp.__getitem__)

        cur = dp[idx]
        if cur == float('inf'):
            return -1
        if idx == n-1:
            return dp[idx]
        del dp[idx]
        for i in dp:
            d = dist(hull[idx], hull[i])
            if d <= D**2:
                dp[i] = min(dp[i], cur + max(K, d))
    return -1


T = int(input())
for t in range(1, T + 1):
    N, K, D = map(int, input().split())
    points = [tuple(map(int, input().split())) for _ in range(N)]
    print(f"Case #{t}: {solve(N, K, D, points)}")
