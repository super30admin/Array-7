# TIME CCOMPLEXITY: O(N)
# SPACE COMPLEXITY: O(1)
class Solution(object):
    def shortestWordDistance(self, words, word1, word2):
        """
        :type words: List[str]
        :type word1: str
        :type word2: str
        :rtype: int
        """
        idx1,idx2 = -1,-1
        min_dist = float('+inf')
        for i in range(len(words)):
            if words[i] == word1:
                idx1 = i
            if words[i] == word2:
                if idx1 == i:
                    idx1 = idx2
                idx2 = i
            if idx1 != -1 and idx2 !=-1:
                min_dist = min(min_dist, abs(idx1-idx2))
                
        return min_dist