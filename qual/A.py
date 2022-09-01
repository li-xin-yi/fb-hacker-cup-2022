from collections import Counter


def solve(lst, k):
    cnt = Counter(lst)
    if max(cnt.values()) > 2:
        return "NO"
    if sum(cnt.values()) > 2 * k:
        return "NO"
    return "YES"


T = int(input())
for t in range(T):
    n, k = map(int, input().split())
    lst = list(map(int, input().split()))
    print(f"Case #{t+1}: {solve(lst, k)}")
