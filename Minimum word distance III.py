#Time Complexity : O(n), We iterate through wordsDict only once
#Space Complexity : O(1)
class Solution:
    def shortestWordDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        p1 = -1 
        p2 = -1
        minimum = float('inf')
        n = len(wordsDict)
        for i in range(0,n):
            if(word1==word2):
                if(wordsDict[i]==word1 or wordsDict[i]==word2):
                    if(p1<p2):
                        p1=i
                    else:
                        p2=i
            else:
                if(wordsDict[i]==word1):
                    p1=i
                elif(wordsDict[i]==word2):
                    p2=i
            if(p1!=-1 and p2!=-1):
                minimum = min(minimum,abs(p1-p2))
        return minimum
        