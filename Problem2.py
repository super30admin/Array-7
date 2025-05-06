# Problem 2 : Shortest Word Distance II
# Time Complexity : O(m+k) where m is the number of occurrences of word1 and k is the number of occurrences of word2 
# Space Complexity : O(n) where n is the list of wordsDict
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach

from collections import defaultdict
from typing import List

class WordDistance:
    def __init__(self, words_dict: List[str]):
        # define hashMap where key is the word and value is the list of the index in the words_dict list
        self.hashMap = defaultdict(list)
        # loop through words_dict list
        for i, currentString in enumerate(words_dict):
            # check if the currentString is no in the hashMap and if it is then create a empty list
            if currentString not in self.hashMap:
                self.hashMap[currentString] = []
            # append the index i in the list for the key currentString in the hashMap
            self.hashMap[currentString].append(i)
            

    def shortest(self, word1: str, word2: str) -> int:
        # define result and set to max value which will store the min distance
        result = float('inf')
        # get the list of index for word1 from hash map
        list1 = self.hashMap.get(word1)
        # get the list of index for word2 from hash map
        list2 = self.hashMap.get(word2)
        # define p1 ans p2 pointer for both the list
        p1 = 0
        p2 = 0
        # loop till p1 and p2 is less than length of the list1 and list2 respectively
        while p1 < len(list1) and p2 < len(list2):
            # get the index at p1 and p2 position
            el1 = list1[p1]
            el2 = list2[p2]
            # check if el1 index is less than el2 index
            if el1 < el2:
                # get the minimum between result and (el2 - el1)
                result = min(result, el2 - el1)
                # increment the pointer p1
                p1 += 1
            else:
                # else get the minimum between result and (el1 - el2)
                result = min(result, el1 - el2)
                # increment the pointer p2
                p2 += 1
        # return result
        return result
        

# Example of usage:
# word_distance = WordDistance(["practice", "makes", "perfect", "coding", "makes"])
# result = word_distance.shortest("coding", "practice")
# result would have the shortest distance between "coding" and "practice" in the list
