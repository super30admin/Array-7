//
//  ShortestWordDistanceII.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 5/20/26.
//

/*
 time complexity - O(n)
 space complexity - O(n)
 This pattern occurs frequently when multiple queries occur, we have sorted indices, nearest distance between 2 sets of positions
 */
class WordDistance {

    var wordIdxMap = [String: [Int]]()

    init(_ wordsDict: [String]) {
        for (index, word) in wordsDict.enumerated() {
            if (wordIdxMap[word] == nil) {
                wordIdxMap[word] = [index]
            } else {
                wordIdxMap[word]!.append(index)
            }
        }
    }
    
    func shortest(_ word1: String, _ word2: String) -> Int {
        var minDistance = Int.max
        let word1Indices = wordIdxMap[word1]!
        let word2Indices = wordIdxMap[word2]!
        var i1 = 0
        var i2 = 0

        while (i1 < word1Indices.count && i2 < word2Indices.count) {
            var el1 = word1Indices[i1]
            var el2 = word2Indices[i2]
            minDistance = min(minDistance, abs(el1 - el2))
            
            if (el1 < el2) {
                i1 += 1
            } else {
                i2 += 1
            }
        }

        return minDistance
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * let obj = WordDistance(wordsDict)
 * let ret_1: Int = obj.shortest(word1, word2)
 */
