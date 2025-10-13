# Problem

[Problem Link](https://leetcode.com/problems/find-resultant-array-after-removing-anagrams/?envType=daily-question&envId=2025-10-13)

You are given a 0-indexed string array words, where words[i] consists of lowercase English letters.

In one operation, select any index i such that 0 < i < words.length and words[i - 1] and words[i] are anagrams, and delete words[i] from words. Keep performing this operation as long as you can select an index that satisfies the conditions.

Return words after performing all operations. It can be shown that selecting the indices for each operation in any arbitrary order will lead to the same result.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase using all the original letters exactly once. For example, "dacb" is an anagram of "abdc".

 

Example 1:

Input: words = ["abba","baba","bbaa","cd","cd"]
Output: ["abba","cd"]
Explanation:
One of the ways we can obtain the resultant array is by using the following operations:
- Since words[2] = "bbaa" and words[1] = "baba" are anagrams, we choose index 2 and delete words[2].
  Now words = ["abba","baba","cd","cd"].
- Since words[1] = "baba" and words[0] = "abba" are anagrams, we choose index 1 and delete words[1].
  Now words = ["abba","cd","cd"].
- Since words[2] = "cd" and words[1] = "cd" are anagrams, we choose index 2 and delete words[2].
  Now words = ["abba","cd"].
We can no longer perform any operations, so ["abba","cd"] is the final answer.
Example 2:

Input: words = ["a","b","c","d","e"]
Output: ["a","b","c","d","e"]
Explanation:
No two adjacent strings in words are anagrams of each other, so no operations are performed.
 

Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 10
words[i] consists of lowercase English letters.

# Solution

## MySolution

``` java

class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> strs = new ArrayList<>();
        int[] count = new int[26];

        for (int i = words.length - 1;i > 0;i--) {
            // check if anagram if yes then don't add to strs and move to next index
            if (!anagram(words[i], words[i - 1], count))
                strs.add(0, words[i]);
        }

        strs.add(0, words[0]);

        return strs;
    }

    private boolean anagram(String str1, String str2, int[] count) {
        char[] first = str1.toCharArray();
        char[] second = str2.toCharArray();

        boolean result = true;

        for (char ch : first) {
            count[ch - 'a']++;
        }

        for (char ch : second) {
            count[ch - 'a']--;
        }

        for (int i = 0; i < 26;i++) {
            if (count[i] != 0) {
                if (result == true) {
                    result = false;
                }
                count[i] = 0;
            }
        }

        return result;
    }
}


```