# Time is O(n) and space is O(1)

# The intuition here is to check if word1 is equal to word2, if they are then we can update i1 and i2
# accordingly, if i1 < i2 then update i1 with i if they are not then update i2 with i
# Otherwise the logic is very similar to min word distance 1 problem

class Solution:
    def shortestWordDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        i1 = -1
        i2 = -1
        result = float('inf')
        if word1 == word2:
            for i in range(len(wordsDict)):
                if wordsDict[i] == word1:
                    if i1 < i2:
                        i1 = i
                    else:
                        i2 = i
                if i1 != -1 and i2 != -1:
                    result = min(result, abs(i1 -i2))
        else:
            for i in range(len(wordsDict)):
                if wordsDict[i] == word1:
                    i1 = i

                if wordsDict[i] == word2:
                    i2 = i

                if i1 != -1 and i2 != -1:
                    result = min(result, abs(i1 -i2))

        return result
