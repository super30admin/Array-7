public class WordDistance {
    //TC => O(n)
    //SC => O(n)
    Dictionary<string, List<int>> map;
    public WordDistance(string[] wordsDict) {
        if(wordsDict == null || wordsDict.Length == 0){
            return;
        }
        map = new Dictionary<string, List<int>>();
        for(int i = 0; i < wordsDict.Length; i++){
            if(!map.ContainsKey(wordsDict[i])){
                map.Add(wordsDict[i], new List<int>());
            }
            map[wordsDict[i]].Add(i);
        }
    }
    //TC => O(m + n) occurrences of both words
    //SC => O(m + n)
    public int Shortest(string word1, string word2) {
        List<int> nums1 = map[word1];
        List<int> nums2 = map[word2];
        int p1 = 0, p2 = 0, min = Int32.MaxValue;
        int m = nums1.Count, n = nums2.Count;
        while(p1 < m && p2 < n){
            min = Math.Min(min, Math.Abs(nums1[p1] - nums2[p2]));
            if(nums1[p1] < nums2[p2]){
                p1++;
            }
            else{
                p2++;
            }
        }
        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.Shortest(word1,word2);
 */