class WordDistance:

    def __init__(self, wordsDict: List[str]):
        self.h = {}
        
        for index,word in enumerate(wordsDict):
            if word not in self.h:
                self.h[word] = []
            self.h[word].append(index)
        
        print(self.h)
            
        

    def shortest(self, word1: str, word2: str) -> int:
        word1_list = self.h[word1]
        word2_list = self.h[word2]
        
        word1_pointer = 0
        word2_pointer = 0
        
        result = float('inf')
        
        while word1_pointer < len(word1_list) and word2_pointer < len(word2_list):
            
            result = min(result, abs(word1_list[word1_pointer] - word2_list[word2_pointer]))
            
            if word1_list[word1_pointer] < word2_list[word2_pointer]:
                word1_pointer +=1
            else:
                word2_pointer +=1
            
        
        return result
        


# Your WordDistance object will be instantiated and called as such:
# obj = WordDistance(wordsDict)
# param_1 = obj.shortest(word1,word2)
