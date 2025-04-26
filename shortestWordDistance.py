class Solution:
    def shortestDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        # T: O(n), S: O(1)
        index1, index2 = -1, -1
        min_dist = float("inf")
        for i, word in enumerate(wordsDict):
            if word == word1:
                index1 = i
            elif word == word2:
                index2 = i
            if index1 != -1 and index2 != -1:
                min_dist = min(min_dist, abs(index1 - index2))
        return min_dist
