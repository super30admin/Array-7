class Solution {

public:

    // Function to find the shortest distance between two words in a dictionary,

    // where the words could potentially be the same.

    int shortestWordDistance(vector<string>& wordsDict, string word1, string word2) {

        int dictSize = wordsDict.size();  // Get the size of the dictionary.

        int answer = dictSize;  // Initialize answer with the maximum possible distance.

      

        if (word1 == word2) {

            // Case when both words are the same.

            for (int i = 0, lastPosition = -1; i < dictSize; ++i) {

                // Loop through each word in the dictionary.

                if (wordsDict[i] == word1) {

                    // When the word matches word1 (which is also word2 in this case).

                    if (lastPosition != -1) {

                        // If this is not the first occurrence, calculate the distance

                        // from the last occurrence.

                        answer = min(answer, i - lastPosition);

                    }

                    // Update last occurrence position.

                    lastPosition = i;

                }

            }

        } else {

            // Case when the words are different.

            for (int k = 0, positionWord1 = -1, positionWord2 = -1; k < dictSize; ++k) {

                // Loop through each word in the dictionary.

                if (wordsDict[k] == word1) {

                    // When the word matches word1, update its last seen position.

                    positionWord1 = k;

                } else if (wordsDict[k] == word2) {

                    // When the word matches word2, update its last seen position.

                    positionWord2 = k;

                }

                // If both words have been seen at least once, calculate the distance.

                if (positionWord1 != -1 && positionWord2 != -1) {

                    answer = min(answer, abs(positionWord1 - positionWord2));

                }

            }

        }

      

        // Return the shortest distance found.

        return answer;

    }

};
