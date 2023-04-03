# Time Complexity :
# O(N)

# Space Complexity :
# O(1)

# Did this code successfully run on Leetcode :
#Yes

#We go through each word and store it's location
#when the request for shortest distance between 2 words comes in, we go through the list of locations of these 2 words using 2 pointers. The pointer of the list whose value is lower is increased and the minimum distance is updated at each step
#In the end, we return the min distance computed

class WordDistance:

    def __init__(self, wordsDict: List[str]):
        self.loc_map = {}
        self.max_dist = len(wordsDict)
        for i,word in enumerate(wordsDict) :
            if word not in self.loc_map :
                self.loc_map[word] = []
            self.loc_map[word].append(i)
        
    def shortest(self, word1: str, word2: str) -> int:
        locs_1 = self.loc_map[word1]
        locs_2 = self.loc_map[word2]
        min_dist = self.max_dist
        p1 = 0
        p2 = 0
        while (p1 < len(locs_1) and p2 < len(locs_2)):
            curr_dist = abs(locs_1[p1] - locs_2[p2] )
            min_dist = min(min_dist, curr_dist )
            if locs_1[p1] < locs_2[p2] :
                p1 += 1
            else :
                p2 += 1
        return min_dist

# Your WordDistance object will be instantiated and called as such:
# obj = WordDistance(wordsDict)
# param_1 = obj.shortest(word1,word2)
