from collections import defaultdict
import heapq
T = int(input())
M = 10**9 + 7
def solve(N, K, clients):
    buy = defaultdict(list)
    sell = defaultdict(list)
    adj = defaultdict(list)
    h = []

    def add(x):
        heapq.heappush(h,x)
        if len(h) > K:
            heapq.heappop(h)

    for i in range(N):
        a, b, x, y = clients[i]
        buy[a].append((x, i))
        sell[b].append((y, i))

    for i in sorted(buy.keys()):
        # print(adj)
        for x,u in sell[i]:
            for y,v in buy[i]:
                if y - x > 0:
                    if len(h) >= K:
                        adj[u] = [max(adj[u])] if adj[u] else []
                        base = adj[u][0] if adj[u] else 0
                        add(base + y - x)
                        adj[v].append(base + y - x)
                    else:
                        for base in adj[u] + [0]:
                            add(base + y - x)
                            adj[v].append(base + y - x)
    return sum(h)



for t in range(T):
    N, K = map(int, input().split())
    clients = list(tuple(map(int, input().split())) for _ in range(N))
    print(f"Case #{t+1}: {solve(N, K, clients)}")