### Problem A

Make sure each value has <= 2 occurrences and the total size of the input `<= 2*k`.

### Problem B1 & B2

The most intuitive way to think that: 

> what if we fill **all** available cells in the grid with trees?

Hmmm, unless there is no tree in the beginning, If a "fulfill" method doesn't work, no other strategies work.

For B1, no rocks, we just need to consider the shape of the grid itself. if it has only one row or only one column, a corner cell will never have two tree friends.

For B2, based on the scenario we discussed in B1, a rock can't be drawn with a tree, so the neighbors of rocks can't have a tree friend at that cell. Assume that a cell can have at most `n` tree friends now (number of cells nearby), we decrease the count by 1 if we find one of its neighbor is impossible to be a tree. If `n` is already less than 2, we know the cell is also impossible to be a tree now, and then we have to check its neighbor to find more impossible cells. The process can be done by a BFS, starting from the source set of rocks, then enumerate all "impossible" cells. If we find an "impossible" cell has a tree at the beginning, we can return `"Impossible"` right now. Otherwise, just fill out all "possible" cells with the tree as a solution.


### Problem C1 & C2

See [Uniquely decodable codes](https://en.wikipedia.org/wiki/Variable-length_code?fbclid=IwAR01mMCdDjPkY_rBFTAZhgdcP0WcwiZxW_bvS6wRzeTYJ2w7TBI_FnOWH-g#Uniquely_decodable_codes), one easy way is to ensure that a codeword `c1` could never be a prefix of another codeword `c2`.

#### 'A'\*n + 'B' pattern

Here `B` refers to the initial letter in `c1`, and `A` is the rest letter. 

`c1` won't be a prefix of any codeword.

a codeward of length `n` is `'A*(n-1) + B`, prefix of all other longer codeword is `A*n`.

#### Fix the initial letter, and fill out the rest nine letters.

We fix the initial letter of those `N-1` codewords like before, to get the rest 9-length substring, we have $2^9 > N$ choices for C2.


### Problem D

[Link](https://www.facebook.com/codingcompetitions/hacker-cup/2022/qualification-round/problems/D)

Usually, we represent such an undirect graph of `N` nodes and `M` edges by an adjacency list or matrix `graph`, in which `graph[u][v]` represents the capacity of a **direct** flight between airport `u` and `v`. If there is no direct flight between `u` and `v`, we set `graph[u][v]` as 0 (including the case `u = v`).

For a query from `u` to `v`, we can easily figure out the formula to calculate the query result by

$$query(u,v) = 2 graph(u,v) + \sum_{k=0}^{N-1}{\min(graph(u,k), graph(k,v))}$$

Two direct flights in the morning and evening, as long as all 2-step flight bypass any intermediate airport `k`, bottlenecked by the smaller flight between `u -> k` and `k -> v`.

The formula is not complex at all. However, the time complexity for each query `(u,v)` is $O(N)$ in the worst case. So the overall time complexity could be $O(NQ)$.

> What if we pre-process those *worst cases* off-line?

I mean we don't need to enumerate all potential intermediate airports `k`,

- For the airports that have a few flights, we can enumerate the intersection sets of "adjacent" airports for the two queried airports.
- If the query involving with an airport that has too many direct flights, we'd better pre-calculate all query results between itself and all airports that can be reached in exact 2 steps.

> How to determine the threshold of degrees to say which one has a few flights while which has many flights?

Try $\sqrt{M}$. 

For each airport with $> \sqrt{M}$ edges, we traverse at most $M$ edges to calculate the capacity between it and all its 2-step away neighbors. Notice that no more than $\sqrt{M}$ airports have the degree $> \sqrt{M}$, otherwise, there will be more than $M$ edges in the graph (Recall that no duplicate edges between two nodes). Thus, the pre-calculate stage costs $O{M^{1.5}}$ time, and for every online query involving such a node, we return the result in $O(1)$.

For a query of two airports with $\le \sqrt{M}$ edges, we only need to enumerate at most $2\sqrt{M}$ edges to find all 2-step paths between them, so the time complexity is $O(\sqrt{M})$.

The overall time complexity is $O(M^{1.5} + Q\sqrt{M})$.



