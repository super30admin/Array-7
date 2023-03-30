/*

The question is asking us that design a data structure to store the strings in the array and then we will get the shortest distance between any two different words any number of times

If we keep going over the array whenever the shortest distance is calculated then it will be extra O(n) time ,
so we will store the indices in the a map of string to list of indices
the list would already be sorted as we are going from start to the end of the array

When we will be queried for the short distance, we will get the lists from the hashmap

We will then use the algortithm of merging two sorted list

basicially , we will start with two pointers on the list, calcualte the distance 
Then we will move the pointer with lesser value of the two, because we need to get the shortest distance , that is why if the shorter value moves to a higher value, the distance would be squeezed. we will keep calculating the minimum in this process

Time: O(n)
Space : O(n)
*/

class WordDistance {

    HashMap<String, List<Integer>> map;

    public WordDistance(String[] wordsDict) {
        map = new HashMap<String, List<Integer>>();

        for(int i=0;i<wordsDict.length;i++){
            if(!map.containsKey(wordsDict[i])){
                map.put(wordsDict[i],new ArrayList<Integer>());
            }
            List<Integer> list = map.get(wordsDict[i]);
            list.add(i);
        }
    }
    
    public int shortest(String word1, String word2) {

        int min = Integer.MAX_VALUE;

        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);

        int ptr1 =0;int ptr2 =0;
        // Algorithm of meger two sorted list
        // In this case , whichever list is giving the smaller value would move , as we may get a shorter distance when that small value is bigger
        // Time O (l1 + l2)
        while(ptr1 < l1.size() && ptr2 < l2.size()){
            int val1= l1.get(ptr1) ;
            int val2 = l2.get(ptr2);
            min = Math.min(min, Math.abs(val1 - val2));
            if(val1<val2) ptr1++;
            else ptr2++;
        }

        return min;
        
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */