#TC: O(n)
#SC: O(n) k1 = len(index1) , k2 = len(index2) Average SC: O(max(K1,K2)) Worst case SC: O(n)
class WordDistance:

    def __init__(self, wordsDict: List[str]):
        self.wordsDict = wordsDict
        self.indexMap = {}
        for i,w in enumerate(wordsDict):
            if w in self.indexMap:
                self.indexMap[w].append(i)
            else:
                self.indexMap[w] = [i]

    def shortest(self, word1: str, word2: str) -> int:

        index1 = self.indexMap[word1]
        index2 = self.indexMap[word2]
        w1 = 0
        w2 = 0
        distance = float('inf')
        while(w1<len(index1) and w2<len(index2)):
            distance = min(distance, abs(index1[w1]-index2[w2]))
            if index1[w1] < index2[w2]:
                w1 +=1
            else:
                w2 +=1
        return distance

# Your WordDistance object will be instantiated and called as such:
# obj = WordDistance(wordsDict)
# param_1 = obj.shortest(word1,word2)