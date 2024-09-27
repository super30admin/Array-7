#o(m+n),number of occurences of word1 and word2,o(1)

# // Time Complexity :O(m+n)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no
class Solution:
    def __init__(self,worddict):
        self.hmap={}
        for i in range(len(worddict)):
            if worddict[i] not in self.hmap.keys():
                self.hmap[worddict[i]]=[]
            self.hmap[worddict[i]].append(i)
            
        
    def calc(self,word1,word2):
        li=self.hmap[word1]
        li2=self.hmap[word2]
        print(li,li2)
        i=0
        j=0
        minn=9999999
        print(len(word1),len(word2))
        while i<len(li) and j<len(li2):
            print(i,j)
            idx1=li[i]
            idx2=li2[j]
            print(idx1,idx2)
            minn=min(minn,abs(idx1-idx2))
            if idx1<idx2:
                i+=1
            else:
                j+=1
        return minn
            
            
        
obj=Solution(["practice","makes","perfect","coding","makes"])
# print(obj.calc(["practice","makes","perfect","coding","makes"],"coding","practice"))
print(obj.calc("coding","practice"))
                
            
        