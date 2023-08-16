class WordDistance {
    private Map<String, List<Integer>> wordIndices;

    public WordDistance(String[] wordsDict) {
        // SC: O(n)
        wordIndices = new HashMap<>();
        
        for (int i = 0; i < wordsDict.length; i++) {
            String word = wordsDict[i];
            wordIndices.putIfAbsent(word, new ArrayList<>());
            wordIndices.get(word).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> indices1 = wordIndices.get(word1);
        List<Integer> indices2 = wordIndices.get(word2);
        int minDistance = Integer.MAX_VALUE;
        
        // TC: O(m + n), where m and n are the lengths of indices1 and indices2 respectively
        for (int i = 0, j = 0; i < indices1.size() && j < indices2.size(); ) {
            int index1 = indices1.get(i);
            int index2 = indices2.get(j);
            
            minDistance = Math.min(minDistance, Math.abs(index1 - index2));
            
            if (index1 < index2) {
                i++;
            } else {
                j++;
            }
        }
        
        return minDistance;
    }
}

