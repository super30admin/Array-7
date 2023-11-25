"""
Rasika Sasturkar
Time Complexity: O(n*k), k is avg. length of the word
Space Complexity: O(1)
"""
from math import inf


def shortestDistance(wordsDict, word1: str, word2: str) -> int:
    # null case
    if wordsDict is None:
        return 0

    # using 2 pointers
    i, j = -1, -1
    min_dist = inf

    for idx in range(len(wordsDict)):
        if wordsDict[idx] == word1:
            i = idx
        if wordsDict[idx] == word2:
            j = idx
        if i != -1 and j != -1:
            min_dist = min(min_dist, abs(i - j))

    return min_dist


def main():
    """
    Main function - examples from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all the test cases.
    """
    print(shortestDistance(wordsDict=["practice", "makes", "perfect", "coding", "makes"], word1="coding",
                           word2="practice"))  # returns 3
    print(
        shortestDistance(wordsDict=["practice", "makes", "perfect", "coding", "makes"], word1="makes",
                         word2="coding"))  # returns 1


if __name__ == "__main__":
    main()
