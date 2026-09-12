# Problem 1: Minimum word distance (https://leetcode.com/problems/shortest-word-distance/)
# Time Complexity: O(n), We loop through wordsDict exactly once. At each index we do only constant work: one comparison for word1, one comparison for word2 and one distance check. 
# Space Complexity: O(1), We only keep a fixed number of variables: p1, p2, min, and a loop counter.
# Approach:
# We want the shortest distance between the closest occurrence of word1 and word2 in the list. 
# Checking every pair of positions would need two nested loops, which is slow. Instead we do a single pass through the list and just remember the most recent index where we saw word1 (p1) and the most
# recent index where we saw word2 (p2). 
# Every time either one gets updated, both p1 and p2 are already known, so we can immediately check the distance
# between them right there. 
# Since we always compare the two most recent positions, and older positions can only be farther apart, one pass is enough to guarantee we find the true minimum distance.

class Solution:
    def shortestDistance(self, wordsDict, word1, word2):
        n = len(wordsDict)          # total number of words to scan
        p1, p2 = -1, -1              # last seen index of word1 and word2, -1 means not seen yet
        min = float('inf')           # start big so the first real distance we find is always smaller

        for i in range(n):           # walk through every index once
            word = wordsDict[i]      # word at the current index

            if word == word1:
                p1 = i                # update last seen position of word1 to current index

            if word == word2:
                p2 = i                # update last seen position of word2 to current index

            if p1 != -1 and p2 != -1:            # only measure distance once both words have appeared at least once
                min = min if min < abs(p1 - p2) else abs(p1 - p2)   # keep the smaller of old min and new distance

        return min                   # smallest distance found across the whole list