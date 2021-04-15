class WordDistance:
    
    """
    Description: Design a data structure to initialize a string array to answer queries of the shortest distance between two different strings from the array
    
    Time Complexity: O(n)
    Space Complexity: O(n)
    
    Approach:
    - Use a hashmap to account for location of words in form of list (to cover duplicated words)
    - call the hashmap and use 2 pointers solution to find minimum distance between items of 2 lists
    """
    
    from collections import defaultdict
    
    def __init__(self, wordsDict: List[str]):
        self.wordMap = defaultdict(list)
        for i in range(len(wordsDict)):
            self.wordMap[wordsDict[i]].append(i)

    def shortest(self, word1: str, word2: str) -> int:
        
        list1 = self.wordMap[word1]
        list2 = self.wordMap[word2]
        minDist = float("inf")
        
        p1 = 0; p2 = 0
        while p1 < len(list1) and p2 < len(list2):
            
            minDist = min(minDist, abs(list1[p1] - list2[p2]))
            
            if list1[p1] < list2[p2]: p1 += 1
            else: p2 += 1
                
        return minDist

# Your WordDistance object will be instantiated and called as such:
# obj = WordDistance(wordsDict)
# param_1 = obj.shortest(word1,word2)
