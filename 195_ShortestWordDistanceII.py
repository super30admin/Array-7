# similar to WordDistance problem-194 but it is used for multiple calls.
# So here, to reduced the time complexity we use hashmap to save all locations of the words where key is word and value is list of index values.
# While searching directly select the word from hashmap and iterate through the values for 2 words using 2 pointers to find minimum distance.
class Solution:
    def __init__(self):
        self.hashmap = {}
    def WordDistanceII(self, words):

        for i in range(len(words)):
            word = words[i]
            if word in self.hashmap:
                self.hashmap[word].append(i)
            else:
                self.hashmap[word] = [i]

    def shortest(self, word1, word2):
        w1 = self.hashmap[word1]
        w2 = self.hashmap[word2]

        i = 0
        j = 0
        while i < len(w1) and j < len(w2):
            i1 = w1[i]
            i2 = w2[j]

            minDistance = min(minDistance, abs(i1-i2))

            if i2 > i1:
                i += 1
            else:
                j += 1
        return minDistance
