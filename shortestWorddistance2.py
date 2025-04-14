from collections import defaultdict
from math import inf
from typing import List

class WordDistance:
    # TC : O(n)
    # SC : O(n)
    def __init__(self, words_dict: List[str]):
        self.indices_map = defaultdict(list)
        for index, word in enumerate(words_dict):
            self.indices_map[word].append(index)

    def shortest(self, word1: str, word2: str) -> int:
        
        indices_word1, indices_word2 = self.indices_map[word1], self.indices_map[word2]
        min_distance = inf
        i, j = 0, 0
      
        while i < len(indices_word1) and j < len(indices_word2):
           
            min_distance = min(min_distance, abs(indices_word1[i] - indices_word2[j]))
            
            if indices_word1[i] <= indices_word2[j]:
                i += 1
            else:
                j += 1
      

        return min_distance