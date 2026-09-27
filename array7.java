//problem1
class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int n = wordsDict.length;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            String word = wordsDict[i];
            if(word1.equals(word)) {
                for(int j = 0; j < n; j++) {
                    word = wordsDict[j];
                    if(word.equals(word2)) {
                        min = Math.min(min, Math.abs(i - j));
                    }
                }
            }
        }
        return min;
    }
}
//problem2
class WordDistance {
    HashMap<String, List<Integer>> map;

    public WordDistance(String[] wordsDict) {
        this.map = new HashMap<>();
        int n = wordsDict.length;

        for(int i = 0; i < n; i++) {
            String word = wordsDict[i];
            map.putIfAbsent(word, new ArrayList<>());
            map.get(word).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);

        int min = Integer.MAX_VALUE;
        int p1 = 0, p2 = 0;

        while(p1 < list1.size() && p2 < list2.size()) {
            if(list1.get(p1) < list2.get(p2)) {
                min = Math.min(min, list2.get(p2) - list1.get(p1));
                p1++;
            } else {
                min = Math.min(min, list1.get(p1) - list2.get(p2));
                p2++;
            }
        }

        return min;
    }
}

//problem3
class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int n = wordsDict.length;

        int p1 = -1, p2 = -1;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            String word = wordsDict[i];
        
            if(word.equals(word1)) {
                p1 = i;
            }

            if(word.equals(word2)) {
                if(p1 == i) { // identifies both the words are same or not
                    p1 = p2; 
                }
                p2 = i;
            }

            if(p1 != -1 && p2 != -1) {
                min = Math.min(min, Math.abs(p1 - p2));
            }
        }

        return min;
    }
}
