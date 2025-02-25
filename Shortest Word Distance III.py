# Approach:
# - We iterate through wordsDict while keeping track of the latest index positions of word1 and word2.
# - If word1 and word2 are the same, we need to track previous occurrences to avoid using the same index.
# - Otherwise, we update their respective indices normally.
# - We maintain a minimum distance by comparing the absolute difference of indices whenever both are updated.

# Time Complexity: O(N) - We traverse the list once.
# Space Complexity: O(1) - We use only a few integer variables.

class Solution:
    def shortestWordDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        # Initialize variables to track positions of word1 and word2
        index1, index2 = -1, -1
        min_distance = float('inf')
        same_word = word1 == word2  # Check if both words are the same

        for i, word in enumerate(wordsDict):
            if word == word1:
                # If both words are the same, shift index2 before updating index1
                if same_word and index1 != -1:
                    index2 = index1
                index1 = i
            elif word == word2:
                index2 = i
            
            # If both indices have been updated, compute the minimum distance
            if index1 != -1 and index2 != -1:
                min_distance = min(min_distance, abs(index1 - index2))

        return min_distance  # Return the shortest distance found
