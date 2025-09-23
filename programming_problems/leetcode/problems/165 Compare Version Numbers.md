# Problem

[Problem Link](https://leetcode.com/problems/compare-version-numbers/description/)

# Solution

## MySolution

``` java

class Solution {
    public int compareVersion(String version1, String version2) {
        String[] versions1 = version1.split("\\.");
        String[] versions2 = version2.split("\\.");

        int max = versions1.length >= versions2.length ? versions1.length : versions2.length;

        int[] versions1Int = new int[max];
        int[] versions2Int = new int[max];

        int index = 0;
        for(String str : versions1) {
            versions1Int[index++] = Integer.parseInt(str);
        }
        index = 0;
        for(String str : versions2) {
            versions2Int[index++] = Integer.parseInt(str);
        }
        
        for (int i = 0;i < max;i++) {
            if (versions1Int[i] < versions2Int[i]) {
                return -1;
            } else if (versions1Int[i] > versions2Int[i]) {
                return 1;
            } 
        }

        return 0;

    }
}

```