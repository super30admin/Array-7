class WordDistance {


    //Time Complexity: 0(nk) where n is the no of words in the array and k is the average length of the words
    //Space Complexity: 0(n)

    HashMap<String, List<Integer>> map; //a map to store the words in words dict and a list of indexes of it's occurences

    public WordDistance(String[] wordsDict) {

        map = new HashMap<>();

        for(int i = 0; i < wordsDict.length; i++){  //going over dict and storing each word to hashmap and its occurence
            String s = wordsDict[i];
            if(!map.containsKey(s)){
                map.put(s, new ArrayList<>());
            }
            map.get(s).add(i);
        }
    }

    public int shortest(String word1, String word2) {

        int dist = Integer.MAX_VALUE;   //calculates the minimum distance
        List<Integer> l1 = map.get(word1);  //to get the list of occurence of word 1
        List<Integer> l2 = map.get(word2);  //gets the list of occurence of word 2
        int p1 = 0; //pointer to navigate the l1 and l2 list
        int p2 = 0;

        while(p1 < l1.size() && p2 < l2.size()){    //till any one pointer goes out of bounds
            int idx1 = l1.get(p1);  //getting the 1st index of occurence of word1 and word 2 in list l1 and l2 respectively
            int idx2 = l2.get(p2);
            dist = Math.min(dist, Math.abs(idx1 - idx2));   //computing the distance between them
            if(idx1 < idx2){    //if 1st index is smaller, then I move the pointer in l1 to narrow the difference
                p1++;
            }
            else{   //else I move the pointer in l2 to narrow the difference
                p2++;
            }
        }

        return dist;    //return distance
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */