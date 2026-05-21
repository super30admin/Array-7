//
//  ShortestDistanceBetweenWords.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 4/6/26.
//

class ShortestWordDistance {
    
    init() {
        
    }
    
    func shortestDistance(_ wordsDict: [String], _ word1: String, _ word2: String) -> Int {
        var i1 = -1
        var i2 = -1
        var absDistance = Int.max
        for (index, word) in wordsDict.enumerated() {
             if (word == word1) {
                i1 = index
             }
             if (word == word2) {
                i2 = index
             }
             if (i1 != -1 && i2 != -1) {
                absDistance = min(absDistance, abs(i1 - i2))
             }
        }
        return absDistance
    }
}
