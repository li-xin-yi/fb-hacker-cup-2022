import heapq
from functools import lru_cache

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
    return [points[0]] + sorted(lower[1:-1] + upper[1:-1]) + [points[-1]]

def dist(a,b):
    return (a[0]-b[0])**2 + (a[1]-b[1])**2

def solve(N,K,D,points):
    hull = convex_hull(points)
    n = len(hull)

    dp = {0:0}
    seen = set()

    while dp:
        idx = min(dp.keys(), key=dp.__getitem__)
        seen.add(idx)
        if idx == n-1:
            return dp[idx]
        for nei in range(idx+1,n):
            if hull[nei][0] - hull[idx][0] > D:
                break
            d = dist(hull[idx],hull[nei])
            delta = max(K,d)
            if d > D**2: continue
            if nei not in seen and (nei not in dp or dp[nei] > dp[idx] + delta):
                dp[nei] = dp[idx] + delta
        del dp[idx]
    return -1




T = int(input())
for t in range(1, T + 1):
    N, K, D = map(int,input().split())
    points = [tuple(map(int, input().split())) for _ in range(N)]
    # if t!=2: continue
    print(f"Case #{t}: {solve(N,K,D,points)}")