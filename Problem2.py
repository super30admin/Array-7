#Time complexity : O(nl) where n is the length of list of words and l is the avg length of word
#Space complexity: O(1)
#Works on leetcode : yes
#Approach :  Here we iterate through the words and whenever the current word matches word1, we update index1 and get the 
#minimum, however if the 2 input words are same we just update the second index as first one. But if not same, then 
#we find the word2, we update index2 and get the minimum distance again. 
class Solution:
    def shortestWordDistance(self, words: List[str], word1: str, word2: str) -> int:
        size = len(words)
        ans = size
        i1, i2 = size, size
        same = word1==word2
        for i in range(size):
            if words[i]==word1:
                i1 = i
                ans = min(ans, abs(i1-i2))
                if same:
                    i2 = i1
            elif not same and words[i]==word2:
                i2=i
                ans = min(ans, abs(i1-i2))
        return ans