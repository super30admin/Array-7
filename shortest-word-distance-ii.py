# TIME COMPLEXITY: O(N)
# SPACE COMPLEXITY: O(N)
class WordDistance(object):

    def __init__(self, words):
        """
        :type words: List[str]
        """
        self.hmap = collections.defaultdict(list)
        for index, word in enumerate(words):
            self.hmap[word].append(index)
        

    def shortest(self, word1, word2):
        """
        :type word1: str
        :type word2: str
        :rtype: int
        """
        idx1 = self.hmap[word1]
        idx2 = self.hmap[word2]
        min_diff = float('inf')
        i, j = 0, 0
        while i < len(idx1) and j < len(idx2):
            min_diff = min(min_diff, abs(idx1[i] - idx2[j]))
            if idx1[i] < idx2[j]:
                i += 1
            else:
                j += 1
        return min_diff
        
            


# Your WordDistance object will be instantiated and called as such:
# obj = WordDistance(words)
# param_1 = obj.shortest(word1,word2)