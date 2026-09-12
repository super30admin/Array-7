# Problem 3: Minimum word distance iii (https://leetcode.com/problems/shortest-word-distance-iii/)
# Time Complexity: O(n),We loop through wordsDict exactly once. At each index we do only constant work: checking against word1, checking against word2, and one distance check. No nested loops, so time grows directly with the size of the list.
# Space Complexity: O(1),We only keep a fixed number of variables: p1, p2, min_val, and a loop counter. 
# Approach:
# This is a variation of Shortest Word Distance where word1 and word2 might be the exact same word.
# We still walk through the list once, tracking the last seen index of word1 in p1 and the last seen index of word2 in p2.
# The tricky part is when word1 equals word2. If we just overwrite p2 every time we see a match, we would end up comparing the same index to itself,giving a distance of 0, which is wrong. 
# To handle this, whenever we are about to update p2 and p1 currently equals p2 (meaning both pointers are stuck on the same occurrence), we first shift p1 forward to take over p2's old value. 
# This makes p1 and p2 alternate between consecutive occurrences of the same word instead of collapsing onto one occurrence.

class Solution:
    def shortestWordDistance(self, wordsDict, word1, word2):
        n = len(wordsDict)              # total number of words to scan
        p1, p2 = -1, -1                  # last seen index of word1 and word2, -1 means not seen yet
        min_val = float('inf')           # start big so the first real distance always replaces it

        for i in range(n):               # walk through every index once
            word = wordsDict[i]           # word at the current index

            if word == word1:
                p1 = i                      # update last seen position of word1

            if word == word2:
                if p1 == p2:                 # p1 and p2 are stuck on the same occurrence, meaning word1 equals word2
                    p1 = p2                    # shift p1 to take over the old occurrence, freeing p2 for the new one
                p2 = i                        # update last seen position of word2 to the current index

            if p1 != -1 and p2 != -1:         # only measure distance once both positions have been set
                min_val = min(min_val, abs(p1 - p2))   # keep the smaller of old min_val and new distance

        return min_val                    # smallest distance found across the whole list