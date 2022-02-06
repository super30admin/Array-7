# 244. Shortest Word Distance II
# https://leetcode.com/problems/shortest-word-distance-ii/

# Logic: At the start we make a hashmap with all the words 
# as key and a list of idx as values. When query is called 
# we extract list for the two words. We have 2 pointers at 
# the start of the lists. We take difference and update the 
# distance and move the pointer on the smaller idx.

# Time Complexity: O(n)
# Space Complexity: O(n)

class WordDistance:
    def __init__(self, wordsDict: List[str]):
        self.hashmap = dict()
        
        for idx, i in enumerate(wordsDict):
            if i not in self.hashmap:
                self.hashmap[i] = list()
            self.hashmap[i].append(idx)

    def shortest(self, word1: str, word2: str) -> int:
        w1 = self.hashmap[word1]
        w2 = self.hashmap[word2]
        
        p1 = 0
        p2 = 0
        
        minDist = inf
        
        while p1 < len(w1) and p2 < len(w2):
            minDist = min(minDist, abs(w1[p1] - w2[p2]))
            
            if w1[p1] < w2[p2]:
                p1 += 1
            else:
                p2 += 1
        return minDist


# Your WordDistance object will be instantiated and called as such:
# obj = WordDistance(wordsDict)
# param_1 = obj.shortest(word1,word2)