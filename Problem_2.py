'''
Time Complexity - O(1)(average).
Space Complexity - O(n)

Works on leetcode
'''
class WordDistance:

    def __init__(self, wordsDict: List[str]):
        self.cache = {}
        #strore the occurrences of all the words in hashMap
        for i in range(len(wordsDict)):
            if wordsDict[i] not in self.cache:
                self.cache[wordsDict[i]] = []
            indices = self.cache[wordsDict[i]]
            indices.append(i)
        

    def shortest(self, word1: str, word2: str) -> int:
        indices1 = self.cache[word1]
        indices2 = self.cache[word2]
        #given the two words we get their list of occurrences from map and use a pointer on the respective list
        i, j= 0, 0
        minDist = 3*1e5
        while i < len(indices1) and j < len(indices2):
            #calculate the distance between the value at index at each pointer and update the minimum distance
            minDist = min(minDist, abs(indices1[i] - indices2[j]))
            #after calculation move the pointer whose value is smaller
            if indices1[i] < indices2[j]:
                i+=1
            else:
                j+=1
        

        return minDist


# Your WordDistance object will be instantiated and called as such:
# obj = WordDistance(wordsDict)
# param_1 = obj.shortest(word1,word2)