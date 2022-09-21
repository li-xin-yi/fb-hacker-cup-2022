
### A1 & A2

I prefer saying "*rotating*" the array than "*cutting*" the deck. No matter you perform how many times of cutting (or rotating), it can be merged as one single rotating operation (except for some special cases). For example:

```
[1, 2, 3, 4, 5] -> rotate at index 3 -> [4, 5, 1, 2, 3]
[4, 5, 1, 2, 3] -> rotate at index 3 -> [2, 3, 4, 5, 1]

[1, 2, 3, 4, 5] -> rotate at index 1 -> [2, 3, 4, 5, 1]
```

So we only need to check if `B` is a rotated `A` regardless the given `K`.

Special cases:

- `K = 0`: You can't perform any rotation, check if `A == B`
- `K = 1`: You must perform a rotation once, you might not achieve a status by cancelling two or more rotations.
- `N = 2`: The array can have only 2 status, one rotation must make a transition between them.

#### A1

[link](https://www.facebook.com/codingcompetitions/hacker-cup/2022/round-1/problems/A1) | [Python Solution](A1.py) 

Since all elements in the array are distinct in A1, we can easily locate the corresponding index in `A` for each element in `B`. So we just check if the location difference of the same element `x` between `A` and `B`, the offset, `(B.index(x) - A.index(x)) % N` is a constant for all elements.

The process can be referenced in [LC1752. Check if Array Is Sorted and Rotated](https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/) after remarking `A` as `[1..N]` and replacing corresponding elements in `B`.

Be cautious on special cases, when `k = 1`, make sure `A` and `B` are different.