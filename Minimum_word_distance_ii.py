# Time Complexity : O()
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
# https://leetcode.com/problems/shortest-word-distance-ii/
class WordDistance:
    # Tc = O(n), where n are the number of words in the list | Sc = O(n)
    def __init__(self, words):
        self.d = {}
        for i in range(len(words)):
            if words[i] not in self.d:
                self.d[words[i]] = []
            self.d[words[i]].append(i)

    # Tc = O(m+n), where m,b is the length of occuerence of word1 and word2 | Sc = O(1)
    def shortest(self, word1, word2):
        l1, l2 = self.d[word1], self.d[word2]
        
        i,j = 0 ,0 
        res = float('inf')
        while i < len(l1) and j < len(l2):
            res = min(res, abs(l1[i] - l2[j]))
            if l1[i]  < l2[j]:
                i += 1 
            else:
                j += 1 
        
        return res


# Your WordDistance object will be instantiated and called as such:
# obj = WordDistance(words)
# param_1 = obj.shortest(word1,word2)