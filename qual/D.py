from collections import defaultdict, Counter

T = int(input())

def solve(M, graph, queries):
    pre = defaultdict(Counter)
    for i in graph:
        if len(graph[i])**2 >= M:
            for j in graph[i]:
                for k in graph[j]:
                    if i != k:
                        pre[i][k] += min(graph[i][j], graph[j][k])
    res = []
    for i, j in queries:
        if len(graph[i]) < len(graph[j]):
            i, j = j, i
        flow = 2 * graph[i][j]
        if i in pre:
            flow += pre[i][j]
        else:
            for k in graph[i].keys() & graph[j].keys():
                flow += min(graph[i][k], graph[j][k])
        res.append(flow)
    return ' '.join(map(str, res))



for t in range(T):
    N, M, Q = map(int, input().split())
    graph = defaultdict(Counter)
    for _ in range(M):
        u, v, w = map(int, input().split())
        graph[u][v] = w
        graph[v][u] = w
    queries = [tuple(map(int, input().split())) for _ in range(Q)]
    print(f"Case #{t+1}: {solve(M, graph, queries)}")