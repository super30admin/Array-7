//
//  ShortestWordDistance|||.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 5/21/26.
//

class ShortestWordDistanceIII {
    
    init() {
        
    }
    
    func shortestWordDistance(_ wordsDict: [String], _ word1: String, _ word2: String) -> Int {
          var i1 = -1
          var i2 = -1
          var distance = Int.max
          for i in 0..<wordsDict.count {
              let word = wordsDict[i]
              if (word == word1) {
                  i1 = i
              }

              if (word == word2) {
                  //if the first and second word both are the same then
                  if (i1 == i) {
                      i1 = i2
                  }
                  i2 = i
              }

              if (i1 != -1 && i2 != -1) {
                  distance = min(distance, abs(i1 - i2))
              }
          }
          return distance
      }
}
