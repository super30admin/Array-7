# Time complexity : O(n + min(p+q,n)
# Space complexity : O(n*k)
# Leetcode : Solved and submitted

class Solution:
    def shortestWordDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        # create a hashmap for all the words with the indexes of their occurences
        hashmap = {}
        for i, word in enumerate(wordsDict):
            if word not in hashmap:
                hashmap[word] = []
            hashmap[word].append(i)
        
        # if both the words are not same
        if word1 != word2:
            p1, p2, min_val = 0, 0, float('inf')
            
            # fetch the list of words occurences from the hashmap
            lis1 = hashmap[word1]
            lis2 = hashmap[word2]
            
            # traverse over both the list
            while p1 < len(lis1) and p2 < len(lis2):
              
                # fetch the min value which is the distance between the two words
                min_val = min(min_val, abs(lis1[p1]-lis2[p2]))
                
                # update the pointers of the lowest value
                if lis1[p1] < lis2[p2]:
                    p1 += 1
                else:
                    p2 += 1
        else:
            # if the words are same, then use 2 pointers
            p1, p2, min_val = -1, -1, float('inf')
            for i, word in enumerate(wordsDict):
                if word == word1:
                    # if the first pointer is less than the second
                    if p1 <= p2:
                        # then update p1 with i
                        p1 = i
                    else:
                      # else update p2 with i
                        p2 = i
                    # if we have found two occurences of the same word, only then calculate the min value
                    if p1 != -1 and p2 != -1:
                        min_val = min(min_val, abs(p1-p2))
                        
        # return the min value
        return min_val
