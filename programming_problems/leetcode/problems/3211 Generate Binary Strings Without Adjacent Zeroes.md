# Problem

[Problem Link](https://leetcode.com/problems/generate-binary-strings-without-adjacent-zeros/description)

You are given a positive integer n.

A binary string x is valid if all substrings of x of length 2 contain at least one "1".

Return all valid strings with length n, in any order.

 

Example 1:

Input: n = 3

Output: ["010","011","101","110","111"]

Explanation:

The valid strings of length 3 are: "010", "011", "101", "110", and "111".

Example 2:

Input: n = 1

Output: ["0","1"]

Explanation:

The valid strings of length 1 are: "0" and "1".

Constraints:

1 <= n <= 18

# Solution

## MySolution

``` java

class Solution {
    public List<String> validString(int n) {
        int max = (int)(Math.pow(2,n) - 1);
        List<String> strings = new ArrayList<>();
        for (int i = 0;i <= max;i++) {
            String str = binaryString(i, n);
            if (!str.contains("00"))
                strings.add(str);
        }
    }

    private String binaryString(int i, int n) {
        StringBuffer sb = new StringBuffer("");
        while (i != 0) {
            sb.append(i % 2);
            i = i / 2;
        }
        while (sb.length() < n) {
            sb.append("0");
        }
        return sb.reverse().toString();
    }
}

```