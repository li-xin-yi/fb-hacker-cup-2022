from math import gcd
T = int(input())

def solve(N, K, batches):
    less = sum([b for b,c in batches if c <= batches[0][1]])
    more = sum([b for b,c in batches if c > batches[0][1]] + [0])
    n = less + more
    if less < K:
        return 0
    b = batches[0][0]
    # reduce b/n * K * less / n
    x, y = b*K*(less-1), n*(n-1)
    d = gcd(x, y)
    return x//d, y//d

for t in range(T):
    N, K = map(int, input().split())
    batches = list(tuple(map(int, input().split())) for _ in range(N))
    print(f"Case #{t+1}: {' '.join(map(str, solve(N, K, batches)))}")