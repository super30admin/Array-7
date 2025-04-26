class Solution:
    def shortestWordDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        # T: (n), S: O(1)
        min_dist = len(wordsDict)
        index1, index2 = -1, -1
        same = word1 == word2

        for i, word in enumerate(wordsDict):
            if word == word1:
                if same:
                    if index1 != -1:
                        min_dist = min(min_dist, i - index1)
                    index1 = i
                else:
                    index1 = i
                    if index2 != -1:
                        min_dist = min(min_dist, abs(index1 - index2))
            elif word == word2:
                index2 = i
                if index1 != -1:
                    min_dist = min(min_dist, abs(index1 - index2))

        return min_dist
