

### Problem D

[Link](https://www.facebook.com/codingcompetitions/hacker-cup/2022/qualification-round/problems/D)

Usually, we represent such an undirect graph of `N` nodes and `M` edges by a adjacency list or matrix `graph`, in which `graph[u][v]` represents the capacity of a **direct** flight between airport `u` and `v`. If there is no direct flight between `u` and `v`, we set `graph[u][v]` as 0 (including the case `u = v`).

For a query from `u` to `v`, we can easily figure out the formula to calculate the query result by

$$query(u,v) = 2 graph(u,v) + \sum_{k=0}^{N-1}{\min(graph(u,k), graph(k,v))}$$

Two direct flights on morning and evening, as long as all 2-step flight bypass any intermediate airport `k`, bottlenecked by the smaller flight between `u -> k` and `k -> v`.

The formula is not complex at all. However, the time complexity for each query `(u,v)` is $O(N)$ in the worst case. So the overall time complexity could be $O(NQ)$.

> What if we pre-process those *worst cases*?

I mean we don't need to enumerate all potential intermediate airport `k`,

- For the airports that has a few flights, we can enumerate the intersection sets of "adjacent" airports for the the two queried airports.
- If the query involving a airport that has too many direct flights, we'd better pre-calculte all query results between itself and all airports that can be reached out by 2 steps. 
