# problem 1 : 244. Shortest Word Distance II : https://leetcode.com/problems/shortest-word-distance-ii/
# Time Complexity : O(nl) where n is the number of words and l is length of maximum length word
# Space Complexity : O(n) for hashmap
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

from collections import defaultdict
class WordDistance:

    def __init__(self, words: List[str]):
        self.loc = defaultdict(list)
        for i,word in enumerate(words):
            self.loc[word].append(i)


    def shortest(self, word1: str, word2: str) -> int:
        word1_l = self.loc[word1]
        word2_l = self.loc[word2]
        min_dist = float("INF")
        i = 0
        ind1, ind2 = 0, 0
        while ind1 < len(word1_l) and ind2<len(word2_l):
            min_dist = min(min_dist,abs(word1_l[ind1]-word2_l[ind2]))
            if word1_l[ind1] < word2_l[ind2]:
                ind1 += 1
            else:
                ind2 += 1
        return min_dist


# problem 2 : 245. Shortest Word Distance III : https://leetcode.com/problems/shortest-word-distance-iii/
# Time Complexity : O(nl) where n is the number of words and l is length of maximum length word
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
class Solution:
    def shortestWordDistance(self, words: List[str], word1: str, word2: str) -> int:
        min_dist = float("INF")
        ind_1 = -1
        ind_2 = -1
        for i,word in enumerate(words):
            if word == word1 and word == word2:
                if ind_1 !=-1 and ind_2 != -1:
                    min_dist = min(min_dist, i-ind_2)
                ind_1 = i
                ind_2 = i
            elif word == word1:
                if ind_2 != -1:
                    min_dist = min(min_dist, i-ind_2)
                ind_1 = i
            elif word == word2:
                if ind_1 != -1:
                    min_dist = min(min_dist, i-ind_1)
                ind_2 = i
        return min_dist
