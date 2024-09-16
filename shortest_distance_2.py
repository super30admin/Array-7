# Approach similar to other problems, here we want a lookup so that for q number of queries instead of O(Q N) we do it in O(N) with lookups of indices
# Time - O(N)
# Space - O(N)


 class WordDistance(object):

     def __init__(self, words):
      
         self.hashmap = collections.defaultdict(list)
         for index, word in enumerate(words):
             self.hashmap[word].append(index)


     def shortest(self, word1, word2):
    
        idx1 = self.hashmap[word1]
        idx2 = self.hashmap[word2]
        min_diff = float('inf')
        i, j = 0, 0
        while i < len(idx1) and j < len(idx2):
            min_diff = min(min_diff, abs(idx1[i] - idx2[j]))
            if idx1[i] < idx2[j]:
                i += 1
            else:
                j += 1
        return min_diff
