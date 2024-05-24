'''
Time Complexity - O(n).
Space Complexity - O(1)

Works on leetcode
'''
class Solution:
    def shortestDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        #Brute Force, select each index of word1 and compare the distance between all the indices where the word2 is present and find the minimum distance. O(n^2)
        

        #optimal O(n) Space O(1)
        # #use 2 pointers 1 for each word
        # i1, i2 = -1, -1
        # minDist = 3*1e5
        # for i in range(len(wordsDict)):
        # #when a word in the list matches any of the two words, we update the pointer to that index
        # #when both words have been found we calculate the minimum distance between each word
        #     if wordsDict[i] == word1:
        #         i1=i
        #     if wordsDict[i] == word2:
        #         i2=i
        #     if i1!=-1 and i2!=-1:
        #         minDist = min(minDist, abs(i1-i2))
        # return minDist

        #better O(2n) Space: O(n)
        hashMap = {}
        #store all the indices of occurrences of each word
        for i in range(len(wordsDict)):
            if word1 == wordsDict[i]:
                if word1 not in hashMap:
                    hashMap[word1] = []
                indices = hashMap.get(word1)
                indices.append(i)
            if word2 == wordsDict[i]:
                if word2 not in hashMap:
                    hashMap[word2] = []
                indices = hashMap.get(word2)
                indices.append(i)
        minDist = 3*1e5
        indices1 = hashMap[word1]
        indices2 = hashMap[word2]
        #use two pointers
        i, j = 0, 0
        while i< len(indices1) and j < len(indices2):
            #calculate the minimum distance between each index
            minDist = min(minDist, abs(indices1[i]-indices2[j]))
            #move the pointer of that word whose current index value is lower.
            if indices1[i] < indices2[j]:
                i+=1
            else:
                j+=1
        return minDist
            
        