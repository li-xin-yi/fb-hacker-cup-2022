T = int(input())

def sub(A, B):
    return [a-b for a,b in zip(A,B)]

def printlist(A):
    for  i in range(26):
        if A[i] != 0:
            print(chr(i+97), A[i])

def check(lst):
    for c in lst:
        if c < 0:
            return False
    return True

def solve(s,q,query):
    
    cur = [0]*26
    prefix = [list(cur)]
    res = 0
    for c in s:
        cur[ord(c)-ord('a')] += 1
        prefix.append(list(cur))
    for l,r in query:
        l, r = l-1, r-1
        mid = (l+r)//2
        if (l-r)%2 == 1:
            continue
        if check(sub(sub(prefix[mid+1],prefix[l]),sub(prefix[r+1],prefix[mid+1]))) or check(sub(sub(prefix[r+1],prefix[mid]),sub(prefix[mid],prefix[l]))):
            res += 1

    return res

for t in range(T):
    s = input()
    q = int(input())
    query = [tuple(map(int, input().split())) for _ in range(q)]
    print(f"Case #{t+1}: {solve(s, q, query)}")