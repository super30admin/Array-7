# Time Complexity : O(N) where N is number of elements in s 
# Space Complexity : O(N) where N is number of elements in s
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# I am pre-processing the wordsDict to create a hashmap that maps each word to a list of its indices.
# This allows for efficient retrieval of indices for any given word.
# The shortestWordDistance method uses a two-pointer technique to find the minimum distance between the indices
# of the two words. If the words are the same, it computes the minimum distance between consecutive indices.
# By iterating through both lists of indices, I can efficiently compute the minimum distance.
# This approach ensures that the distance calculation is optimal.
from typing import List
class Solution:
    def shortestWordDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        hashmap = {}
        for i in range(len(wordsDict)):
            w = wordsDict[i]
            if w not in hashmap:
                hashmap[w] = []
            hashmap[w].append(i)
        arr1 = hashmap[word1]
        arr2 = hashmap[word2]
        i = 0
        j = 0
        ans = float('inf')
        if word1 == word2:
            for c in range(1,len(arr1)):
                ans = min(ans,abs(arr1[c] - arr1[c-1]))
            return ans
        while i < len(arr1) and j < len(arr2):
            ans = min(ans,abs(arr1[i] - arr2[j]))
            if arr1[i] < arr2[j]:
                i += 1
            else:
                j += 1
            
        return ans