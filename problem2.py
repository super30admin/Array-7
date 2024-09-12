# Problem 2: Minimum word distance ii

# // Time Complexity : O(N+M)
# // Space Complexity :O(N+M)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no

def shortest_distance(self, words: List[str], word1: str, word2: str) -> int:
    hmap={}
    for k, i in enumerate(words):                       #add all the indices of word1 and word2 to their hashmaps
        if i in hmap:
            hmap[i].append(k)
        else:
            hmap[i]=[k]



    dist=len(words)
    i=j=0
    w1 = hmap[word1]
    w2 = hmap[word2]

    while i< len(w1) and j<len(w2):                 #iterate through the indices and find the minimum distance
        dist = min(dist, abs(w2[j]-w1[i]))
        if w1[i]<w2[j]:
            i+=1
        else:
            j+=1
    return dist