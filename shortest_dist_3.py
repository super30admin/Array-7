# Time Complexity :
# O(N)  - Size of the array

# Space Complexity :
# O(1) - There is no auxillary space being allocated

# Did this code successfully run on Leetcode :
#Yes

#We go through each word, check if the word is word1 or word2 and store it's latest location. 
#In the case where both words are the same, we store p2 as the pointer containing the latest location of the word and p1 as the previous location
#If both p1 and p2 are not -1, seen at some we check if this is the minmum distance between them and update min_dist if it is
#We reutnr min_dist in the end
class Solution:
    def shortestWordDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        p1 = -1
        p2 = -1
        min_dist = len(wordsDict) + 1
        same = False

        for i,word in enumerate(wordsDict) :
            if word == word1 :
                p1 = i
                
            if word == word2 :
                if p1 == i :
                    p1 = p2
                p2 = i

            if p1 != -1 and p2 != -1 :
                min_dist = min(min_dist,abs(p2-p1))

        return min_dist
