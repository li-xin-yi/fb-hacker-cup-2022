T = int(input())


def solve(N, K, nums, target):
    if K == 0:
        return "YES" if nums == target else "NO"
    if nums == target and K == 1:
        return "NO"
    if N == 2:
        return "YES" if nums[K % 2:] + nums[:K % 2] == target else "NO"
    pos = {}
    for i in range(N):
        pos[nums[i]] = i
    target = [pos[num] for num in target]
    for i in range(N-1):
        if target[i+1] != (target[i]+1) % N:
            return "NO"
    return "YES"


for t in range(1, T + 1):
    N, K = map(int, input().split())
    nums = list(map(int, input().split()))
    target = list(map(int, input().split()))
    print(f"Case #{t}: {solve(N, K, nums, target)}")
