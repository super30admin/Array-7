#o(2^n),o(n)
# // Time Complexity :O(2^n)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no
class Solution:
    def __init__(self):
        self.maxprofit=0
    def maxProfit(self, prices: List[int]) -> int:
        self.maxprofit=self.dfs(prices,0,-1)
        return self.maxprofit
    def dfs(self,prices,dayidx,buyidx):
        #base
        if dayidx>=len(prices):
            return 0
        #logic
        #ignore
        case1=self.dfs(prices,dayidx+1,buyidx)
        #buy/sell
        if buyidx==-1:
            case2=self.dfs(prices,dayidx+1,dayidx)
        else:
            case2=prices[dayidx]-prices[buyidx]+self.dfs(prices,dayidx+2,-1)
        
        return max(case1,case2)
        
        