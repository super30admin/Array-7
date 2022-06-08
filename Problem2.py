#Time Complexity: O(Nk)
#Space Complexity: O(N)
class WordDistance:
    def __init__(self, wordsDict: List[str]):
        self.dic = {}
        for i in range(len(wordsDict)):
            if wordsDict[i] not in self.dic:
                self.dic[wordsDict[i]] = [i]
            else:
                self.dic[wordsDict[i]].append(i)

    def shortest(self, word1: str, word2: str) -> int:
            li1 = self.dic[word1]
            li2 = self.dic[word2]
            minn = float('inf')
            p1 = 0
            p2 = 0
            while p1 < len(li1) and p2 < len(li2):
                idx1 = li1[p1]
                idx2 = li2[p2]
                minn = min(minn, abs(idx1-idx2))
                
                if minn == 1:
                    return minn
                if idx1 < idx2:
                    p1 +=1
                else:
                    p2 +=1
                    
            return minn

# Your WordDistance object will be instantiated and called as such:
# obj = WordDistance(wordsDict)
# param_1 = obj.shortest(word1,word2)