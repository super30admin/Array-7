class WordDistance:

    def __init__(self, wordsDict: List[str]):
        #Time Complexity: O(n)
        #Space Complexity: O(n)
        #where, n is the number of words in wordsDict
        
        self.map = defaultdict(list)
        for i in range(len(wordsDict)):
            self.map[wordsDict[i]].append(i)

    def shortest(self, word1: str, word2: str) -> int:
        #Time Complexity: O(n)
        #Space Complexity: O(1)
        #where, n is the number of words in wordsDict
        
        idx1 = self.map[word1]
        idx2 = self.map[word2]
        
        p1 = p2 = 0
        minDist = inf
        while p1 < len(idx1) and p2 < len(idx2):
            minDist = min(minDist, abs(idx1[p1] - idx2[p2]))
            if idx1[p1] < idx2[p2]:
                p1 += 1
            else:
                p2 += 1
                
        return minDist


# Your WordDistance object will be instantiated and called as such:
# obj = WordDistance(wordsDict)
# param_1 = obj.shortest(word1,word2)