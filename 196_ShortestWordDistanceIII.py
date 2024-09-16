
'''
Not executed on leetcode.
Time - O(N^2)
Space - O(1)
Approach:
Assumption - word1 and word2 can be equal as well.
1. 2 pointer approach, first pointer contains the location of word1 and 2nd pointer contains the location of word2.
2. Iterate over the words list and calculate minimum distance among 2 words by using pointer locations.
3. If the 2 given words are equal then fix the value at one pointer and change the other one to calculate distance.(handled in 2nd if case)
'''
class Solution:
    def shortestDistanceIII(self, words, word1, word2):
        i1 = -1
        i2 = -1

        minDistance = float('inf')

        for i in range(len(words)):
            if words[i] == word1:
                i1 = i
            if words[i] == word2:
                if word1 == word2:
                    i1 = i2
                i2 = i
            if i1 != -1 and i2 != -1:
                minDistance = min(minDistance, abs(i1-i2))

        return minDistance

sol = Solution()
words = ["practice","makes","perfect","coding","makes"]
print(sol.shortestDistanceIII(words,"makes","makes"))