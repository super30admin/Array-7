'''
243 Shortest Word Distance
https://leetcode.com/problems/shortest-word-distance/description/

Given an array of strings wordsDict and two different strings that already exist in the array word1 and word2, return the shortest distance between these two words in the list.

Example 1:
Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "coding", word2 = "practice"
Output: 3

Example 2:
Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "coding"
Output: 1

Constraints:
2 <= wordsDict.length <= 3 * 10^4
1 <= wordsDict[i].length <= 10
wordsDict[i] consists of lowercase English letters.
word1 and word2 are in wordsDict.
word1 != word2

Solution:
1. Linear traversal of array
We use i1 and i2 as the indices of word1 and word2 respectively. We initialize i1 = i2 = -1 to indicate invalidity.

We go through the list word by word. If we encounter word1, we update i1.
If we encounter word2, we update i2. Once both i1 and i2 have been updated to valid indices, we calculate and update the minimum distance between word1 and word2.
https://youtu.be/ifr4DadXurc?t=865
Time: O(NK), Space: O(1), N = no. of words in input list, K = avg len of word1 and word2
'''
from typing import List
def shortestDistance1(wordsDict: List[str], word1: str, word2: str) -> int:
    N = len(wordsDict)
    i1, i2 = -1, -1 # posn of word1 and word2
    m = float('inf')
    for i in range(N):
        if wordsDict[i] == word1: # O(K)
            i1 = i
        if wordsDict[i] == word2: # O(K)
            i2 = i
        if i1 != -1 and i2 != -1: m = min(m, abs(i1-i2))
    return m

def run_shortestDistance1():
    tests = [(["practice", "makes", "perfect", "coding", "makes"],
              "coding", "practice", 3),
             (["practice", "makes", "perfect", "coding", "makes"],
              "makes", "coding", 1),
    ]
    for test in tests:
        wordsDict, word1, word2, ans = test[0], test[1], test[2], test[3]
        print(f"\nwordsDict = {wordsDict}")
        print(f"word1 = {word1}, word = {word2}")
        dist = shortestDistance1(wordsDict, word1, word2)
        print(f"min distance = {dist}")
        success = (ans == dist)
        print(f"Pass: {success}")
        if not success:
            print(f"Failed")
            return

run_shortestDistance1()
