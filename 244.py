class WordDistance(object):

    def __init__(self, wordsDict):
        """
        :type wordsDict: List[str]
        """
        self.map1 = {}
        if len(wordsDict) == 0:
            return 

        for i in range(len(wordsDict)):
            word = wordsDict[i] 
            if word not in self.map1:
                self.map1[word] = []
            self.map1[word].append(i)

    def shortest(self, word1, word2):
        """
        :type word1: str
        :type word2: str
        :rtype: int
        """
        nums1 = self.map1[word1]
        nums2 = self.map1[word2]
        m = len(nums1)
        n = len(nums2)
        p1, p2 = 0,0
        min1 = float('inf')
        while p1< m and p2 < n :
            val1 = nums1[p1]
            val2 = nums2[p2]
            min1 = min(min1, abs(val1 - val2))
            if val1 < val2:
                p1 += 1
            else:
                p2 += 1

        return min1

    # TC, SC : O(n)
            

        


# Your WordDistance object will be instantiated and called as such:
# obj = WordDistance(wordsDict)
# param_1 = obj.shortest(word1,word2)