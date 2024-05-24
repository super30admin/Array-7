'''
Time Complexity - O(n)
Space Complexity - O(1)

Works on Leetcode
'''
class Solution:
    def shortestWordDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:


        #optimal
        i1, i2 = -1, -1
        #i1 to store occurrence of word1 and i2 to store occurrence of word2
        temp = -1
        minDist = 3*1e5
        for i in range(len(wordsDict)):
            #we use a temp in case both words are the same.
            #we use i1 and i2 when both words are different.
            if wordsDict[i] == word1:
                #update temp1 to previous value of i1
                temp = i1
                i1 = i
            if wordsDict[i] == word2:
                i2 = i
            if i1!= -1 and i2!=-1 and word1 == word2 and temp!=-1:
                #check minimum distance between last occurrence temp and current occurrence i
                minDist = min(minDist, abs(i - temp))
            if word1 != word2 and i1!= -1 and i2!=-1:
                minDist = min(minDist, abs(i1-i2))
        return minDist


                    