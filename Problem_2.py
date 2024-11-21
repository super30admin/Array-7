class WordDistance(object): 
    def __init__(self, wordsDict):
        if wordsDict == None or len(wordsDict) == 0:
            return 0
        self.map = {}
        for i in range(len(wordsDict)):
            if wordsDict[i] not in self.map.keys():
                self.map[wordsDict[i]] = []
            self.map[wordsDict[i]].append(i)   
            
    def shortest(self, word1, word2):
        li1 = self.map[word1]
        li2 = self.map[word2]
        p1, p2 = 0, 0
        minDistance = float('inf')
        while p1 < len(li1) and p2 < len(li2):
            index1 = li1[p1]
            index2 = li2[p2]
            minDistance = min(minDistance, abs(index1 - index2))
            if index1 < index2:
                p1 += 1
            else:
                p2 += 1
        return minDistance
        


# Your WordDistance object will be instantiated and called as such:
# obj = WordDistance(wordsDict)
# param_1 = obj.shortest(word1,word2)

# Time Complexity: O(n) + O(max(k, l)) where k and l are length of two lists, the max is taken because we iterate over longer list completely
# Space Complexity: O(n) for making dictionary