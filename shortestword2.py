class WordDistance:

    def __init__(self, wordsDict: List[str]):
        self.word_dictionary = defaultdict(list)

        for i, word in enumerate(wordsDict):
            self.word_dictionary[word].append(i)

        

    def shortest(self, word1: str, word2: str) -> int:
        def binary_search(target, values):

            l, r = 0, len(values) -1 
            closest = float("inf")
            while l <= r:
                mid = (l+r) // 2

                if target == values[mid]:
                    return 0 
                
                closest = min(closest, abs(target - values[mid]))

                if target - values[mid] < 0 :
                    r = mid -1 
                
                elif target - values[mid] >0:
                    l = mid +1 

            
            return closest

        w1_indicies = self.word_dictionary[word1]
        w2_indicies = self.word_dictionary[word2]

        if len(w1_indicies) == 1 and len(w2_indicies) == 1:
            return abs(w1_indicies[0] - w2_indicies[0])

        if len(w1_indicies) == 1 and len(w2_indicies) >1:
            closest = binary_search(w1_indicies[0],w2_indicies)
            return closest

        if len(w1_indicies) > 1 and len(w2_indicies) ==1:
            closest = binary_search(w2_indicies[0],w1_indicies)
            return closest

        # at this both words have multiple indicies in the search space. 
        ans = float('inf')
        for x in w1_indicies:
            ans = min(ans,binary_search(x,w2_indicies))
        
        return ans


# Your WordDistance object will be instantiated and called as such:
# obj = WordDistance(wordsDict)
# param_1 = obj.shortest(word1,word2)