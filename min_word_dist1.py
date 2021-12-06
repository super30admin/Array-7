# // Time Complexity :O(n)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no

class Solution:
    def calc(self,worddict,word1,word2):
        l1=-1
        l2=-1
        minn=999999999
        for i in range(len(worddict)):
            if worddict[i]==word1:
                l1=i
            elif worddict[i]==word2:
                l2=i
            if(l1!=-1 and l2!=-1):
                minn=min(minn,abs(l1-l2))
        return minn
obj=Solution()
# print(obj.calc(["practice","makes","perfect","coding","makes"],"coding","practice"))
print(obj.calc(["practice","makes","perfect","coding","makes"],"coding","makes"))
                
            
        