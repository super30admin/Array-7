class Sample{
    /******************PROBLEM-1*****************/
    //TC:0(N+m+n) N=length of wordsDict, m=freq of word1, n=freq of word2
//SC:0(N)
    class Solution {
        public int shortestDistance(String[] wordsDict, String word1, String word2) {
            HashMap<String,List<Integer>> map=new HashMap<>();
            for(int i=0;i<wordsDict.length;i++){
                String each=wordsDict[i];
                if(map.get(each)==null){
                    map.put(each,new ArrayList<>());
                }
                List<Integer> value=map.get(each);
                value.add(i);
                map.put(each,value);
            }

            List<Integer> arr1=map.get(word1);
            List<Integer> arr2=map.get(word2);
            int ptr1=0,ptr2=0,min=Integer.MAX_VALUE;
            while(ptr1<arr1.size() && ptr2<arr2.size()){
                min=Math.min(min,Math.abs(arr1.get(ptr1)-arr2.get(ptr2)));
                if(arr1.get(ptr1)<arr2.get(ptr2)){
                    ptr1++;
                }else{
                    ptr2++;
                }
            }
            return min;
        }
    }

    //TC:0(n) n=length of wordsDict
//SC:0(1)
    class Solution {
        public int shortestDistance(String[] wordsDict, String word1, String word2) {
            if(wordsDict==null || wordsDict.length==0){
                return 0;
            }

            int i1=-1,i2=-1,min=Integer.MAX_VALUE;
            for(int i=0;i<wordsDict.length;i++){
                if(wordsDict[i].equals(word1)){
                    i1=i;
                }else if(wordsDict[i].equals(word2)){
                    i2=i;
                }
                if(i2!=-1 && i1!=-1){
                    min=Math.min(min,Math.abs(i1-i2));
                }
            }
            return min;
        }
    }
    /******************PROBLEM-2*****************/
    //TC:0(m+n) m=freq of indices of word1,n=freq of indices of word2
//SC:0(N) N=length of wordsDict
    class WordDistance {
        HashMap<String,List<Integer>> map;
        public WordDistance(String[] wordsDict) {
            map=new HashMap<>();
            for(int i=0;i<wordsDict.length;i++){
                if(map.get(wordsDict[i])==null){
                    map.put(wordsDict[i],new ArrayList<>());
                }
                List<Integer> val=map.get(wordsDict[i]);
                val.add(i);
                map.put(wordsDict[i],val);
            }
        }

        public int shortest(String word1, String word2) {
            List<Integer> arr1=map.get(word1);
            List<Integer> arr2=map.get(word2);
            int ptr1=0,ptr2=0,min=Integer.MAX_VALUE;
            while(ptr1<arr1.size() && ptr2<arr2.size()){
                min=Math.min(min,Math.abs(arr1.get(ptr1)-arr2.get(ptr2)));
                if(arr1.get(ptr1)<arr2.get(ptr2)){
                    ptr1++;
                }else{
                    ptr2++;
                }

            }
            return min;
        }
    }

    /******************PROBLEM-3*****************/
    //TC:0(N)
//SC:0(1)
    class Solution {
        public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
            int i1=-1,i2=-1,min=Integer.MAX_VALUE;
            for(int i=0;i<wordsDict.length;i++){
                if(!word1.equals(word2)){
                    if(wordsDict[i].equals(word1)){
                        i1=i;
                    }
                    if(wordsDict[i].equals(word2)){
                        i2=i;
                    }
                }else{
                    if(wordsDict[i].equals(word1)){
                        i2=i1;
                        i1=i;
                    }
                }
                if(i1!=-1 && i2!=-1){
                    min=Math.min(min,Math.abs(i1-i2));
                }
            }
            return min;
        }
    }

    //TC:0(N)
//SC:0(1)
    class Solution {
        public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
            int i1=-1,i2=-1,min=Integer.MAX_VALUE;
            for(int i=0;i<wordsDict.length;i++){
                if(wordsDict[i].equals(word1)){
                    i1=i;
                }
                if(wordsDict[i].equals(word2)){
                    if(i1==i){
                        i1=i2;
                    }
                    i2=i;
                }

                if(i1!=-1 && i2!=-1){
                    min=Math.min(min,Math.abs(i1-i2));
                }
            }
            return min;
        }
    }
}