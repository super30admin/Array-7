# Array-8

## Problem 1: Minimum word distance (https://leetcode.com/problems/shortest-word-distance/)

Time - Complexity = O(N)
Space - Complexity = O(1)

class Solution {
public int shortestDistance(String[] wordsDict, String word1, String word2) {
if(wordsDict == null || wordsDict.length == 0) {
return 0;
}
int i1 = -1;
int i2 = -1;
int result = Integer.MAX_VALUE;

        for(int i = 0; i < wordsDict.length; i++) {
            if(word1.equals(wordsDict[i])) {
                i1 = i;
            }
            if(word2.equals(wordsDict[i])) {
                i2 = i;
            }
            if(i1 != -1 && i2 != -1) {
                result = Math.min(result, Math.abs(i1-i2));
            }
        }
        return result;
    }

}

## Problem 2: Minimum word distance ii (https://leetcode.com/problems/shortest-word-distance-ii/)

//Time - complexity = O(N)
//Space - complexity = O(N)

class WordDistance {
Map<String, List<Integer>> map;

    public WordDistance(String[] wordsDict) {
        map = new HashMap<>();

        for(int i = 0 ; i < wordsDict.length; i++) {
            if(!map.containsKey(wordsDict[i])) {
                map.put(wordsDict[i], new ArrayList<>());
            }
            map.get(wordsDict[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);

        int i1 = 0;
        int i2 = 0;
        int result = Integer.MAX_VALUE;

        while(i1 < list1.size() && i2 < list2.size()) {
            result = Math.min(result, Math.abs(list1.get(i1)-list2.get(i2)));
            if(list1.get(i1) <= list2.get(i2)) {
                i1++;
            } else {
                i2++;
            }
        }
        return result;
    }

}

/\*\*

- Your WordDistance object will be instantiated and called as such:
- WordDistance obj = new WordDistance(wordsDict);
- int param_1 = obj.shortest(word1,word2);
  \*/

## Problem 3: Minimum word distance iii (https://leetcode.com/problems/shortest-word-distance-iii/)

Time - Complexity = O(N)
Space - Complexity = O(1)

class Solution {
public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
if(wordsDict == null || wordsDict.length == 0) {
return 0;
}
int i1 = -1;
int i2 = -1;
int result = Integer.MAX_VALUE;
for(int i = 0 ; i < wordsDict.length; i++) {
if(word1.equals(wordsDict[i])) {
i1 = i;
}
if(word2.equals(wordsDict[i])) {
if(i1 == i) {
i1 = i2;
}
i2 = i;
}
if(i1 != -1 && i2 != -1) {
result = Math.min(result, Math.abs(i1-i2));
}
}
return result;
}
}
