'''
Time Complexity: O(n)
Space Complexity: O(1)
Did this code successfully run on Leetcode : Yes
Explanation:
Create 2 indexes i1 and i2 and use these to track the indexes of the 2 words.
There are 3 cases:
1) If word1 = words[i]
make i1 = i
2) If word2 = words[i]
make i2 = i
3) If both word1 and word2 are the same word, to make sure we do not get minimum distance to be 0 as 1 case will be when both
indexes will be = i.
We check if word[i] =word1 and word[i] = word2 if this is true
make i1=i2
i2 = i
as i2 should be always ahead of i1 and i1 should be the previous value of i2
'''


class Solution:
    def shortestWordDistance(self, words: List[str], word1: str, word2: str) -> int:

        # indexes to keep track of word 1 and word2
        i2 = -1
        i1 = -1
        minDistance = math.inf
        for i in range(len(words)):
            # if the word1 = word2 then the index of the second word would always be front of the index of the first word and the index of the first word would be the second word.
            if words[i] == word1 and words[i] == word2:
                i1 = i2
                i2 = i
            # Found word 1 update the index
            elif words[i] == word1:
                i1 = i
            elif words[i] == word2:
                i2 = i
            # Found word 2 update the index

            # if both words found then find minDistance
            if i1 != -1 and i2 != -1:
                minDistance = min(minDistance, abs(i1 - i2))

        return minDistance