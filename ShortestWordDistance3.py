class Solution:
    def shortestWordDistance(self, words: List[str], word1: str, word2: str) -> int:
        
        '''
        Time Complexity - O(N)
        Space Complexity - O(1)
        
        Code accepted on leetcode
        '''
        
        if words == None or len(word1)==0 or len(word2)==0:
            return 0   
        
        i1=-1
        i2=-1
        output=float("inf")
        
        for i in range(len(words)):
            
            if words[i]==word1:
                i1=i
            if words[i]==word2:
                if i1==i: # For storing last location where word1 previously occured
                    i1=i2 # Storing i2 value with i1 so that we have the last occurence
                i2=i #Updating i2 with the current index
                
            if i1!=-1 and i2!=-1:
                output=min(output,abs(i2-i1)) # Calculating minimum distance
        
        return output
                    