//TC: O(n)
//SC: O(1)
//approach: Two pointers

import java.util.Objects;

import static java.lang.Math.abs;
import static java.lang.Math.min;

public class MinimumWordDistance {
    private int shortestDistance(String[] words, String word1, String word2) {
        int i1 = -1;
        int i2 = -1;
        int minDistance = Integer.MAX_VALUE;

        for(int i=0;i<words.length;i++) {
            if (Objects.equals(words[i], word1))
                i1 = i;
            if (Objects.equals(words[i], word2))
                i2 = i;

            if (i1 != -1 && i2 !=-1)
                minDistance = min(minDistance, abs(i1 - i2));
        }
        return minDistance;
    }
}
