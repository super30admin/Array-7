class Solution:
    """
    TC: O(n)
    SC: O(1)
    """
    def shortestDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        pt1 = -1
        pt2 = -1
        min_ = float('inf')
        for i in range(len(wordsDict)):
            if wordsDict[i] == word1:
                pt1 = i
            if wordsDict[i] == word2:
                pt2 = i
            if pt1 != -1 and pt2 != -1:
                min_ = min(min_, abs(pt2-pt1))
        return min_