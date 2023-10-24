class Solution:
    def shortestWordDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:

        #Method 1 - one pass - Same as https://leetcode.com/problems/shortest-word-distance/ but an extra case for word1==word2 case

        #TC O(n)
        
        p1=-1
        p2=-1
        mindist=len(wordsDict)
        for i in range(len(wordsDict)):
            if word1==word2:  #when both words are same
                if wordsDict[i]==word1:
                    if p1<=p2: #just update the pointer that is least, if equal update any. print out stuff, it'll make sense
                        p1=i
                    else:
                        p2=i
                if p1!=-1 and p2!=-1:
                    mindist=min(mindist,abs(p2-p1))
            else:
                if wordsDict[i]==word1:
                    p1=i
                if wordsDict[i]==word2:
                    p2=i
                if p1!=-1 and p2!=-1:
                    mindist=min(mindist,abs(p2-p1))
        return mindist