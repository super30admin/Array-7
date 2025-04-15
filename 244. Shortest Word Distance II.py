#time: number of occurence of word1+  word2
#space: O(n)

from collections import defaultdict
class WordDistance:

    def __init__(self, wordsDict: List[str]):
        self.wordmap= defaultdict(list)
        for i in range(len(wordsDict)):
            self.wordmap[wordsDict[i]].append(i)

    def shortest(self, word1: str, word2: str) -> int:
        w1_arr= self.wordmap[word1]
        w2_arr= self.wordmap[word2]
        i,j=0,0
        mnm=float('inf')
        while i < len(w1_arr) and j < len(w2_arr):
            mnm= min(mnm, abs(w1_arr[i]- w2_arr[j]))
            if w1_arr[i] < w2_arr[j]:
                i+=1
            else:
                j+=1
        return mnm



# Your WordDistance object will be instantiated and called as such:
# obj = WordDistance(wordsDict)
# param_1 = obj.shortest(word1,word2)
