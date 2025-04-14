from typing import List

class Solution:
    # TC : O(n)
    # SC : O(1)
    def shortest_word_distance(self, words_dict: List[str], word1: str, word2: str) -> int:
        min_distance = len(words_dict)
      
        # If both words are the same, we need to find the shortest distance
        # between two occurrences of the same word
        if word1 == word2:
            last_occurrence_index = -1 
            for index, word in enumerate(words_dict):
                if word == word1:
                    if last_occurrence_index != -1:
                        
                        min_distance = min(min_distance, index - last_occurrence_index)
                    last_occurrence_index = index
        else:
            # If the words are different, find the shortest distance between word1 and word2
            index1 = index2 = -1 
          
            for index, word in enumerate(words_dict):
                if word == word1:
                    index1 = index  
                if word == word2:
                    index2 = index  
              
                if index1 != -1 and index2 != -1:
                    min_distance = min(min_distance, abs(index1 - index2))
      

        return min_distance