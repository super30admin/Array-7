# Approach:
# We iterate through the wordsDict while keeping track of the latest index positions of word1 and word2.
# Whenever we find either word, we update its respective index.
# If both indices have been updated at least once, we calculate the absolute difference 
# and update the minimum distance found so far.
# This ensures an efficient single-pass solution.

# Time Complexity: O(N) - We traverse the list once.
# Space Complexity: O(1) - We use only a few integer variables.

class Solution:
    def shortestDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        # Initialize variables to track positions of word1 and word2
        index1, index2 = -1, -1
        min_distance = float('inf')  # Set to a very large value initially

        # Iterate through wordsDict to find the shortest distance
        for i, word in enumerate(wordsDict):
            if word == word1:  # If current word is word1, update index1
                index1 = i
            elif word == word2:  # If current word is word2, update index2
                index2 = i

            # If both indices are updated, compute the distance and update min_distance
            if index1 != -1 and index2 != -1:
                min_distance = min(min_distance, abs(index1 - index2))

        return min_distance  # Return the shortest distance found
