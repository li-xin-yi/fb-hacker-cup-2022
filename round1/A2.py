T = int(input())

def kmp(pattern, text):
    n = len(pattern)
    m = len(text)
    next_v = [0] * n
    for i in range(1, n):
        j = next_v[i - 1]
        while j > 0 and pattern[i] != pattern[j]:
            j = next_v[j - 1]
        if pattern[i] == pattern[j]:
            j += 1
        next_v[i] = j
    j = 0
    for i in range(m):
        while j > 0 and text[i] != pattern[j]:
            j = next_v[j - 1]
        if text[i] == pattern[j]:
            j += 1
        if j == n:
            return i - n + 1
    return -1

def solve(N, K, nums, target):
    if K == 0:
        return "YES" if nums == target else "NO"
    if nums == target and K == 1:
        nums = nums[1:] + nums[:1]
        idx = kmp(target, nums + nums)
        return "YES" if idx != N-1 else "NO"
    if N == 2:
        return "YES" if nums[K % 2:] + nums[:K % 2] == target else "NO"
    if kmp(target, nums + nums) == -1:
        return "NO"
    return "YES"
    

for t in range(1, T + 1):
    N, K = map(int, input().split())
    nums = list(map(int, input().split()))
    target = list(map(int, input().split()))
    print(f"Case #{t}: {solve(N, K, nums, target)}")