        ind1, ind2 = -1, -1

        result = 300001

        for i, word in enumerate(wordsDict):
            if word1 == word:
                ind1 = i
            
            if word2 == word:
                ind2 = i
            
            if ind1 != -1 and ind2 != -1:
                result = min(result, abs(ind1-ind2))
        return result
