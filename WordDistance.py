# TimeCompelxity:O(n*k) where k is avg length
# SpaceCompelxity:O(n)
# Approach:
# Similar to word distance 1 but as there are multiple quries it migh be n square if we use 2 pointer approach so ,maintain a haspmap or dict having indexes and find min distance among those 

class WordDistance:

    def __init__(self, wordsDict: List[str]):
        self.hmap=defaultdict(list)
        for  i in range(len(wordsDict)):
            self.hmap[wordsDict[i]].append(i)
        

    def shortest(self, word1: str, word2: str) -> int:
        idxs1,idxs2=self.hmap[word1],self.hmap[word2]
        l1,l2=0,0
        ans=float('inf')
        while(l1<len(idxs1) and l2<len(idxs2)):
            #k=abs(l1-l2)
            ans=min(ans,abs(idxs1[l1]-idxs2[l2]))
            if idxs1[l1]>idxs2[l2]:
                l2+=1
            else:
                l1+=1
        return ans

        


# Your WordDistance object will be instantiated and called as such:
# obj = WordDistance(wordsDict)
# param_1 = obj.shortest(word1,word2)
