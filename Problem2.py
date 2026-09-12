# Problem 2: Minimum word distance ii (https://leetcode.com/problems/shortest-word-distance-ii/)
# Time Complexity: O(n) + O(k1 + k2), where n is the length of wordsDict. We scan the whole listonce to build the map, doing constant work at each index.
# shortest: O(k1 + k2), where k1 and k2 are the number of times word1 and word2 appear. Each pointer only moves forward, never backward, so the total number of steps across both pointers is at most k1 + k2.
# Space Complexity:  O(n), since every index from wordsDict gets stored somewhere in the map, across all the word lists combined.
# Approach:
# Since we may get many queries on the same wordsDict (up to 5000 calls), it is worth doing setup work once instead of rescanning the list every time. 
# In the constructor, we build a map from each word to a sorted list of every index where it appears. 
# Then for each query, we use two pointers, one walking through word1's position list and one walking through word2's position list. 
# At each step we compare the current positions, calculate the distance, and always move forward the pointer that is currently behind, since the word that is ahead already has its best chance to be close and moving it further can only increase the gap.

class WordDistance:
    def __init__(self, wordsDict):
        self.map = {}                    # maps each word to a list of all indices where it appears
        n = len(wordsDict)                # total number of words to scan

        for i in range(n):                # walk through every index once
            word = wordsDict[i]            # word at the current index

            if word not in self.map:
                self.map[word] = []         # first time seeing this word, create its position list

            self.map[word].append(i)        # record this index as one of the positions of this word

    def shortest(self, word1, word2):
        list1 = self.map[word1]           # all positions of word1, already sorted since built left to right
        list2 = self.map[word2]           # all positions of word2, already sorted

        min = float('inf')                 # start big so the first real distance always replaces it
        p1 = 0                              # pointer into list1
        p2 = 0                              # pointer into list2

        while p1 < len(list1) and p2 < len(list2):    # keep going while both lists still have positions left
            if list1[p1] < list2[p2]:                   # word1's current position is behind word2's
                min = min if min < (list2[p2] - list1[p1]) else (list2[p2] - list1[p1])   # bigger minus smaller, keep smaller distance
                p1 += 1                                   # move word1's pointer forward, it might get closer
            else:                                        # word2's current position is behind or equal
                min = min if min < (list1[p1] - list2[p2]) else (list1[p1] - list2[p2])   # bigger minus smaller, keep smaller distance
                p2 += 1                                   # move word2's pointer forward instead

        return min                          # runs only after the loop ends, once one list is exhausted