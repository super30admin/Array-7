#Time Complexity : O(N+L1+L2), i.e N for creating the listmap, L1 for iterating through wordlist1, L2 for iterating through wordlist2
#Space Complexity : O(U+T) where U is the number of unique words in wordsDict and T is the total number of indices stored in listmap.
class WordDistance:
    def __init__(self, wordsDict: List[str]):
        n = len(wordsDict)
        self.listmap = dict()
        for i, word in enumerate(wordsDict):
            if(word not in self.listmap):
                self.listmap[word] = list()
            self.listmap[word].append(i)      

    def shortest(self, word1: str, word2: str) -> int:
        wordlist1 = self.listmap.get(word1)
        wordlist2 = self.listmap.get(word2)
        n1 = len(wordlist1)
        n2 = len(wordlist2)
        minimum = float('inf')
        p1,p2 = 0,0
        while(p1<n1 and p2<n2):
            if(wordlist1[p1]<wordlist2[p2]):
                minimum = min(minimum, wordlist2[p2]-wordlist1[p1])
                p1+=1
            else:
                minimum = min(minimum, wordlist1[p1]-wordlist2[p2])
                p2+=1
        return minimum


# Your WordDistance object will be instantiated and called as such:
# obj = WordDistance(wordsDict)
# param_1 = obj.shortest(word1,word2)