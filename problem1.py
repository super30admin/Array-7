## Problem 1: Minimum word distance
# // Time Complexity : O(Nk)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


def shortest_distance(self, words: List[str], word1: str, word2: str) -> int:
    dist=len(words)
    w1=w2=-1
    for k, i in enumerate(words):
        if word1==i:                    #if the current word is word1, keep track of the index
            w1=k
        if word2==i:                    #if the curent word is word2, keep track of the index
            w2=k
        if(w1!=-1 and w2!=-1):          #if the two indices exist, then find the difference
            dist = min(dist, abs(w2-w1))
    return dist