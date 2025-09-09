//time complexity- O(m log n), where m = size of list1, n = size of list2
//space complexity- O(k), where k is total unique words in wordsDict
import java.util.*;
public class MinimumWordDistance2 {
    HashMap<String, List<Integer>> map;
    public MinimumWordDistance2(String[] wordsDict) {
        this.map = new HashMap<>();
        int n = wordsDict.length;

        for (int i = 0; i < n; i++) {
            String word = wordsDict[i];
            map.putIfAbsent(word, new ArrayList<>());
            map.get(word).add(i);
        }
    }
    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list1.size(); i++) {
            int[] temp = binarySearch(list2, list1.get(i));

            if (temp[0] >= 0) {
                int low = list2.get(temp[0]);
                min = Math.min(min, Math.abs(list1.get(i) - low));
            }
            if (temp[1] < list2.size()) {
                int high = list2.get(temp[1]);
                min = Math.min(min, Math.abs(list1.get(i) - high));
            }
        }
        return min;
    }
    private int[] binarySearch(List<Integer> list, int target) {
        int low = 0, high = list.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (list.get(mid) > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[]{high, low};
    }
    public static void main(String[] args) {
        String[] wordsDict = {"practice", "makes", "perfect", "coding", "makes"};
        MinimumWordDistance2 obj = new MinimumWordDistance2(wordsDict);
        System.out.println(obj.shortest("coding", "practice"));
        System.out.println(obj.shortest("makes", "coding"));
    }
}

