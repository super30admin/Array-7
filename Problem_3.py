'''
245 Shortest Word Distance III
https://leetcode.com/problems/shortest-word-distance-iii/description/

Given an array of strings wordsDict and two strings that already exist in the array word1 and word2, return the shortest distance between the occurrence of these two words in the list.

Note that word1 and word2 may be the same. It is guaranteed that they represent two individual words in the list.


Example 1:
Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "coding"
Output: 1

Example 2:
Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "makes"
Output: 3

Constraints:
1 <= wordsDict.length <= 10^5
1 <= wordsDict[i].length <= 10
wordsDict[i] consists of lowercase English letters.
word1 and word2 are in wordsDict.

Solution:
1. Two-pronged approach
We use two different approaches for word1 != word2 and word1 == word2.

First, we use i1 and i2 as the indices of word1 and word2 respectively. We initialize i1 = i2 = -1 to indicate invalidity.

a) word1 != word2
This is identical to the approach in LeetCode problem "243 Shortest Word Distance".
We go through the list word by word. If we encounter word1, we update i1.
If we encounter word2, we update i2. Once both i1 and i2 have been updated to valid indices (i1 != -1, i2 !=-1), we calculate and update the minimum distance between word1 and word2.

b) word1 == word2
Let target = word1 = word2
When we encounter the 1st instance of target, we check if i1 < i2. Since i1 = i2 = -1, this condition fails. Hence, we set i2 as the index of 1st instance
of the target.

When we encounter the 2nd instance of target, we check if i1 < i2. Since i1 = -1 and i2 >= 0 (set at the 1st instance), this condition evaluates to True. We set i1 = index of the 2nd instance of the target.

Once both i1 and i2 have been updated to valid indices (i1 != -1, i2 !=-1), we calculate and update the minimum distance between word1 and word2.
https://youtu.be/ifr4DadXurc?t=3309
Time: O(NK)  Space: O(1), N = no. of words in input list, K = avg len of word1 and word2

2. Generic approach
This is a more generic solution that works whether word! != word2 or word1 == word2. It uses fewer lines of code but doesn't improve on TC or SC.
https://youtu.be/ifr4DadXurc?t=4032
Time: O(NK), Space: O(1), N = no. of words in input list, K = avg len of word1 and word2
'''
from typing import List
from collections import defaultdict

def shortestWordDistance3_1(wordsDict: List[str], word1: str, word2: str) -> int:
    if not wordsDict:
        return -1
    N = len(wordsDict)
    i1, i2 = -1, -1 # posn of word1 and word2
    m = float('inf') # min distance between word1 and word2
    for i in range(N):
        if word1 != word2: # O(K)
            # if word1 != word2, set i1 and i2 as the latest instances
            # of word1 and word2 respectively
            if wordsDict[i] == word1: # O(K)
                i1 = i
            if wordsDict[i] == word2: # O(K)
                i2 = i
        elif wordsDict[i] == word1 == word2: # O(K)
            # if word1 == word2, set i2 and i1 as the 1st and 2nd instances
            # of word1 respectively
            if i1 < i2:
                i1 = i
            else:
                i2 = i
        # min distance is computed only when both word1 and word2
        # have been encountered
        if i1 != -1 and i2 != -1: m = min(m, abs(i1-i2))
    return m

def shortestWordDistance3_2(wordsDict: List[str], word1: str, word2: str) -> int:
    if not wordsDict:
        return -1
    N = len(wordsDict)
    i1, i2 = -1, -1 # posn of word1 and word2
    m = float('inf')
    for i in range(N):
        if wordsDict[i] == word1: # O(K)
            i1 = i
        if wordsDict[i] == word2: # O(K)
            if i1 == i: # true when word1 and word2 are identical
                i1 = i2 # give the value of i2 to i1
            i2 = i # set i2 to curr index
        if i1 != -1 and i2 != -1: m = min(m, abs(i1-i2))
    return m

def run_shortestWordDistance3():
    tests = [(["practice", "makes", "perfect", "coding", "makes"], "makes", "coding", 1), (["practice", "makes", "perfect", "coding", "makes"], "makes", "makes", 3)
    ]
    for test in tests:
        wordsDict, word1, word2, ans = test[0], test[1], test[2], test[3]
        print(f"\nwordsDict = {wordsDict}")
        print(f"word1 = {word1}, word = {word2}")
        dist = shortestWordDistance3_2(wordsDict, word1, word2)
        print(f"min distance = {dist}")
        success = (ans == dist)
        print(f"Pass: {success}")
        if not success:
            print(f"Failed")
            return

run_shortestWordDistance3()
