class Solution:
    '''
    Time Complexity - O(N)
    Space Complexity - O(1)
    
    '''
    def shortestDistance(self, words: List[str], word1: str, word2: str) -> int:
        
        #base case
        if words == None or len(word1)==0 or len(word2)==0:
            return 0
        
        i1=-1 # for getting index of word1
        i2=-1 # for getting index of word 2
        minimum_distance=float("inf")
        
        for i in range(len(words)): 
            
            if words[i]==word1: #Updating i1 with index of word1
                i1=i
                
            if words[i]==word2: # Updating i2 with index of word2
                i2=i
                
            if i1!=-1 and i2!=-1: #Finding the minimum distance and storing in minimum_distance
                minimum_distance=min(minimum_distance,abs(i1-i2))
            
        return minimum_distance
            
            
        