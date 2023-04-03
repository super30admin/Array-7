# Time Complexity :
# O(N)  - Size of the array

# Space Complexity :
# O(1) - There is no auxillary space being allocated

# Did this code successfully run on Leetcode :
#Yes

#We go through each word, check if the word is word1 or word2 and store it's latest location. If both words have been seen at some locaiton, we check if this is the minmum distance between them and update min_dist if it is
#We reutnr min_dist in the end

class Solution:
    def shortestDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        p1 = -1
        p2 = -1
        min_dist = len(wordsDict) + 1
        for i,word in enumerate(wordsDict) :
            if word == word1 :
                p1 = i
            elif word == word2 :
                p2 = i
            if p1 != -1 and p2 != -1 :
                min_dist = min(min_dist,abs(p2-p1))
        return min_dist
