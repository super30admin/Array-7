# Time complexity: O(n) and space is O(1)

# The intuition here is to have two pointers and update them based on if its word1 or word2
# Once we know that they are not -1 which means we found the two words we can calculate their distance
# Subsequently we can do for the same words which are repeated.And have a global variable with min distance

class Solution:
    def shortestDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        i1 = -1
        i2 = -1
        result = float('inf')
        for i in range(len(wordsDict)):
            if wordsDict[i] == word1:
                i1 = i

            if wordsDict[i] == word2:
                i2 = i

            if i1 != -1 and i2 != -1:
                result = min(result, abs(i1 - i2))

        return result