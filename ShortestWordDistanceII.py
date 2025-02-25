# Approach:
# - We preprocess the wordsDict by storing the indices of each word in a dictionary.
# - During a query, we retrieve the lists of indices for word1 and word2.
# - Using a two-pointer technique, we find the shortest distance by comparing index pairs efficiently.
# - This preprocessing allows for fast queries when shortest() is called multiple times.

# Time Complexity:
# - __init__: O(N) where N is the number of words in wordsDict (for preprocessing)
# - shortest: O(M + K) where M and K are the number of occurrences of word1 and word2 respectively.
# Space Complexity: O(N) (for storing word indices in a dictionary)

class WordDistance:
    def __init__(self, wordsDict: List[str]):
        # Dictionary to store word indices
        self.word_indices = defaultdict(list)

        # Populate the dictionary with word positions
        for i, word in enumerate(wordsDict):
            self.word_indices[word].append(i)

    def shortest(self, word1: str, word2: str) -> int:
        # Retrieve the list of indices for both words
        indices1, indices2 = self.word_indices[word1], self.word_indices[word2]
        i, j = 0, 0  # Two pointers for both lists
        min_distance = float('inf')

        # Use a two-pointer approach to find the minimum distance
        while i < len(indices1) and j < len(indices2):
            min_distance = min(min_distance, abs(indices1[i] - indices2[j]))

            # Move the pointer that points to the smaller index forward
            if indices1[i] < indices2[j]:
                i += 1
            else:
                j += 1

        return min_distance  # Return the shortest distance found

# Your WordDistance object will be instantiated and called as such:
# obj = WordDistance(wordsDict)
# param_1 = obj.shortest(word1, word2)
