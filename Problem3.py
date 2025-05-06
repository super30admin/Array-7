# Problem 3 : Shortest Word Distance III
# Time Complexity : O(n) where n is the length of the words_dict size
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach

from typing import List

class Solution:
    def shortest_word_distance(self, words_dict: List[str], word1: str, word2: str) -> int:
        # edge case if the words_dict is None then return -1
        if not words_dict:
            return -1
        # define i1 and i2 variable which will store index for word1 and word2 respectively
        i1, i2 = -1, -1
        # defin minDist to store minimum distance and set to max value
        minDist = float('inf')
        
        # check if word1 and word2 are equal
        if word1 == word2:
            # if it is then loop through words_dict list
            for i, currentString in enumerate(words_dict):
                # if the currentString is equal to word1 then set the value of i1 to i2 and i2 to i 
                if currentString == word1:
                    i1 = i2
                    i2 = i
                # check if the i1 and i2 are not equal to -1
                if i1 != -1 and i2 != -1:
                    # if it is then get the minimum between minDist and absolute of i1 - i2
                    minDist = min(minDist, abs(i1 - i2))
        else:
            # else both the words are not same
            # loop through words_dict list
            for i, currentString in enumerate(words_dict):
                # check if the currentString is equal to word1 and if it is then set the value of i1 to i
                if currentString == word1:
                    i1 = i
                # check if the currentString is equal to word2 and if it is then set the value of i2 to i
                if currentString == word2:
                    i2 = i
                # check if the i1 and i2 are not equal to -1
                if i1 != -1 and i2 != -1:
                    # if it is then get the minimum between minDist and absolute of i1 - i2
                    minDist = min(minDist, abs(i1 - i2))
        # return minDist
        return minDist
