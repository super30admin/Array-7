# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : yes

class Solution(object):
    def shortestWordDistance(self, wordsDict, word1, word2):
        """
        :type wordsDict: List[str]
        :type word1: str
        :type word2: str
        :rtype: int
        """

        lStart = -1
        rStart = -1
        minDist = len(wordsDict)

        # check here so we are not computing string comparison every loop iteration
        equalWords = word1 == word2

        for currIdx in range(len(wordsDict)):

            word = wordsDict[currIdx]

            # if the words are the same and we have a match, move the sliding window
            if equalWords and word == word1:
                lStart = rStart
                rStart = currIdx
            # otherwise keep 2 separate pointers to the latest occurence of each word like in normal Shortest Word Distance problem
            else:
                if word == word1:
                    lStart = currIdx
                elif word == word2:
                    rStart = currIdx

            # check minDist each time if we have two valid locations
            if lStart > -1 and rStart > -1:
                minDist = min(minDist, abs(rStart - lStart))

            # optimize (we will never have a min dist better than 1)
            if minDist <= 1:
                break

        return minDist
