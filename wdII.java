//Time Complexity:O(n) to build the map + O(k1 log k2) for each query.
//Space Complexity: O(n) — for storing word indices in the map

//Build map: word -> sorted list of indices (filled in one left→right pass).
//For query(word1, word2): retrieve lists L1, L2; for each idx in L1, binary search in L2 to get floor/ceil neighbors.
//Update min distance using neighbors and return the smallest difference.

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
        
        for(int i = 0; i < list1.size(); i++) {
            int[] temp = binarySearch(list2, list1.get(i));

            if(temp[0] >= 0) {
                int low = list2.get(temp[0]);
                min = Math.min(min, Math.abs(list1.get(i) - low));
            }
            if(temp[1] < list2.size()) {
                int high = list2.get(temp[1]);
                min = Math.min(min, Math.abs(list1.get(i) - high));
            }
        }
        return min;
    }

    private int[] binarySearch(List<Integer> list, int target) {
        int low = 0, high = list.size() - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(list.get(mid) > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return new int[]{high, low};
    }
}
