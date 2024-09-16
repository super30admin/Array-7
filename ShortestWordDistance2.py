class WordDistance:
    
    '''
    Time Complexity - O(N)
    Space Complexity - O(1)
    '''

    def __init__(self, words: List[str]):
        
        self.hmap={} # For storing all the index of occurences of a particular word
        for i,word in enumerate(words):
            
            if word in self.hmap:
                self.hmap[word].append(i)
            else:
                self.hmap[word]=[i] # key will be the word and value will be the list of indexes where the word occurs in the list
            
        

    def shortest(self, word1: str, word2: str) -> int:
        if len(word1)==0 or len(word2)==0:
            return 0
        
        minimum_distance=float("inf")
        
        list1=self.hmap[word1] # list of indexes where word 1 has occured
        list2=self.hmap[word2]# list of indexes of word2
        
        ptr1=0 #pointer for list1
        ptr2=0#pointer for list2
        # Example list1=[1,4,5] list2=[6,7] 
        
        while(ptr1<len(list1) and ptr2<len(list2)):
            index1=list1[ptr1]
            index2=list2[ptr2]
            
            minimum_distance = min(minimum_distance,abs(index1-index2))
            if index1>index2: # When value of list1 at ptr1 index is greater than index2--> Increment ptr2
                ptr2+=1
            else:
                ptr1+=1
                
        return minimum_distance
            
        


# Your WordDistance object will be instantiated and called as such:
# obj = WordDistance(words)
# param_1 = obj.shortest(word1,word2)