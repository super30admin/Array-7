'''
244 Shortest Word Distance II
https://leetcode.com/problems/shortest-word-distance-ii/description/

Design a data structure that will be initialized with a string array, and then it should answer queries of the shortest distance between two different strings from the array.

Implement the WordDistance class:
    WordDistance(String[] wordsDict) initializes the object with the strings array wordsDict.
    int shortest(String word1, String word2) returns the shortest distance between word1 and word2 in the array wordsDict.

Example 1:
Input
["WordDistance", "shortest", "shortest"]
[[["practice", "makes", "perfect", "coding", "makes"]], ["coding", "practice"], ["makes", "coding"]]
Output
[null, 3, 1]

Explanation
WordDistance wordDistance = new WordDistance(["practice", "makes", "perfect", "coding", "makes"]);
wordDistance.shortest("coding", "practice"); // return 3
wordDistance.shortest("makes", "coding");    // return 1

Constraints:
1 <= wordsDict.length <= 3 * 10^4
1 <= wordsDict[i].length <= 10
wordsDict[i] consists of lowercase English letters.
word1 and word2 are in wordsDict.
word1 != word2
At most 5000 calls will be made to shortest.

Solution:
1. Two-pointer + Hashing
Using a hash map, we store the indices of word1 and word2 occurring in the inpur list wordsDict.
Eg. map[word1] = [0, 4, 8, 12, 15, 20] (list1)
    map[word2] = [1, 2, 6, 10, 14, 22] (list2)

Now, our objective is to find which pair of indices yield the shortest distance. To find this, we adopt a two-pointer solution.

Let i = 0, j = 0 be pointers to elements in list1 and list2 respectively. We compute the absolute difference between list1[i] and list2[j].

We compare list1[i] and list2[j]. If list1[i] is smaller, we move i by 1 step to the right since we want to minimize the distance between list1[i]  and list2[j]. If we were to move j by 1 step, we would be going to greater value in list2[j] which would result in increasing the distance between list1[i] and list2[j].

On the other hand, if list2[j] is smaller, we move j by 1 step. We continue until we reach the end of either of the lists.

Thus, for each query, we use two pointers to efficiently find the shortest distance between the positions of the words. We could do a brute force n^2 or a linear scan every time, but since we get repeated queries, we optimize using preprocessed index lists.

https://youtu.be/ifr4DadXurc?t=1726

            Time      Space
__init__(): O(N)      O(N),  N = len(wordsDict)
shortest(): O(K1+K2), Space: O(K1+K2), K1 = len of list map[word1], K2 = len of list map[word2]. Note that K1 + K2 < N

For shortest(), had we used the approach of "LC#243 Shortest Word Distance", then
shortest(): O(NK), Space: O(1) (where NK > K1 + K2)
'''
from typing import List
from collections import defaultdict

class WordDistance:
    def __init__(self, wordsDict: List[str]):
        ''' Time: O(N), Space: O(N) '''
        self.map = defaultdict(list)
        N = len(wordsDict)
        for i in range(N):
            w = wordsDict[i]
            self.map[w].append(i)

    def shortest(self, word1: str, word2: str) -> int:
        ''' Time: O(K1+K2), Space: O(K1+K2) '''
        i1, i2 = 0, 0
        dist = float('inf')
        list1 = self.map[word1]
        list2 = self.map[word2]
        K1 = len(list1)
        K2 = len(list2)
        while i1 < K1 and i2 < K2:
            value1 = list1[i1]
            value2 = list2[i2]
            dist = min(dist, abs(value1-value2))
            if value1 < value2:
                i1 += 1
            else:
                i2 += 1
        return dist


def run_WordDistance2():
    tests = [ (["WordDistance", "shortest", "shortest"],
               [ ["practice", "makes", "perfect", "coding", "makes"],
                 ["coding", "practice"], ["makes", "coding"]
               ],
               [None, 3, 1]),
    ]
    for test in tests:
        operations, inputs, ans = test[0], test[1], test[2]
        outputs = []
        for operation, input in zip(operations, inputs):
            if operation == "WordDistance":
                sol = WordDistance(input)
                output = None
            elif operation == "shortest":
                output = sol.shortest(input[0], input[1])
            print(f"{operation}({input}): {output}")
            outputs.append(output)

        print(f"\nOperations = {operations}")
        print(f"inputs = {inputs}")
        print(f"outputs = {outputs}")
        success = (ans==outputs)
        print(f"Pass: {success}")
        if not success:
            print("Failed")
            return

run_WordDistance2()