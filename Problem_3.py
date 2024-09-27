# Time complexity: O(N)
# Space complexity: O(1)

class Solution:
    def shortestWordDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        index1 = -1
        index2 = -1
        minimum = float("inf")
        
        # Ternary Operator
        same = True if word1 == word2 else False
        for i in range(len(wordsDict)):
            if word1 == wordsDict[i]:
                index1 = i
                
            if word2 == wordsDict[i]:
                # As soon as same is true it will go inside and make copy of index2 to index1 since I need it to calculate minimum further so I need to keep track of it
                if same:
                    index1 = index2
                index2 = i
            
            if index1 != -1 and index2 != -1:
                minimum = min(minimum, abs(index2 - index1))
                print(minimum)
            
        return minimum
            
