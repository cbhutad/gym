# Problem

[Problem Link](https://leetcode.com/problems/count-elements-with-maximum-frequency/description/?envType=daily-question&envId=2025-09-22)

## Solution

``` java

class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] count = new int[100];
        int max = -1, totalFrequencies = 0;

        for (Integer i : nums) {
            count[i - 1]++;
            if (max < count[i - 1]) {
                max = count[i-1];
            }
        }

        for (Integer i : count) {
            if (i == max) {
                totalFrequencies += max;
            }
        }

        return totalFrequencies;
    }
}


```
