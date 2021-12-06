#o(n),number of occurences of word1 and word2,o(1)
# // Time Complexity :O(n)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no
class Solution:
    
        
    def calc(self,worddict,word1,word2):
        i1=-1
        i2=-1
        minn=999999999
        for i in range(len(worddict)):
            print(i1,i2)
            if worddict[i]==word1:
                i1=i
            if worddict[i]==word2:
                if i1==i:
                    i1=i2
                i2=i
            if i1!=-1 and i2 !=-1:
                minn=min(minn,abs(i1-i2))
                
        return minn
                
            
        
            
        
obj=Solution()
print(obj.calc(["practice","practice","makes","perfect","coding","makes","practice"],"practice","practice"))
# print(obj.calc("coding","practice"))
                
            
        