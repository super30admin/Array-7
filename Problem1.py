#Time complexity : O(n) since in the worst case, the len(index1 of word1) + len(index2 of word2) will be max n. Also here 
#we are not comparing words, we dont need l (avg length of each word)
#Space complexity: O(n)
#Works on leetcode : yes
#Approach : We save the indicies of each word from the list in dictonary. When calling the shortest function, we just get the 
#respective indicies of 2 words and calculate min word distance. We inccrement the index which has respective smaller value

class WordDistance:

    def __init__(self, words: List[str]):
        self.dic = collections.defaultdict(list)
        for i, word in enumerate(words):
            self.dic[word].append(i)

    def shortest(self, word1: str, word2: str) -> int:
        ind1, ind2 = self.dic[word1],self.dic[word2]
        p1,p2 = 0,0
        ans = float("inf")
        while p1<len(ind1) and p2<len(ind2):
            ans = min(ans, abs(ind1[p1]-ind2[p2]))
            if ind1[p1]<ind2[p2]:
                p1 +=1
            else:
                p2 +=1
        return ans
        


# Your WordDistance object will be instantiated and called as such:
# obj = WordDistance(words)
# param_1 = obj.shortest(word1,word2)