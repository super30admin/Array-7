# Time complexity : O(p + q) --> occurences of word1 and word2
# Space complexity : O(1) --> space of hashmap is in constructor
# Leetcode : Solved and submitted

class WordDistance:
    def __init__(self, wordsDict: List[str]):
      # declare a hashmap for the word and it's occurences
        self.hashmap = {}
        
        # make a hashmap of words as key and it's occurence index as the value in an array list
        for i, word in enumerate(wordsDict):
            if word not in self.hashmap:
                self.hashmap[word] = []
            self.hashmap[word].append(i)
        
    def shortest(self, word1: str, word2: str) -> int:
        # fetch the list of both words
        lis1 = self.hashmap[word1]
        lis2 = self.hashmap[word2]
        
        p1, p2, min_val = 0, 0, float('inf')
        
        # traverse until one of the list is finished
        while p1 < len(lis1) and p2 < len(lis2):
          
            # find the min value
            min_val = min(min_val, abs(lis1[p1] - lis2[p2]))
            
            # update the min value from the list of lis1 and lis2
            if lis1[p1] < lis2[p2]:
                p1 += 1
            else:
                p2 += 1
                
        # return the min dist and final value
        return min_val


# Your WordDistance object will be instantiated and called as such:
# obj = WordDistance(wordsDict)
# param_1 = obj.shortest(word1,word2)
